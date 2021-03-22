package fi.kesko.factory.service;

import fi.kesko.factory.model.CheapestCombination;
import fi.kesko.factory.model.CustomerRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactoryServiceTest {
    @Test
    public void testCalculation() throws Exception {
        FactoryService service = new FactoryService();
        CustomerRequest request = new CustomerRequest(895, 2.5f, 80f, 400f, 40, 200);
        CheapestCombination expected = new CheapestCombination(4, 2, 15, 1797.5f);
        CheapestCombination response = service.getCheapestPriceCombo(request);
        assertEquals(response.toString(), expected.toString());
    }
}
