package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;

import java.util.List;

public interface InTareaService {
    public void crearTarea(Tarea tarea);

    public List<TareaDTO> traerTareasUsuario(Long id_usuario);
    public Tarea getTarea(Long id);
    public TareaDTO traerTarea(Long id);

    public List<TareaDTO> traerTareas();

    public void editarTarea(Tarea tarea);
    public void editarEstado(Tarea tarea);

    public void eliminarTarea(Long id);


}
