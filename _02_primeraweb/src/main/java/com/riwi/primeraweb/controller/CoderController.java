package com.riwi.primeraweb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.services.CoderService;

@Controller
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    @GetMapping
    // Metodo para mostrar la vista y enviarle la lista coders
    public String showViewGetAll(Model objModel){

        // Llamo el servicio y guardo la lista de coders
        List<Coder> list = this.objCoderService.findAll();
        objModel.addAttribute("coderList", list); // LLave - valor

        // Se debe retornar el nombre exacto de la vista HTML
        return "viewCoder";
    }
}
