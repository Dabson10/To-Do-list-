package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.UsuarioTareasDTO;
import org.github.dabson10.todo_list_back.entity.Credencial;
import org.github.dabson10.todo_list_back.entity.Usuario;

public interface InUsuarioService {

    public void crearUsuario(Usuario usuario);
    Usuario getUsuario(Long id);
    public UsuarioTareasDTO traerUsuario(Credencial credencial);


    public void editUsuario(Long id, String nombre);
}
