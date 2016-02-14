/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import model.Telefone;

/**
 *
 * @author BO
 */
public class DAOAgenda implements IDAOAgenda{
    private final String bd = "jdbc:postgresql://localhost:5432/BDAgenda"; 
    String usuario = "postgres";  
    String senha = "A6901804"; 
    private Connection conexao;    
    
    private PreparedStatement pStmt; 
    private ResultSet rSet;

    public DAOAgenda() throws Exception { 
        Class.forName("org.postgresql.Driver");  
        }    

    @Override
    public void addPessoa(Pessoa pessoa)  throws Exception{
        
    String adicionaContatoNoBanco = "insert into contatos (nome, telefone, operadora, tipo, observacao) values (?,?,?,?,?)"; //Para não ter que ficar repetindo essa linha de comando do banco de dados por todo o codigo, atribuimos ele a uma variavel. Essas interrogações é justamente por causa do PreparedStatement lá em cima. A conversão do tipo de dado sendo passado será feita no proprio banco. 
    
    this.conexao = DriverManager.getConnection(bd, usuario,senha ); 
    this.pStmt = conexao.prepareStatement(adicionaContatoNoBanco);
  
    pStmt.setString(1, pessoa.getNome());
    pStmt.setString(2, pessoa.getTelefone().getNumero());
    pStmt.setString(3, pessoa.getTelefone().getOperadora());
    pStmt.setString(4, pessoa.getTelefone().getTipo());
    pStmt.setString(5, pessoa.getTelefone().getObservacao());
    
    pStmt.executeUpdate();
    
   		this.pStmt.close();
		this.conexao.close();              
       }

    @Override
    public List<Pessoa> getLista() throws SQLException {
        	 List<Pessoa> contatos =  new ArrayList<>(); 
		
                String BuscaNoBanco = "SELECT * FROM contatos";
                
		this.conexao = DriverManager.getConnection(bd, usuario,senha );
                this.pStmt = conexao.prepareStatement(BuscaNoBanco);
		               
		this.rSet = this.pStmt.executeQuery();    
		while(rSet.next()){
                                     contatos.add(new Pessoa( this.rSet.getString("nome"),new Telefone(this.rSet.getString("telefone"),
                                                        this.rSet.getString("operadora"), this.rSet.getString("tipo"),this.rSet.getString("observacao"))));  
                                    
                }
		this.rSet.close();
		this.pStmt.close();
		this.conexao.close();
                
		return contatos; 
	}
    
    

    @Override
    public Pessoa buscaPessoa(String nome) throws Exception{
         Pessoa contato = null;
         String BuscaNoBanco = "SELECT nome, numero, operadora, tipo, observacao FROM contatos WHERE nome = ?";
                
		this.conexao = DriverManager.getConnection(bd, usuario,senha );
                this.pStmt = conexao.prepareStatement(BuscaNoBanco);
		this.pStmt.setString(1, nome); //Passo o nome buscado como parametro.
               
		this.rSet = this.pStmt.executeQuery();
		while(rSet.next()){
                                    contato.setNome(this.rSet.getString("nome"));                                    
                                    contato.getTelefone().setNumero(this.rSet.getString("telefone"));
                                    contato.getTelefone().setOperadora(this.rSet.getString("operadora"));
                                    contato.getTelefone().setTipo(this.rSet.getString("tipo"));
                                    contato.getTelefone().setObservacao(this.rSet.getString("observacao"));  
                                    }
		  
		this.rSet.close();
		this.pStmt.close();
		this.conexao.close();
                
		return contato; 
	}
    

    @Override
    public Pessoa buscaReversa(String numeroTelefone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> pesquisarPorLetra(String arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
