package org.github.dabson10.todo_list_back.repository;

import org.github.dabson10.todo_list_back.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InUsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByCorreo(String correo);
}
