package org.github.dabson10.todo_list_back.repository;

import org.github.dabson10.todo_list_back.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InTareaRepository extends JpaRepository<Tarea, Long> {


}
