/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Guilherme Gehling
 */
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Cliente cliente) throws SQLException {
        if (this.valida(cliente)) {
            String sql = "INSERT INTO cliente (cod_cliente, nome, email, telefone, username, senha, cpf, cnh, endereco, bairro, complemento, uf, cidade) "
                    + "VALUES (NEXTVAL('seq_cliente'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getUsername());
            pst.setString(5, cliente.getSenha());
            pst.setInt(6, cliente.getCpf());
            pst.setInt(7, cliente.getCnh());
            pst.setString(8, cliente.getEndereco());
            pst.setString(9, cliente.getBairro());
            pst.setString(10, cliente.getComplemento());
            pst.setString(11, cliente.getUf());
            pst.setString(12, cliente.getCidade());
            pst.executeUpdate();
            Statement st = this.conexao.createStatement();
            ResultSet rst = st.executeQuery("SELECT CURRVAL('seq_cliente')");
            if (rst.next()) {
                cliente.setCod(rst.getInt(1));
            }
            rst.close();
            st.close();
            pst.close();
        }
    }

    public Cliente retrive(Cliente cliente) throws SQLException {
        Cliente clienteret = null;
        String sql = "SELECT * FROM cliente WHERE username=? and senha=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setString(1, cliente.getUsername());
        pst.setString(2, cliente.getSenha());
        ResultSet rst = pst.executeQuery();
        if (rst.next()) {
            clienteret = new Cliente();
            clienteret.setCod(rst.getInt("cod_cliente"));
            clienteret.setNome(rst.getString("nome"));
            clienteret.setEmail(rst.getString("email"));
            clienteret.setTelefone(rst.getString("telefone"));
            clienteret.setUsername(rst.getString("username"));
            clienteret.setSenha(rst.getString("senha"));
            clienteret.setCpf(rst.getInt("cpf"));
            clienteret.setCnh(rst.getInt("cnh"));
            clienteret.setEndereco(rst.getString("endereco"));
            clienteret.setBairro(rst.getString("bairro"));
            clienteret.setComplemento(rst.getString("complemento"));
            clienteret.setUf(rst.getString("uf"));
            clienteret.setCidade(rst.getString("cidade"));
        }
        rst.close();
        pst.close();
        return clienteret;
    }

    public void update(Cliente cliente) throws SQLException {
        if (this.valida(cliente)) {
            String sql = "UPDATE cliente SET nome=?, email=?, telefone=?, username=?, senha=?, cpf=?, cnh=?, endereco=?, bairro=?, complemento=?, uf=?, cidade=? WHERE cod_cliente=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getUsername());
            pst.setString(5, cliente.getSenha());
            pst.setInt(6, cliente.getCpf());
            pst.setInt(7, cliente.getCnh());
            pst.setString(8, cliente.getEndereco());
            pst.setString(9, cliente.getBairro());
            pst.setString(10, cliente.getComplemento());
            pst.setString(11, cliente.getUf());
            pst.setString(12, cliente.getCidade());
            pst.setInt(13, cliente.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE cod=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, cliente.getCod());
        pst.executeQuery();
        pst.close();
    }

    public boolean valida(Cliente cliente) {
        boolean verf = false;
        if (cliente != null) {
            verf = true;
        }
        return verf;
    }
}
