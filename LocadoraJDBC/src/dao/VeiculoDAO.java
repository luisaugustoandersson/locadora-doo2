/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Marca;
import bean.Modelo;
import bean.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme Gehling
 */
public class VeiculoDAO {

    private Connection conexao;

    public VeiculoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Veiculo vec) throws SQLException {
        if (this.verifica(vec)) {
            String sql = "INSERT INTO veiculo (cod_veiculo, cor, motor, cap_malas, lugares, ano, diaria, info, cod_modelo, cod_marca, foto, disponivel)"
                    + "VALUES (NEXTVAL('seq_veiculo'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, vec.getCor());
            pst.setString(2, vec.getMotor());
            pst.setInt(3, vec.getCap_malas());
            pst.setInt(4, vec.getLugares());
            pst.setInt(5, vec.getAno());
            pst.setDouble(6, vec.getDiaria());
            pst.setString(7, vec.getInfo());
            pst.setInt(8, vec.getModelo().getCod());
            pst.setInt(9, vec.getMarca().getCod());
            pst.setString(10, vec.getFoto());
            pst.setBoolean(11, vec.getDisponivel());
            pst.executeUpdate();
            Statement st = this.conexao.createStatement();
            ResultSet rst = st.executeQuery("SELECT CURRVAL('seq_veiculo')");
            if (rst.next()) {
                vec.setCod(rst.getInt(1));
            }
            rst.close();
            st.close();
            pst.close();
        }
    }

    public Veiculo retrive(Veiculo vec) throws SQLException {
        Veiculo vecret = null;
        String sql = "SELECT cod_veiculo, cor, motor, cap_malas, lugares, ano, diaria, info, cod_modelo, cod_marca, foto, disponivel FROM veiculo WHERE cod=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, vec.getCod());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            vecret = new Veiculo();
            vecret.setCod(rs.getInt("cod_veiculo"));
            vecret.setCor(rs.getString("cor"));
            vecret.setAno(rs.getInt("ano"));
            vecret.setCap_malas(rs.getInt("cap_malas"));
            vecret.setDiaria(rs.getDouble("diaria"));
            vecret.setFoto(rs.getString("foto"));
            vecret.setInfo(rs.getString("info"));
            vecret.setLugares(rs.getInt("lugares"));
            vecret.setMotor(rs.getString("motor"));
            vecret.setDisponivel(rs.getBoolean("disponivel"));
            ModeloDAO modelodao = new ModeloDAO(conexao);
            Modelo modelo = new Modelo();
            modelo.setCod(rs.getInt("cod_modelo"));
            modelo = modelodao.retrive(modelo);
            vecret.setModelo(modelo);
            MarcaDAO marcadao = new MarcaDAO(conexao);
            Marca marca = new Marca();
            marca.setCod(rs.getInt("cod_marca"));
            marca = marcadao.retrive(marca);
            vecret.setMarca(marca);
        }
        rs.close();
        pst.close();
        return vecret;
    }

    public void update(Veiculo veiculo) throws SQLException {
        if (this.verifica(veiculo)) {
            String sql = "UPDATE veiculo SET cor=?, motor=?, cap_malas=?, lugares=?, ano=?, diaria=?, info=?, cod_modelo=?, cod_marca=?, foto=?, disponivel=? WHERE cod_veiculo=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, veiculo.getCor());
            pst.setString(2, veiculo.getMotor());
            pst.setInt(3, veiculo.getCap_malas());
            pst.setInt(4, veiculo.getLugares());
            pst.setInt(5, veiculo.getAno());
            pst.setDouble(6, veiculo.getDiaria());
            pst.setString(7, veiculo.getInfo());
            pst.setInt(8, veiculo.getModelo().getCod());
            pst.setInt(9, veiculo.getMarca().getCod());
            pst.setString(10, veiculo.getFoto());
            pst.setBoolean(11, veiculo.getDisponivel());
            pst.setInt(12, veiculo.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Veiculo veiculo) throws SQLException {
        if (this.verifica(veiculo)) {
            String sql = "DELETE FROM veiculo WHERE cod=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setInt(1, veiculo.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    public List<Veiculo> listaTodos() throws SQLException {
        List<Veiculo> lista = new ArrayList<Veiculo>();
        String sql = "SELECT cod_veiculo, cor, motor, cap_malas, lugares, ano, diaria, info, cod_modelo, cod_marca, foto, disponivel FROM veiculo ORDER BY cod_veiculo";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (!rs.next()) {
        } else {
            while (rs.next()) {
                Veiculo vec = new Veiculo();
                vec.setCod(rs.getInt("cod_veiculo"));
                vec.setCor(rs.getString("cor"));
                vec.setAno(rs.getInt("ano"));
                vec.setCap_malas(rs.getInt("cap_malas"));
                vec.setDiaria(rs.getDouble("diaria"));
                vec.setFoto(rs.getString("foto"));
                vec.setInfo(rs.getString("info"));
                vec.setLugares(rs.getInt("lugares"));
                vec.setMotor(rs.getString("motor"));
                vec.setDisponivel(rs.getBoolean("disponivel"));
                ModeloDAO modelodao = new ModeloDAO(conexao);
                Modelo modelo = new Modelo();
                modelo.setCod(rs.getInt("cod_modelo"));
                modelo = modelodao.retrive(modelo);
                vec.setModelo(modelo);
                MarcaDAO marcadao = new MarcaDAO(conexao);
                Marca marca = new Marca();
                marca.setCod(rs.getInt("cod_marca"));
                marca = marcadao.retrive(marca);
                vec.setMarca(marca);
                lista.add(vec);
            }
        }
        rs.close();
        st.close();
        return lista;
    }

    public boolean verifica(Veiculo vec) {
        boolean verf = false;
        if (vec != null) {
            verf = true;
        }
        return verf;
    }
}
