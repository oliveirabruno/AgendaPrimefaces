/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Pessoa;
import negocio.Agenda;
import org.primefaces.component.tabview.TabView;

/**
 *
 * @author ManoelNeto
 */
@ManagedBean (name="agendaBean")
@SessionScoped
public class AgendaBean {
    //private TabView tab;
    private Agenda agenda;
    private Pessoa pessoaLocal;
    private String buscarNome;
    private String buscarPorLetra;

    public String getBuscarPorNumero() {
        return buscarPorNumero;
    }

    public void setBuscarPorNumero(String buscarPorNumero) {
        System.out.println("Ok, metodo ser do buscar numero!");
        this.buscarPorNumero = buscarPorNumero;
         System.out.println(this.buscarPorNumero);
    }
    private String buscarPorNumero;
    

    
    public AgendaBean() {
        this.agenda=new Agenda();
        this.pessoaLocal=new Pessoa();
       
    }

    public void addPessoa(){
        this.agenda.addPessoa(pessoaLocal);
        confirmacaoCadastro(pessoaLocal.getNome());
        this.pessoaLocal=new Pessoa();
        }
    
    public void confirmacaoCadastro(String nomeContato){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastro realizado!",  nomeContato + " foi adicionado à agenda") );
    }
    
    
    
     
     //Metodos de Acesso
    public Agenda getAgenda() {
        return agenda;
    }

    public Pessoa getPessoaLocal() {
        return pessoaLocal;
    }
    
    public String getBuscarPorLetra() {
        return buscarPorLetra;
    }

    public void setBuscarPorLetra(String buscarPorLetra) {
        this.buscarPorLetra = buscarPorLetra;
    }

    public String getBuscarNome() {
        return buscarNome;
    }

    public void setBuscarNome(String buscarNome) {
        this.buscarNome = buscarNome;
    }
    
}
