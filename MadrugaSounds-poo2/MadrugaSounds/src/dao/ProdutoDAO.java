package dao;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CategoriaProduto;
import modelo.Produto;

public class ProdutoDAO {
    private Connection connection;
    public ResultSet rs;
    int idProduto;
    String marca;
    float valor;
    int CategoriaProduto_idCategoria;
    int qtdProd;
    //String pesquisa;
    public ProdutoDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Produto produto){ 
        String sql = "INSERT INTO produto(marca, valor, CategoriaProduto_idCategoria,qtdProd) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getMarca());
            stmt.setInt(2, (int) produto.getValor());
            stmt.setInt(3, produto.getCategoriaProduto_idCategoria());
            stmt.setInt(4, produto.getQtdProd());
            stmt.execute();
            stmt.close();
        }catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    }
    public void alterar (Produto produto){
        PreparedStatement stmt = null;
        try {
            stmt=connection.prepareStatement("update produto set marca=? where idProduto=? and CategoriaProduto_idCategoria=? and Valor=? and QtdProd=?;");
            stmt.setString(1, produto.getMarca());
            stmt.setInt(2, produto.getIdProduto());
            stmt.setInt(3, produto.getCategoriaProduto_idCategoria());
            stmt.setFloat(4, produto.getValor());
            stmt.setInt(5,produto.getQtdProd());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void remove (Produto produto){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("delete from Produto where idProduto=? and Categoria_idCategoria=? ");
            stmt.setInt(1, produto.getIdProduto());
            stmt.setInt(2, produto.getCategoriaProduto_idCategoria());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
       
    }
    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("select * from produto;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt(1));
                produto.setMarca(rs.getString(2));
                produto.setCategoriaProduto_idCategoria(rs.getInt(3));
                produto.setValor(rs.getFloat(4));
                produto.setQtdProd(rs.getInt(5));
                produtos.add(produto);
                
            }
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);         }
        
        return produtos;
        
    }
    
    }