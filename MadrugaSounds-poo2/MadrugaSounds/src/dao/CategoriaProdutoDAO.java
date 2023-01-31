package dao;
import factory.ConnectionFactory;
import modelo.CategoriaProduto;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaProdutoDAO {
    private Connection connection;
    String categoriaNomeProduto;
    int IdCategoriaProduto;
    public CategoriaProdutoDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(CategoriaProduto categoriaProduto){ 
        String sql = "INSERT INTO categoriaProduto (categoriaNomeProduto) VALUES(?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoriaProduto.getcategoriaNomeProduto());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    }
    public void alterar (CategoriaProduto categoriaProduto){
        PreparedStatement stmt = null;
        try {
            stmt=connection.prepareStatement("update categoriaProduto set categoriaNomeProduto=? where idCategoria=?;");
            stmt.setString(1, categoriaProduto.getcategoriaNomeProduto());
            stmt.setInt(2, categoriaProduto.getidCategoriaProduto());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void remove (CategoriaProduto categoriaProduto){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("delete from categoriaProduto where idCategoria=? and categoriaNomeProduto=?");
            stmt.setInt(1, categoriaProduto.getidCategoriaProduto());
            stmt.setString(2, categoriaProduto.getcategoriaNomeProduto());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
       
    }
    public List<CategoriaProduto> listar(){
        List<CategoriaProduto> categoriaProdutos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("select * from CategoriaProduto;");
            rs = stmt.executeQuery();
            while(rs.next()){
                CategoriaProduto categoriaProduto = new CategoriaProduto();
                categoriaProduto.setidCategoriaProduto(rs.getInt(1));
                categoriaProduto.setcategoriaNomeProduto(rs.getString(2));
                categoriaProdutos.add(categoriaProduto);
                
            }
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return categoriaProdutos;
        
    }
}

