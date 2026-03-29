package org.github.dabson10.todo_list_back.repository;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.DTOs.UsuarioDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InTareaRepository extends JpaRepository<Tarea, Long> {
    public List<Tarea> findTareasByUsuario(Usuario usuario);

    List<Tarea> findTareasByUsuario_Id(Long usuarioId);
}
