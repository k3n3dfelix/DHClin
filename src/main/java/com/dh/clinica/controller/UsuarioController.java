package com.dh.clinica.controller;

import com.dh.clinica.model.Usuario;
import com.dh.clinica.service.UsuarioService;
import com.dh.clinica.service.impl.UsuarioDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/buscar")
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @DeleteMapping("{id}")
    public void deletarUsuario( @PathVariable Integer id) {
        usuarioService.excluir(id);
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }


}
