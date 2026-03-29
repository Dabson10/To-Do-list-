package org.github.dabson10.todo_list_back.controller;

import org.github.dabson10.todo_list_back.DTOs.UsuarioTareasDTO;
import org.github.dabson10.todo_list_back.entity.Credencial;
import org.github.dabson10.todo_list_back.entity.Usuario;
import org.github.dabson10.todo_list_back.service.UsuarioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "https://to-do-dabson.netlify.app")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService seUs;

    public UsuarioController(UsuarioService seUs){
        this.seUs = seUs;
    }


    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(
            @RequestBody Usuario usuario
    ){
        Usuario usu = seUs.crearUsuario(usuario);
        if(usu == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return new ResponseEntity<>(usu, HttpStatus.OK);
    }


    @PostMapping("/traer")
    public ResponseEntity<UsuarioTareasDTO> traerUsuario(
            @RequestBody Credencial credencial
    ){
        UsuarioTareasDTO usuarioConfirmed = seUs.traerUsuario(credencial);
        if(usuarioConfirmed == null){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return new ResponseEntity<>(usuarioConfirmed, HttpStatus.OK);
    }




}
