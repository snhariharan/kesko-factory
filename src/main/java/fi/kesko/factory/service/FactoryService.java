package fi.kesko.factory.service;

import fi.kesko.factory.model.CheapestCombination;
import fi.kesko.factory.model.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class FactoryService {
    private Integer boxCount = 0;
    private Integer packCount = 0;
    private Integer barCount = 0;

    public CheapestCombination getCheapestPriceCombo(CustomerRequest request) {
        Integer boxSize = request.getBoxSize();
        Integer packSize = request.getPackSize();
        getTotalCounts(request.getCount(), boxSize, packSize);
        Float totalPrice = (boxCount * request.getBoxPrice())
                + (packCount * request.getPackPrice())
                + (barCount * request.getBarPrice());
        return new CheapestCombination(boxCount, packCount, barCount, totalPrice);
    }

    private void getTotalCounts(Integer counter, Integer boxSize, Integer packSize) {
        do {
            if (counter > boxSize) {
                boxCount = counter / boxSize;
                counter %= boxSize;
            } else if (counter > packSize) {
                packCount = counter / packSize;
                counter %= packSize;
            } else {
                barCount = counter;
                break;
            }
        } while (counter > 0);
    }
}
