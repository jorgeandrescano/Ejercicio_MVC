package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Categoria {
    private int idCategoria;
    private String nombreCat;
    private Connection cxBD;

    public int getidCategoria() {
        return idCategoria;
    }

    public void setidCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getnombreCat() {
        return nombreCat;
    }

    public void setnombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    } 
    
    public Categoria(){
        Conexion oDB = new Conexion();
        this.cxBD = oDB.miConexion();
    }
    
     public ResultSet listarCategorias(){
        String sql = "SELECT idCategoria, nombreCat FROM categorias";
        ResultSet listaCategorias = null;
        try{
            PreparedStatement stm = this.cxBD.prepareStatement(sql);
            listaCategorias = stm.executeQuery();
        }catch (SQLException ex){
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategorias;
    }
}

