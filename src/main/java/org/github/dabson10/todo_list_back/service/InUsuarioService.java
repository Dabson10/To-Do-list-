package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.UsuarioTareasDTO;
import org.github.dabson10.todo_list_back.DTOs.UsuarioUpdateDTO;
import org.github.dabson10.todo_list_back.entity.Credencial;
import org.github.dabson10.todo_list_back.entity.Usuario;

public interface InUsuarioService {

    public Usuario crearUsuario(Usuario usuario);
    Usuario getUsuario(Long id);
    public UsuarioTareasDTO traerUsuario(Credencial credencial);


    public boolean editUsuario(UsuarioUpdateDTO usuario);
}
