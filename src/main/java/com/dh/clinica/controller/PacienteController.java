package com.dh.clinica.controller;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.impl.PacienteDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteDaoImpl pacienteService;

    @GetMapping("/buscar")
    public List<Paciente> listarTodos() {
        return pacienteService.buscarTodos();
    }

    @DeleteMapping("{id}")
    public void deletarPaciente( @PathVariable Integer id) {
        pacienteService.excluir(id);
    }

    @PostMapping
    public Paciente cadastrar(@RequestBody Paciente paciente){
        return pacienteService.salvar(paciente);
    }
}
