package com.test.SpringbootTest.controller;

import com.test.SpringbootTest.model.Persona;
import com.test.SpringbootTest.service.IPersonaService;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    // List<Persona> listaPersonas = new ArrayList();

    /* @GetMapping("/hola/{nombre}/{apellido}/{edad}")
    public String decirHola(
            @PathVariable String nombre,
            @PathVariable String apellido,
            @PathVariable int edad) {
        return " " + " Hola Mundo " + " Nombre : " + nombre + "Apellido :  " + apellido + " Edad :  " + edad;

    }

    @GetMapping("/chau")
    public String decirChau(@RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad) {
        return "Chau mundo" + " Nombre : " + nombre + "Apellido :  " + apellido + " Edad :  " + edad;
    }
     */
    @Autowired
    private IPersonaService persoServ;
    
    @PostMapping("new/persona")
    public void agregarPersona(@RequestBody Persona pers) {
        
        persoServ.crearPersona(pers);

     // listaPersonas.add(pers);
    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    
    public List<Persona> verPersonas() {
        return persoServ.verPersona();
    // return listaPersonas;
    }
    
    @DeleteMapping("delete/{id}")
    public void borrarPersona(@PathVariable Long id) {
        
        persoServ.borrarPersona(id);
        
    }
    
    
}
