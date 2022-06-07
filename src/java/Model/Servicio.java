package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servicio {
    private int idServicio;
    private int idCategoria;
    private String nombreServ;
    private String medida;
    private float costo;
    private int estado;
    private Connection cxDB;

    public int getidServicio() {
        return idServicio;
    }

    public void setidServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getidCategoria() {
        return idCategoria;
    }

    public void setidCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getnombreServ() {
        return nombreServ;
    }

    public void setnombreServ(String nombreServ) {
        this.nombreServ = nombreServ;
    }

    public String getmedida() {
        return medida;
    }

    public void setmedida(String medida) {
        this.medida = medida;
    }

    public float getcosto() {
        return costo;
    }

    public void setcosto(float costo) {
        this.costo = costo;
    }
    
    public int getestado() {
        return estado;
    }

    public void setestado(int estado) {
        this.estado = estado;
    }

    public Connection getCxDB() {
        return cxDB;
    }

    public void setCxDB(Connection cxDB) {
        this.cxDB = cxDB;
    }
    
    public Servicio(){
        Conexion oDB = new Conexion();
        this.cxDB = oDB.miConexion();
    }
    
    public int guardarServicios(){
        String sql = "INSERT INTO servicios VALUES (NULL,?,?,?,?,?)";
        int rowGuardados = 0;
        try{
            PreparedStatement stm = this.cxDB.prepareStatement(sql);
            stm.setInt(1,this.idCategoria);
            stm.setString(2,this.nombreServ);
            stm.setString(3,this.medida);
            stm.setFloat(4,this.costo);
            stm.setInt(5,this.estado);
            rowGuardados = stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowGuardados;
    }
    
    public int editarServicios(){
        String sql = "UPDATE servicios SET idCategoria=?, nombreServ=?, medida=?, costo=?, estado=?) WHERE idServicio=?";
        int rowEditados = 0;
        try{
            PreparedStatement stm = this.cxDB.prepareStatement(sql);
            stm.setInt(1,this.idCategoria);
            stm.setString(2,this.nombreServ);
            stm.setString(3,this.medida);
            stm.setFloat(4,this.costo);
            stm.setInt(5,this.estado);
            stm.setInt(6,this.idServicio);
            rowEditados = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowEditados;
    }
    
    public ResultSet listarServicios(){
        String sql = "SELECT servicios.*, categorias.nombreCat FROM servicios INNER JOIN categorias ON (servicios.idCategoria = categorias.idCategoria)";
        ResultSet listaServicios = null;
        
        try{
            PreparedStatement stm =this.cxDB.prepareStatement(sql);
            listaServicios = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaServicios;
    }
    
    public ResultSet consultarServicios(){
        String sql = "SELECT * FROM servicios WHERE idServicio=?";
        ResultSet consultarServicios = null;
        try{
            PreparedStatement stm =this.cxDB.prepareStatement(sql);
            stm.setInt(1, this.idServicio);
            consultarServicios = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consultarServicios;
    }
}
