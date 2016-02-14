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
public class Pessoa {
    private String nome;
    private Telefone telefone;

    public Pessoa() {
        this.telefone=new Telefone();
    }

    public Pessoa(String nome, Telefone telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    
    public String infoPessoa(){
        return   this.getTelefone().getNumero()+ "   |  " +
                "Operadora: " + this.getTelefone().getOperadora()+ "   |  " +
                "Tipo: " + this.getTelefone().getTipo()+  "   |  " +
                "Observação: " + this.getTelefone().getObservacao();
    }
    
}
