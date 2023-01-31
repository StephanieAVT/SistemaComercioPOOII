package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Vende;

public class VendeDAO {
    private  Connection connection;
    int idVenda;
    String data;
    int Vendedor_idVendedor;
    int Produto_idProduto;
    public VendeDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona (Vende vende){
        String sql = "INSERT INTO vende(data,Vendedor_idVendedor,Produto_idProduto) VALUES(?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, vende.getData());
            stmt.setInt(2, vende.getVendedor_idVendedor());
            stmt.setInt(3, vende.getProduto_idProduto());
            stmt.execute();
            stmt.close();
    }   catch (SQLException u) { 
            throw new RuntimeException(u);        
        }
    }
    public void alterar (Vende vende){
        PreparedStatement stmt = null;
        try {
            stmt=connection.prepareStatement("update vende set data=?, Produto_idProduto=?, Vendedor_idVendedor=? where idVenda=?;");
            stmt.setString(1, vende.getData());
            stmt.setInt(2,vende.getProduto_idProduto());
            stmt.setInt(3, vende.getVendedor_idVendedor());
            stmt.setInt(4, vende.getIdVenda());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void remove (Vende vende){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("delete from Vende where idVenda=? and Vendedor_idVendedor=? and Produto_idProduto=?");
            stmt.setInt(1, vende.getIdVenda());
            stmt.setInt(2, vende.getVendedor_idVendedor());
            stmt.setInt(3, vende.getProduto_idProduto());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
       
    }
    public List<Vende> listar(){
        List<Vende> vendas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("select * from vende;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Vende vende = new Vende();
                vende.setIdVenda(rs.getInt(1));
                vende.setData(rs.getString(2));
                vende.setProduto_idProduto(rs.getInt(3));
                vende.setVendedor_idVendedor(rs.getInt(4));
                vendas.add(vende);
                
            }
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"Erro ao listar dados:"+ex,"Erro",JOptionPane.ERROR_MESSAGE);        }
        
        return vendas;
        
    }
}
