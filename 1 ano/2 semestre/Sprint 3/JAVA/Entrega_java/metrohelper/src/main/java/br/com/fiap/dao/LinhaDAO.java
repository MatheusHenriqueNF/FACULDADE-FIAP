package br.com.fiap.dao;

import br.com.fiap.beans.Linha;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LinhaDAO {

    private Connection minhaConexao;

    public LinhaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Linha linha) throws SQLException {
        String sql = "INSERT INTO Challenge_Linha (nome_linha, status, id_usuario) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {
            stmt.setString(1, linha.getNomeLinha());
            stmt.setInt(2, linha.getStatus());
            stmt.setInt(3, linha.getValor());  // Insert the new variable
            stmt.execute();
        } finally {
            if (minhaConexao != null && !minhaConexao.isClosed()) {
                minhaConexao.close();
            }
        }
        return "Linha cadastrada com sucesso!";
    }
}