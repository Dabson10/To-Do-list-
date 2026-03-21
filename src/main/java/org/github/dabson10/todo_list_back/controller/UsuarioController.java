package org.github.dabson10.todo_list_back.controller;

import org.github.dabson10.todo_list_back.DTOs.UsuarioTareasDTO;
import org.github.dabson10.todo_list_back.entity.Credencial;
import org.github.dabson10.todo_list_back.entity.Usuario;
import org.github.dabson10.todo_list_back.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService seUs;

    public UsuarioController(UsuarioService seUs){
        this.seUs = seUs;
    }


    @PostMapping("/crear")
    public void crearUsuario(
            @RequestBody Usuario usuario
    ){
        seUs.crearUsuario(usuario);
    }


    @PostMapping("/traer")
    public UsuarioTareasDTO traerUsuario(
            @RequestBody Credencial credencial
    ){
        return seUs.traerUsuario(credencial);
    }




}
