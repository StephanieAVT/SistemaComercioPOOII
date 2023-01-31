package dao;
import factory.ConnectionFactory;
import modelo.Cliente;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO {
   private Connection connection;
    String cpf;
    String rg;
    String nome;
    String endereco;
    String telefone;
    String email;
    public ClienteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Cliente cliente){ 
        String sql = "INSERT INTO cliente(cpf,rg,nome,endereco,telefone,email) VALUES(?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getRg());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
    public void alterar (Cliente cliente){
        PreparedStatement stmt = null;
        try {
            stmt=connection.prepareStatement("update cliente set nome=?, rg=?, endereco=?, telefone=?, email=? where cpf=?;");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRg());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getCpf());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void remove (Cliente cliente){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("delete from Cliente where nome=? and cpf=? and rg=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
       
    }
    public List<Cliente> listar(){
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("select * from cliente;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString(1));
                cliente.setRg(rs.getString(2));
                cliente.setNome(rs.getString(3));
                cliente.setEndereco(rs.getString(4));
                cliente.setTelefone(rs.getString(5));
                cliente.setEmail(rs.getString(6));
                clientes.add(cliente);
                
            }
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);        }
        
        return clientes;
        
    }
}
