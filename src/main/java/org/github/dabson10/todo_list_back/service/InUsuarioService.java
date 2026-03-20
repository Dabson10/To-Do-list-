package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.UsuarioTareasDTO;
import org.github.dabson10.todo_list_back.entity.Usuario;

public interface InUsuarioService {

    public void crearUsuario(Usuario usuario);
    Usuario getUsuario(Long id);
    public UsuarioTareasDTO traerUsuario(String correo, String clave);
    public Usuario validarUsuario(String correo, String clave);


    public void editUsuario(Long id, String nombre);
}
