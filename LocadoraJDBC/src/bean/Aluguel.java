/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author Guilherme Gehling
 */
public class Aluguel {

    private int cod;
    private Date dt_inicio, dt_fim;
    private Veiculo veiculo;
    private Cliente cliente;

    public Aluguel() {
    }

    public Aluguel(int cod, Date dt_inicio, Date dt_fim, Veiculo veiculo, Cliente cliente) {
        this.cod = cod;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Date getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(Date dt_fim) {
        this.dt_fim = dt_fim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.cod;
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
        final Aluguel other = (Aluguel) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }
}