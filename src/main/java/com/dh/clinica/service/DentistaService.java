package com.dh.clinica.service;

import com.dh.clinica.model.Dentista;
import com.dh.clinica.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    private IDao<Dentista> dentistaDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaDao = dentistaIDao;
    }

    public Dentista salvar(Dentista dentista){
        return dentistaDao.salvar(dentista);
    }

    public List<Dentista> buscarTodos(){
        return dentistaDao.buscarTodos();
    }

    public void excluir(Integer id) {
        dentistaDao.excluir(id);
    }
}
