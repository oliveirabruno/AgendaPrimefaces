/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ManoelNeto
 */
public class Telefone {
    
    private String numero;
    private String operadora;
    private String observacao;
    private String tipo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Telefone(String numero, String operadora, String tipo, String observacao) {
        this.numero = numero;
        this.operadora = operadora;
        this.observacao = observacao;
        this.tipo = tipo;
    }

    public Telefone() {
    }
    
    
    
}
