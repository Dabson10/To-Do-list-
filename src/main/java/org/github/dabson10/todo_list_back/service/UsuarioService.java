package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.DTOs.UsuarioTareasDTO;
import org.github.dabson10.todo_list_back.entity.Credencial;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.entity.Usuario;
import org.github.dabson10.todo_list_back.repository.InUsuarioRepository;
import org.github.dabson10.todo_list_back.utilidades.FormatearTarea;
import org.github.dabson10.todo_list_back.utilidades.OcultarClaves;
import org.github.dabson10.todo_list_back.utilidades.ValidarClave;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements InUsuarioService{

    final InUsuarioRepository usuRe;
    OcultarClaves ocultarC = new OcultarClaves();
    ValidarClave validarC = new ValidarClave();
    FormatearTarea formDTO = new FormatearTarea();

    public UsuarioService(InUsuarioRepository usuRe){
        this.usuRe = usuRe;
    }


    /**
     * Función para crear un usuario y encriptar la contraseña.
     *
     * @param usuario : Objeto que contendrá la información del usuario.
     */
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Usuario usu = usuRe.findByCorreo(usuario.getCorreo());
        //Si encuentra un usuario que no sea null, entonces regresamos, por que ya existe un usuario con ese
        //correo
        if(usu != null){
            return null;
        }
        //Si no encontro usuario entonces regresamos el objeto.
        String contraOculta = ocultarC.ocultarContrasI(usuario.getClave());
        usuario.setClave(contraOculta);
        return usuRe.save(usuario);
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
     * @param credencial : Un objeto que contiene los datos fundamentales del usuario como correo y contraseña
     * @return : Regresará un objeto el cual contendrá una lista de los datos del usuario y de las tareas
     */
    @Override
    public UsuarioTareasDTO traerUsuario(Credencial credencial) {
        Usuario usuario = usuRe.findByCorreo(credencial.getCorreo());
        if(usuario == null){
            return null;
        }

        if(!validarC.validarClave(credencial.getClave(), usuario.getClave())){
            return null;
        }
        UsuarioTareasDTO usuTa = new UsuarioTareasDTO();
        List<Tarea> list = usuario.getTareas();
        List<TareaDTO> listDTO = new ArrayList<>();
        usuTa.setId_usuario(usuario.getId());
        usuTa.setNombre(usuario.getNombre());
        usuTa.setApellido(usuario.getApellido());
        usuTa.setCorreo(usuario.getCorreo());
        usuTa.setClave(usuario.getClave());

        for(Tarea tarea : list){
            TareaDTO tareaDTO = formDTO.formatearDTO(tarea);
            listDTO.add(tareaDTO);
        }
        usuTa.setTareas(listDTO);
        return usuTa;
    }

    @Override
    public void editUsuario(Long id, String nombre) {

    }
}
