package com.example.aug2023.controller;

import com.example.aug2023.service.CalculateRestService;
import com.example.aug2023.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @Autowired //requesting for an object/bean from the spring container
    CalculatorService calculatorService;

    @Autowired
    CalculateRestService calculateRestService;

    private static Logger log = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/divide/{firstNumber}/{secondNumber}")
    public ResponseEntity<Object> divide(@PathVariable("firstNumber") double firstNumber,
                                 @PathVariable("secondNumber") double secondNumber){
        log.info("INSIDE THE CALCULATE CONTROLLER");
        log.info("FIRST NUMBER: "+firstNumber+" and SECOND NUMBER: "+secondNumber);

        if(secondNumber == 0){
            log.error("DIVIDE BY 0 IS NOT POSSIBLE");
            return new ResponseEntity<>("INPUT IS INCORRECT, PLEASE CHECK AND TRY AGAIN", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(calculatorService.divide(firstNumber, secondNumber), HttpStatus.OK);
        }
    }

    @GetMapping("/add/{first}/{second}")
    public double add(@PathVariable("first") double first,
                      @PathVariable("second") double second){
        return calculateRestService.calculateAddtion(first, second);
    }

}