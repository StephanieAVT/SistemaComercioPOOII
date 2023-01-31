package factory; 

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.Statement; 
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConnectionFactory {
    private static final String STR_CONEXAO = "jdbc:mysql://localhost/madrugasoundsBD";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    public Connection connection;
    public Statement stm;
    public ResultSet rs;
     public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost/madrugasoundsBD","root","");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}
     /*public Connection getConnection(){
		 if(connection == null){
            new ConnectionFactory();
        }
        return connection;
     }
     public void ConnectionFactory(){
        try{
            Class.forName(DRIVER).newInstance();
            this.connection = DriverManager.getConnection(STR_CONEXAO,USUARIO,SENHA);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Conexão não estabelecida\n ");
            
        }
    }
     public void executaSql(String sql){
        try {
            stm = connection.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Conexão não estabelecida\n ");
        }
     }
     
     public void closeConnection(){
         try{
        connection.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar conexão bd:\n"+ex.getMessage());
        }
    }*/;

