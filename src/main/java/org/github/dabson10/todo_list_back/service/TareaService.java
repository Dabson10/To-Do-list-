package org.github.dabson10.todo_list_back.service;

import lombok.AllArgsConstructor;
import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.entity.Usuario;
import org.github.dabson10.todo_list_back.repository.InTareaRepository;
import org.github.dabson10.todo_list_back.repository.InUsuarioRepository;
import org.github.dabson10.todo_list_back.utilidades.FormatearTarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @AllArgsConstructor
public class TareaService implements InTareaService {

    /**
     * Gracias al {@code @AllArgsConstructor} ya no necesito hacer el constructor de las
     * instancias.
     */
    final InTareaRepository taRe;
    final UsuarioService usuRe;
    final FormatearTarea formDTO;


    @Override
    public void crearTarea(Tarea tarea) {
        taRe.save(tarea);
    }

    //Esta función realizará un findUsuario con el objeto de la clase UsuarioService y ahi obtienes el objeto
    @Override
    public List<TareaDTO> traerTareasUsuario(Long id_usuario) {
        List<Tarea> tareas = taRe.findTareasByUsuario_Id(id_usuario);
        List<TareaDTO> lisTarea = new ArrayList<>();
        for(Tarea tarea : tareas){
            lisTarea.add(formDTO.formatearDTO(tarea));
        }
        return lisTarea;
    }

    @Override
    public Tarea getTarea(Long id) {
        return taRe.findById(id).orElse(null);
    }

    @Override
    public TareaDTO traerTarea(Long id) {
        Tarea tar = this.getTarea(id);
        return formDTO.formatearDTO(tar);
    }

    @Override
    public List<TareaDTO> traerTareas() {
        List<Tarea> lista = taRe.findAll();
        List<TareaDTO> listDTO = new ArrayList<>();

        for (Tarea tarea : lista) {

            TareaDTO tare = formDTO.formatearDTO(tarea);
            listDTO.add(tare);
        }


        return listDTO;
    }



    @Override //Usando método PUT
    public void editarTarea(Tarea tarea) {
        Tarea tare = this.getTarea(tarea.getId_tarea());
        tare = formDTO.formatearTarea(tare, tarea);

        taRe.save(tare);
    }

    @Override //Usando método PATCH
    public void editarEstado(Tarea tarea) {
        Tarea tar = this.getTarea(tarea.getId_tarea());
        tar.setEstado(tarea.getEstado());
        taRe.save(tar);
    }

    @Override
    public void eliminarTarea(Long id) {
        taRe.deleteById(id);
    }
}
