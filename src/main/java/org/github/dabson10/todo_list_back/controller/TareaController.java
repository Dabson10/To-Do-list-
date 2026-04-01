package org.github.dabson10.todo_list_back.controller;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.service.TareaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://127.0.0.1:5500")
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
    public ResponseEntity<Tarea> crearTarea(
            @RequestBody Tarea tarea
    ){
        taRe.crearTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarea);
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

    @GetMapping("/usuario/{id_usuario}")
    public List<TareaDTO> getTareasUsuario(
            @PathVariable Long id_usuario
    ){
        return taRe.traerTareasUsuario(id_usuario);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarTarea(
            @PathVariable Long id
    ){
        taRe.eliminarTarea(id);
        return new ResponseEntity <>("Tarea borrada", HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editarTarea(
            @RequestBody Tarea tarea
    ){
        taRe.editarTarea(tarea);
        return new ResponseEntity<>("Tarea editada", HttpStatus.OK);
    }

    @PatchMapping("/estado")
    public ResponseEntity<String> estadoTarea(
            @RequestBody Tarea tarea
    ){
        taRe.editarEstado(tarea);
        return new ResponseEntity<>("Estado cambiado.", HttpStatus.OK);
    }




}
