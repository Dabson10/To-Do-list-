package org.github.dabson10.todo_list_back.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.github.dabson10.todo_list_back.entity.Usuario;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class TareaDTO {
    private Long id_tarea;
    private String nombre;
    private String descripcion;
    private String estado;
    private String prioridad;
    private LocalDate fecha_creacion;
    private LocalDate fecha_limite;
    private Long id_usuario;
}
