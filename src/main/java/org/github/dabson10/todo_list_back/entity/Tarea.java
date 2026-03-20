package org.github.dabson10.todo_list_back.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_tarea;
    @Basic
    private String nombre;
    private String descripcion;
    private String estado;
    private String prioridad;
    private LocalDate fecha_creacion;
    private LocalDate fecha_limite;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Tarea(){}

    public Tarea(Long id_tarea, String nombre, String descripcion, String estado, String prioridad, LocalDate fecha_creacion, LocalDate fecha_limite, Usuario usuario) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.usuario = usuario;
    }
}
