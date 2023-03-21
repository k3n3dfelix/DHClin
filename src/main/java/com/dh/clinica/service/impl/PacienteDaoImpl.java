package com.dh.clinica.service.impl;

import com.dh.clinica.config.ConfiguracaoJDBC;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.IDao;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteDaoImpl implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC ;

    public PacienteDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }
    @Override
    public Paciente salvar(Paciente paciente) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("INSERT INTO PACIENTE (nome ,sobrenome, idade) " +
                        "VALUES ('%s','%s','%s')", paciente.getNome(),
                paciente.getSobrenome(), paciente.getIdade());
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                paciente.setId(keys.getInt(1));
            stmt.close();
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT * FROM PACIENTE";
        List<Paciente> pacientes = new ArrayList<>();
        try {
            stmt = conexao.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                pacientes.add(criarObjetoPaciente(result));
            }
            stmt.close();
            conexao.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public void excluir(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM PACIENTE WHERE id = %s", id);
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conexao.close();
        } catch (SQLException throwables) {

        }
    }

    private Paciente criarObjetoPaciente(ResultSet resultado) throws SQLException {
        Integer id = resultado.getInt("id");
        String nome = resultado.getString("nome");
        String sobrenome = resultado.getString("sobrenome");
        Integer idade = resultado.getInt("idade");
        Paciente paciente = new Paciente(id, nome, sobrenome, idade);
        return paciente;
    }

}
