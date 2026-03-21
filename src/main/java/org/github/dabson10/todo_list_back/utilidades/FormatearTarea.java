package org.github.dabson10.todo_list_back.utilidades;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.entity.Usuario;

public class FormatearTarea {

    public TareaDTO formatearDTO(Tarea tar){
        TareaDTO tareDto = new TareaDTO();
        Usuario usu = tar.getUsuario();
        tareDto.setId_tarea(tar.getId_tarea());
        tareDto.setNombre(tar.getNombre());
        tareDto.setDescripcion(tar.getDescripcion());
        tareDto.setEstado(tar.getEstado());
        tareDto.setPrioridad(tar.getPrioridad());
        tareDto.setFecha_creacion(tar.getFecha_creacion());
        tareDto.setFecha_limite(tar.getFecha_limite());
        tareDto.setId_usuario(usu.getId());
        return tareDto;
    }

    public Tarea formatearTarea(Tarea tareaE, Tarea tareaN) {
        tareaE.setId_tarea(tareaN.getId_tarea());
        tareaE.setNombre(tareaN.getNombre());
        tareaE.setDescripcion(tareaN.getDescripcion());
        tareaE.setEstado(tareaN.getEstado());
        tareaE.setPrioridad(tareaN.getPrioridad());
        tareaE.setFecha_creacion(tareaN.getFecha_creacion());
        tareaE.setFecha_limite(tareaN.getFecha_limite());
        tareaE.setUsuario(tareaN.getUsuario());
        return tareaE;
    }


}
