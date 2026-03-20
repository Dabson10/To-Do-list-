package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;

import java.util.List;

public interface InTareaService {
    public void crearTarea(Tarea tarea);

    public Tarea getTarea(Long id);
    public TareaDTO traerTarea(Long id);

    public List<TareaDTO> traerTareas();

    public void editarTarea(TareaDTO tareaDTO);
    public void editarEstado(TareaDTO tareaDTO);


}
