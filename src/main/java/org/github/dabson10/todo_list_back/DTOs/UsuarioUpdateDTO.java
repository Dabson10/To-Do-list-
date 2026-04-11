package org.github.dabson10.todo_list_back.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioUpdateDTO {
    private Long id;
    private String nombre;
    private String apellido;
}
