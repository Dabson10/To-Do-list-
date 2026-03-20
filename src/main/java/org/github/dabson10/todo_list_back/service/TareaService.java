package org.github.dabson10.todo_list_back.service;

import org.github.dabson10.todo_list_back.DTOs.TareaDTO;
import org.github.dabson10.todo_list_back.entity.Tarea;
import org.github.dabson10.todo_list_back.entity.Usuario;
import org.github.dabson10.todo_list_back.repository.InTareaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService implements InTareaService {

    final InTareaRepository taRe;

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
        return formatearDTO(tar);
    }

    @Override
    public List<TareaDTO> traerTareas() {
        List<Tarea> lista = taRe.findAll();
        List<TareaDTO> listDTO = new ArrayList<>();

        for (Tarea tarea : lista) {

            TareaDTO tare = formatearDTO(tarea);
            listDTO.add(tare);
        }


        return listDTO;
    }

    public TareaDTO formatearDTO(Tarea tar){
        TareaDTO tareDto = new TareaDTO();
        Usuario usu = tar.getUsuario();
        tareDto.setId_tarea(tar.getId_tarea());
        tareDto.setNombre(tar.getNombre());
        tareDto.setDescripcion(tar.getDescripcion());
        tareDto.setEstado(tar.getEstado());
        tareDto.setPrioridad(tar.getPrioridad());
        tareDto.setFecha_creacion(tar.getFecha_creacion());
        tareDto.setFecha_limite(tar.getFecha_limite());
        tareDto.setId_usuario(usu.getId());
        return tareDto;
    }

    @Override
    public void editarTarea(TareaDTO tareaDTO) {

    }

    @Override
    public void editarEstado(TareaDTO tareaDTO) {

    }
}
