package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//Indica que esta clase será un controlador
@Controller
//RequestMapping Crea la ruta del controlador
@RequestMapping("/controller")
public class HolaMundo {

    // Crea una ruta específica para el método
    @GetMapping("/holamundo")
    // Response body nos permite responder en el navegador
    @ResponseBody
    public String mostrarMensaje(){
        return "Hola mundo";
    }

    @GetMapping("/suma")
    @ResponseBody
    public String sumarNumeros(){
        int a = 2, b= 5;
        return String.valueOf(a + b);
    }

}