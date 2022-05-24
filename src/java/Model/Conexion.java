package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String driver = "jdbc:mysql";
    private String host = "localhost";
    private String db_name = "mi_empresa";
    private String db_user = "root";
    private String db_password = "";
    private int db_port = 3306;
    
    public Connection miConexion(){
        Connection cx= null;
        try{
            String str_cx = this.driver+"://"+this.host+":"+db_port+"/"+this.db_name+"?useServerPrepStmts=true";
            Class.forName("com.mysql.jdbc.Driver");
            cx = DriverManager.getConnection(str_cx,this.db_user,this.db_password);
        }catch (ClassNotFoundException e){
            
        }catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx; 
    }
}
