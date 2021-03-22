package fi.kesko.factory.service;

import fi.kesko.factory.model.CheapestCombination;
import fi.kesko.factory.model.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class FactoryService {

    public CheapestCombination getCheapestPriceCombo(CustomerRequest customerRequest) {
        Integer boxCount = 0;
        Integer packCount = 0;
        Integer barCount = 0;
        Float totalPrice = 0.0f;
        Integer remaining = customerRequest.getCount();
        Integer boxSize = customerRequest.getBoxSize();
        Integer packSize = customerRequest.getPackSize();
        do {
            if (remaining > boxSize) {
                boxCount = remaining / boxSize;
                remaining = remaining % boxSize;
                totalPrice += boxCount * customerRequest.getBoxPrice();
            } else if (remaining > packSize) {
                packCount = remaining / packSize;
                remaining = remaining % packSize;
                totalPrice += packCount * customerRequest.getPackPrice();
            } else {
                barCount = remaining;
                remaining = 0;
                totalPrice += barCount * customerRequest.getBarPrice();
            }
        } while (remaining > 0);
        return new CheapestCombination(boxCount, packCount, barCount, totalPrice);
    }
}
