/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Aluguel;
import bean.Cliente;
import bean.Veiculo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Guilherme Gehling
 */
public class AluguelDAO {

    private Connection conexao;

    public AluguelDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Aluguel aluguel) throws SQLException {
        if (this.verifica(aluguel)) {
            String sql = "INSERT INTO aluguel cod_aluguel, dt_inicio, dt_fim, cod_cliente, cod_veiculo"
                    + "VALUES (NEXTVAL('seq_aluguel')), ?, ?, ?, ?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            Date dtini = new Date(aluguel.getDt_inicio().getTime());
            pst.setDate(1, dtini);
            Date dtfim = new Date(aluguel.getDt_fim().getTime());
            pst.setDate(2, dtfim);
            pst.setInt(3, aluguel.getCliente().getCod());
            pst.setInt(4, aluguel.getVeiculo().getCod());
            pst.executeUpdate();
            Statement st = this.conexao.createStatement();
            ResultSet rst = st.executeQuery("SELECT CURRVAL('seq_aluguel')");
            if (rst.next()) {
                aluguel.setCod(rst.getInt(1));
            }
            rst.close();
            st.close();
            pst.close();
        }
    }

    public Aluguel retrive(Aluguel aluguel) throws SQLException {
        Aluguel aluret = null;
        if (this.verifica(aluguel)) {
            String sql = "SELECT cod_aluguel, dt_inicio, dt_fim, cod_cliente, cod_veiculo FROM aluguel WHERE cod_aluguel=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(1, aluguel.getCod());
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                aluret.setCod(rst.getInt("cod_aluguel"));
                aluret.setDt_inicio(rst.getDate("dt_inicio"));
                aluret.setDt_fim(rst.getDate("dt_fim"));
                ClienteDAO clientedao = new ClienteDAO(conexao);
                Cliente cliente = new Cliente();
                cliente.setCod(rst.getInt("cod_cliente"));
                cliente = clientedao.retrive(cliente);
                aluret.setCliente(cliente);
                VeiculoDAO veiculodao = new VeiculoDAO(conexao);
                Veiculo veiculo = new Veiculo();
                veiculo.setCod(rst.getInt("cod_veiculo"));
                veiculo = veiculodao.retrive(veiculo);
                aluret.setVeiculo(veiculo);
                pst.executeUpdate();
            }
            rst.close();
            pst.close();
        }
        return aluret;
    }

    public void update(Aluguel aluguel) throws SQLException {
        if (this.verifica(aluguel)) {
            String sql = "UPDATE aluguel SET dt_inicio=?, dt_fim=?, cod_cliente=?, cod_veiculo=? WHERE cod=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            Date dtini = new Date(aluguel.getDt_inicio().getTime());
            pst.setDate(1, dtini);
            Date dtfim = new Date(aluguel.getDt_fim().getTime());
            pst.setDate(2, dtfim);
            pst.setInt(3, aluguel.getCliente().getCod());
            pst.setInt(4, aluguel.getCod());
            pst.setInt(5, aluguel.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Aluguel aluguel) throws SQLException {
        if (this.verifica(aluguel)) {
            String sql = "DELETE FROM aluguel WHERE cod=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(1, aluguel.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    public boolean verifica(Aluguel aluguel) {
        boolean verf = false;
        if (aluguel != null) {
            verf = true;
        }
        return verf;
    }
}
