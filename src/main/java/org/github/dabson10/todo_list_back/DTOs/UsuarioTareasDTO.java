package org.github.dabson10.todo_list_back.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class UsuarioTareasDTO {
    private Long id_usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private List<TareaDTO> tareas;

}
