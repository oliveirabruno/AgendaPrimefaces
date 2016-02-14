/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Pessoa;

/**
 *
 * @author ManoelNeto
 */
public class Agenda {
    
    private TreeMap<String, Pessoa> map;
    private int totalFixos;
    private int totalMovel;
  
  
    
    public Agenda() {
        map=new TreeMap<>();
        this.totalFixos=0;
        this.totalMovel=0;
    }

    public TreeMap<String, Pessoa> getMap() {
        return map;
    }
    
    private int upTotalContatos(){
        return this.map.size();
    }
    
   

    public void addPessoa(Pessoa pessoa){
        this.map.put(pessoa.getNome(), pessoa);
        String tipoTel = pessoa.getTelefone().getTipo();
        if((tipoTel!=null) || (tipoTel!="")){
            if(tipoTel.equalsIgnoreCase("fixo")){
                 this.totalFixos++;
            }if(tipoTel.equalsIgnoreCase("movel")){
                    this.totalMovel++;         }
        }
    }
    
    public List<Pessoa> getLista(){    
        return new ArrayList<>(this.map.values());        
    }
    
    public Pessoa buscaPessoa(String nome){        
        return this.map.get(nome);
    }

    public Pessoa buscaReversa(String numeroTelefone){
        Pessoa tempContato = null;
        Pessoa tempPessoa = null;
        
        for (String key : this.map.keySet()){
            tempContato =  this.map.get(key);            
            
                if(tempContato.getTelefone().getNumero().equalsIgnoreCase(numeroTelefone))
                   tempPessoa = tempContato;
               
           }
         return tempPessoa;
    }
    
    public List<Pessoa> pesquisarPorLetra(String arg){
        
        ArrayList<Pessoa> pesquisa  = new ArrayList<>();
        Pessoa tempPessoa;
        String inicial;        
        
        for (String key : this.map.keySet()) {           
             tempPessoa = this.map.get(key);
             inicial = ""+tempPessoa.getNome().charAt(0);                       
                if(inicial.equalsIgnoreCase(arg)){
                        pesquisa.add(tempPessoa);
            }
           }        
        return pesquisa;        
    }
    
    
    public int getTotalFixos() {
        return totalFixos;
    }

    public int getTotalMovel() {
        return totalMovel;
    }
    
    
}
