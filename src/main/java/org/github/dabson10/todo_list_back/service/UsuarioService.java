package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.UsuarioTareasDTO;
import org.github.dabson10.todo_list_back.entity.Usuario;
import org.github.dabson10.todo_list_back.repository.InUsuarioRepository;
import org.github.dabson10.todo_list_back.utilidades.OcultarClaves;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements InUsuarioService{

    final InUsuarioRepository usuRe;
    OcultarClaves ocultarC = new OcultarClaves();

    public UsuarioService(InUsuarioRepository usuRe){
        this.usuRe = usuRe;
    }


    /**
     * Función para crear un usuario y encriptar la contraseña.
     * @param usuario : Objeto que contendrá la información del usuario.
     */
    @Override
    public void crearUsuario(Usuario usuario) {
        String contraOculta = ocultarC.ocultarContrasI(usuario.getClave());
        usuario.setClave(contraOculta);
        usuRe.save(usuario);
    }

    //====================== FUNCIONES DE BÚSQUEDA ================================
    /**
     * Esta función es de búsqueda, para poder obtener un usuario mediante correo electrónico
     * @param id : Id del usuario
     * @return : Regresará un objeto del tipo Usuario
     */
    @Override
    public Usuario getUsuario(Long id){
        return usuRe.findById(id).orElse(null);
    }

    /**
     * Función para buscar un correo mediante correo electrónico, este también funciona como validación
     * de contraseña para asi poder acceder a las tareas.
     * @param correo : Correo del usuario.
     * @param clave : Contraseña plana del usuario.
     * @return : Regresará un objeto el cual contendrá una lista de los datos del usuario y de las tareas
     */
    @Override
    public UsuarioTareasDTO traerUsuario(String correo, String clave) {
        Usuario usuario = usuRe.findByCorreo(correo);
        return null;
    }


    @Override
    public Usuario validarUsuario(String correo, String clave) {
//        Usuario
        return null;
    }

    @Override
    public void editUsuario(Long id, String nombre) {

    }
}
