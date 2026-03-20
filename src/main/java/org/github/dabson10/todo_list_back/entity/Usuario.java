package org.github.dabson10.todo_list_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Basic
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    @OneToMany(mappedBy = "usuario")
    private List<Tarea> tareas;


    public Usuario(){}

    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", tareas=" + tareas +
                '}';
    }
}
