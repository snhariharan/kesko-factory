package fi.kesko.factory.controller;

import fi.kesko.factory.model.CheapestCombination;
import fi.kesko.factory.model.CustomerRequest;
import fi.kesko.factory.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactoryController {

    @Autowired
    private FactoryService service;

    @PostMapping("/price")
    public ResponseEntity<CheapestCombination> getCheapCombo(@RequestBody CustomerRequest request) {
        CheapestCombination response = service.getCheapestPriceCombo(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
