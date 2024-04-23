package com.example.riwi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.riwi.entity.Operations;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationsController {
    
    @PostMapping(path = "/add")
    public String add(@RequestBody Operations objOperations){
        String message = String.valueOf(objOperations.getNum1() + objOperations.getNum2());
        return objOperations.getNum1() + "+" + objOperations.getNum2() + "=" + message;
    }

    @PostMapping(path = "/sub")
    public String substraction(@RequestBody Operations objOperations){
        String message = String.valueOf(objOperations.getNum1() - objOperations.getNum2());
        return objOperations.getNum1() + "-" + objOperations.getNum2() + "=" + message;
    }

    @PostMapping(path = "/multiplication")
    public String multiplication(@RequestBody Operations objOperations){
        String message = String.valueOf(objOperations.getNum1() * objOperations.getNum2());
        return objOperations.getNum1() + "x" + objOperations.getNum2() + "=" + message;
    }

    
    @PostMapping(path = "/division")
    public String division(@RequestBody Operations objOperations){
        if(objOperations.getNum2()== 0){
            return "No se pueden dividir números entre cero";
        }
        else{
            String message = String.valueOf(objOperations.getNum1() / objOperations.getNum2());
            return objOperations.getNum1() + "/" + objOperations.getNum2() + "=" + message;
        }
    }

}
