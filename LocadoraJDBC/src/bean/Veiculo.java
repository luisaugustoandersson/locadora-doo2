/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Guilherme Gehling
 */
public class Veiculo {

    private int cod;
    private String motor, info, cor, foto;
    private int ano, cap_malas, lugares;
    private Modelo modelo;
    private Marca marca;
    private double diaria;

    public Veiculo() {
    }

    public Veiculo(int cod, String motor, String info, String cor, String foto, int ano, int cap_malas, int lugares, Modelo modelo, Marca marca, double diaria) {
        this.cod = cod;
        this.motor = motor;
        this.info = info;
        this.cor = cor;
        this.foto = foto;
        this.ano = ano;
        this.cap_malas = cap_malas;
        this.lugares = lugares;
        this.modelo = modelo;
        this.marca = marca;
        this.diaria = diaria;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCap_malas() {
        return cap_malas;
    }

    public void setCap_malas(int cap_malas) {
        this.cap_malas = cap_malas;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    @Override
    public String toString() {
        return this.modelo.getModelo();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cod;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }
}