package org.github.dabson10.todo_list_back.controller;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    final TareaService taRe;

    public TareaController(TareaService taRe){
        this.taRe = taRe;
    }

    /**
     * Esta forma es la que se manda el JSON en postman
     * --- para crear tareas.
     * {
     *  "nombre" : "Lavar al perro",
     *  "descripcion" : "Bañar al goyo",
     *  "estado" : "Pendiente",
     *  "prioridad" : "Alta",
     *  "fecha_creacion" : "2025-03-29",
     *  "fecha_limite" : "2025-03-29",
     *  "usuario" : {
     *     "id" : 1
     *  }
     * }
     */
    @PostMapping("/crear")
    public void crearTarea(
            @RequestBody Tarea tarea
    ){
        taRe.crearTarea(tarea);
    }



    @GetMapping("/traer")
    public TareaDTO traerTarea(
            @RequestParam Long id
    ){
        return taRe.traerTarea(id);
    }

    @GetMapping("/traer/tareas")
    public List<TareaDTO> getTareas(){
        return taRe.traerTareas();
    }



}
