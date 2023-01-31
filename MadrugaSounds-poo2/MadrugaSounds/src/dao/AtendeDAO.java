package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Atende;

public class AtendeDAO {
    private Connection connection;
     int codAtendimento;
     String data;
     int Vendedor_idVendedor;
     String Cliente_cpf;
      public void adiciona(Atende atende){ 
          String sql = "INSERT INTO atende(data,Vendedor_idVendedor,Cliente_cpf) VALUES(?,?,?)";
          try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atende.getData());
            stmt.setInt(2, atende.getVendedor_idVendedor());
            stmt.setString(3, atende.getCliente_cpf());
            stmt.execute();
            stmt.close();
      }
          catch (SQLException u) { 
            throw new RuntimeException(u);
        }
      }
      public void alterar (Atende atende){
        PreparedStatement stmt = null;
        try {
            stmt=connection.prepareStatement("update atende set data=?, Vendedor_idVendedor=?, Cliente_cpf=? where codAtendimento=?;");
            stmt.setString(1, atende.getData());
            stmt.setInt(2, atende.getVendedor_idVendedor());
            stmt.setString(3, atende.getCliente_cpf());
            stmt.setInt(4, atende.getCodAtendimento());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void remove (Atende atende){
        PreparedStatement stmt;
        try {
            stmt=connection.prepareStatement("delete from atende where codAtendimento=? and Vendedor_idVendedor=? and Cliente_cpf=?");
            stmt.setInt(1, atende.getCodAtendimento());
            stmt.setInt(2, atende.getVendedor_idVendedor());
            stmt.setString(3, atende.getCliente_cpf());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);   
        }
       
    }
    public List<Atende> listar(){
        List<Atende> atender = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("select * from vende;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Atende atende = new Atende();
                atende.setCodAtendimento(rs.getInt(1));
                atende.setData(rs.getString(2));
                atende.setVendedor_idVendedor(rs.getInt(3));
                atende.setCliente_cpf(rs.getString(4));
                atender.add(atende);
                
            }
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
    }
        
        return atender;
        
    }
      
      
}
