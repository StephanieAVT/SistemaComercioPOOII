package dao;
import factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Gerente;
public class GerenteDAO { 
    private Connection connection;
    int idGerente;
    String nome;
    String endereco;
    String email;
    String telefone;
    String salario;
    String dataNasc;
    public GerenteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Gerente gerente){ 
        String sql = "INSERT INTO gerente(nome,endereco,email,telefone,salario, dataNasc) VALUES(?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getEndereco());
            stmt.setString(3, gerente.getEmail());
            stmt.setString(4, gerente.getTelefone());
            stmt.setString(5, gerente.getSalario());
            stmt.setString(6, gerente.getDataNasc());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    public void alterar (Gerente gerente){
        PreparedStatement stmt = null;
        try {
            stmt=connection.prepareStatement("update gerente set dataNasc=?, nome=?, endereco=?, email=?, telefone=?, salario=? where idGerente=?;");
            stmt.setString(1, gerente.getDataNasc());
            stmt.setString(2, gerente.getNome());
            stmt.setString(3,gerente.getEndereco());
            stmt.setString(4,gerente.getEmail());
            stmt.setString(5,gerente.getTelefone());
            stmt.setString(6,gerente.getSalario());
            stmt.setInt(7, gerente.getIdGerente());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void remove (Gerente gerente){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("delete from gerente where nome=? and idGerente=?");
            stmt.setString(1, gerente.getNome());
            stmt.setInt(2, gerente.getIdGerente());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
       
    }
    public List<Gerente> listar(){
        List<Gerente> gerentes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("select * from gerente;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Gerente gerente = new Gerente();
                gerente.setIdGerente(rs.getInt(1));
                gerente.setNome(rs.getString(2));
                gerente.setDataNasc(rs.getString(3));
                gerente.setTelefone(rs.getString(4));
                gerente.setEndereco(rs.getString(5));
                gerente.setSalario(rs.getString(6));
                gerente.setEmail(rs.getString(7));
                gerentes.add(gerente);
                
            }
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);        }
        
        return gerentes;
        
    }
    
}
