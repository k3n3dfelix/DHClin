package com.dh.clinica.service;

import com.dh.clinica.model.Usuario;
import com.dh.clinica.service.impl.UsuarioDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDaoImpl usuarioDao;

    public UsuarioService(UsuarioDaoImpl usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioDao.salvar(usuario);
    }

    public List<Usuario> buscarTodos(){
        return usuarioDao.buscarTodos();
    }

    public void excluir(Integer id) {
        usuarioDao.excluir(id);
    }
}
