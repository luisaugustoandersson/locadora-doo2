/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Guilherme Gehling
 */
public class MarcaDAO {

    private Connection conexao;

    public MarcaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Marca marca) throws SQLException {
        if (this.verifica(marca)) {
            String sql = "ISERNT INTO marca (cod_marca, marca)"
                    + "VALUES (NEXTVAL('seq_marca'), ?";
            PreparedStatement pst = this.conexao.prepareCall(sql);
            pst.setString(1, marca.getMarca());
            pst.executeUpdate();
            Statement st = this.conexao.createStatement();
            ResultSet rst = st.executeQuery("SELECT CURRVAL('seq)marca')");
            if (rst.next()) {
                marca.setCod(rst.getInt(1));
            }
            rst.close();
            st.close();
            pst.close();
        }
    }

    public Marca retrive(Marca marca) throws SQLException {
        Marca marcaret = null;
        String sql = "SELECT cod_marca, marca FROM marca";
        PreparedStatement pst = this.conexao.prepareCall(sql);
        pst.setInt(1, marca.getCod());
        ResultSet rst = pst.executeQuery();
        if (rst.next()) {
            marcaret.setCod(rst.getInt("cod_marca"));
            marcaret.setMarca(rst.getString("marca"));
        }
        rst.close();
        pst.close();
        return marcaret;

    }

    public void update(Marca marca) throws SQLException {
        if (this.verifica(marca)) {
            String sql = "UPDATE marca SET marca=? WHERE cod=?";
            PreparedStatement pst = this.conexao.prepareCall(sql);
            pst.setString(1, marca.getMarca());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Marca marca) throws SQLException {
        if (this.verifica(marca)) {
            String sql = "DELETE FROM marca WHERE cod=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(1, marca.getCod());
            pst.executeUpdate();
            pst.close();
        }

    }

    public boolean verifica(Marca marca) {
        boolean verf = false;
        if (marca != null) {
            verf = true;
        }
        return verf;
    }
}
