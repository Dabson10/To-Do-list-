package org.github.dabson10.todo_list_back.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String correo;

}
