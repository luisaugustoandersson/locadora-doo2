/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Marca;
import bean.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Guilherme Gehling
 */
public class ModeloDAO {

    private Connection conexao;

    public ModeloDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Modelo modelo) throws SQLException {
        if (this.verifica(modelo)) {
            String sql = "INSERT INTO modelo (cod_modelo, modelo, cod_marca)"
                    + "VALUES (NEXTVAL('seq_modelo')), ?, ?";
            PreparedStatement pst = this.conexao.prepareCall(sql);
            pst.setString(1, modelo.getModelo());
            pst.setInt(2, modelo.getMarca().getCod());
            pst.executeUpdate();
            Statement st = this.conexao.createStatement();
            ResultSet rst = st.executeQuery("SELECT CURRVAL('seq_modelo')");
            if (rst.next()) {
                modelo.setCod(rst.getInt(1));
            }
            rst.close();
            st.close();
            pst.close();
        }
    }

    public Modelo retrive(Modelo modelo) throws SQLException {
        Modelo modeloret = null;
        String sql = "SELECT cod_modelo, modelo, cod_marca FROM modelo where cod_modelo=?";
        PreparedStatement pst = this.conexao.prepareCall(sql);
        pst.setInt(1, modelo.getCod());
        ResultSet rst = pst.executeQuery();
        if (!rst.next()) {
            modeloret = new Modelo();
            modeloret.setCod(rst.getInt("cod_modelo"));
            modeloret.setModelo(rst.getString("modelo"));
            MarcaDAO marcadao = new MarcaDAO(conexao);
            Marca marca = new Marca();
            marca.setCod(rst.getInt("cod_marca"));
            marca = marcadao.retrive(marca);
            modeloret.setMarca(marca);
        }
        rst.close();
        pst.close();
        return modeloret;
    }

    public void update(Modelo modelo) throws SQLException {
        if (this.verifica(modelo)) {
            String sql = "UPDATE modelo SET modelo=?, cod_marca=? WHERE cod=?";
            PreparedStatement pst = this.conexao.prepareCall(sql);
            pst.setString(1, modelo.getModelo());
            pst.setInt(2, modelo.getMarca().getCod());
            pst.setInt(3, modelo.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Modelo modelo) throws SQLException {
        if (this.verifica(modelo)) {
            String sql = "DELETE FROM modelo WHERE cod=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(1, modelo.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    public boolean verifica(Modelo modelo) {
        boolean verf = false;
        if (modelo != null) {
            verf = true;
        }
        return verf;
    }
}
