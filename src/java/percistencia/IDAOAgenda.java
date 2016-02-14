/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percistencia;

import java.util.List;
import model.Pessoa;

/**
 *
 * @author BO
 */
public interface IDAOAgenda {
    
     public void addPessoa(Pessoa pessoa) throws Exception;
     public List<Pessoa> getLista() throws Exception;
     public Pessoa buscaPessoa(String nome) throws Exception;
     public Pessoa buscaReversa(String numeroTelefone) throws Exception;
     public List<Pessoa> pesquisarPorLetra(String arg) throws Exception;
           
}
