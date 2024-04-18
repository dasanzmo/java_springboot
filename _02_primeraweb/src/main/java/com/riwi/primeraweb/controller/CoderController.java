package com.riwi.primeraweb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/form")
    public String showViewFormCoder(Model objModel){
        objModel.addAttribute("coder", new Coder());
        objModel.addAttribute("action", "/coder/create");
        return "viewForm";
    }

    // Método para mostrar el formulario de actualizar un coder
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Long id, Model objModel){

        Coder objCoderFind = this.objCoderService.findById(id);
        objModel.addAttribute("coder", objCoderFind);
        objModel.addAttribute("action", "/edit/"+id);

        return "viewForm";
    }

    // Método para eliminar

    // @GetMapping("/delete/{id}")
    // public String deleteCoder(@PathVariable Long id, @ModelAttribute Coder obCoder){
    //     this.objCoderService.delete(obCoder);
    //     return "redirect:/";
    // }

    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id){
        this.objCoderService.delete(id);
        return "redirect:/";
    }

    // Método para actualizar
    @PostMapping("/edit/{id}")
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder objCoder){
        this.objCoderService.update(id, objCoder);
        return "redirect:/";
    }

    // Método para insertar un coder mediante el verbo POST
    //@ModelAttribute se encarga de obtener la información enviada desde la vista
    @PostMapping("/coder/create")
    public String createCoder(@ModelAttribute Coder objCoder){
        // LLamamos al servicio para que inserte enviándole un Coder a insertar
        this.objCoderService.insert(objCoder);
        return "redirect:/";
    }


}
