package com.dh.clinica.controller;

import com.dh.clinica.model.Dentista;
import com.dh.clinica.model.Usuario;
import com.dh.clinica.service.DentistaService;
import com.dh.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @GetMapping("/buscar")
    public List<Dentista> buscarTodos() {
        return dentistaService.buscarTodos();
    }

    @DeleteMapping("{id}")
    public void deletar( @PathVariable Integer id) {
        dentistaService.excluir(id);
    }

    @PostMapping
    public Dentista salvar(@RequestBody Dentista dentista){
        return dentistaService.salvar(dentista);
    }
}
