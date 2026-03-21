package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.repository.InTareaRepository;
import org.github.dabson10.todo_list_back.utilidades.FormatearTarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService implements InTareaService {

    final InTareaRepository taRe;
    FormatearTarea formDTO = new FormatearTarea();
    public TareaService(InTareaRepository taRe) {
        this.taRe = taRe;
    }

    @Override
    public void crearTarea(Tarea tarea) {
        taRe.save(tarea);
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
