package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Vendedor;

public class VendedorDAO {
    private Connection connection;
    int idVendedor;
    String nome;
    String dataNasc;
    String telefone;
    String email;
    String endereco;
    String salario;
    int Gerente_idGerente;
    public VendedorDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Vendedor vendedor){ 
        String sql = "INSERT INTO vendedor(nome,dataNasc,telefone,email,endereco,salario,Gerente_idGerente) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getDataNasc());
            stmt.setString(3, vendedor.getTelefone());
            stmt.setString(4, vendedor.getEmail());
            stmt.setString(5, vendedor.getEndereco());
            stmt.setString(6, vendedor.getSalario());
            stmt.setInt(7, vendedor.getGerente_idGerente());
            stmt.execute();
            stmt.close();
        }catch (SQLException u) { 
            throw new RuntimeException(u);
        }
    } 
    public void alterar (Vendedor vendedor){
        PreparedStatement stmt = null;
        try {
            stmt=connection.prepareStatement("update vendedor set dataNasc=?, endereco=?, telefone=?, email=?, nome=?, salario=?, Gerente_idGerente=?  where idVendedor=?;");
            stmt.setString(1, vendedor.getDataNasc());
            stmt.setString(2, vendedor.getEndereco());
            stmt.setString(3, vendedor.getTelefone());
            stmt.setString(4, vendedor.getEmail());
            stmt.setString(5, vendedor.getNome());
            stmt.setString(6, vendedor.getSalario());
            stmt.setInt(7, vendedor.getGerente_idGerente());
            stmt.setInt(8, vendedor.getIdVendedor());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void remove (Vendedor vendedor){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("delete from vendedor where idVendedor=? and Gerente_idGerente=?");
            stmt.setInt(1, vendedor.getIdVendedor());
            stmt.setInt(2, vendedor.getGerente_idGerente());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
       
    }
    public List<Vendedor> listar(){
        List<Vendedor> vendedors = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("select * from vendedor;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setIdVendedor(rs.getInt(1));
                vendedor.setNome(rs.getString(2));
                vendedor.setDataNasc(rs.getString(3));
                vendedor.setTelefone(rs.getString(4));
                vendedor.setEmail(rs.getString(5));
                vendedor.setEndereco(rs.getString(6));
                vendedor.setSalario(rs.getString(7));
                vendedor.setGerente_idGerente(rs.getInt(8));
                vendedors.add(vendedor);
                
            }
            stmt.close();
        } catch (SQLException ex) {
          throw new RuntimeException(ex); 
    }
        
        return vendedors;
        
    }
    
    
}
