package edu.escuelaing.arep.reproduccion.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import edu.escuelaing.arep.reproduccion.model.reproduccion;


public class reproduccionRepository {
	
	private static final String urlDb = "jdbc:postgresql://ec2-3-231-16-122.compute-1.amazonaws.com:5432/d82dgnug27a8v1?user=vebjylzbvbhkrd&password=7c23c795d8069466561a02303eb7027408f04235b2525c347f204f3249664fef";
    private Connection c;
    private reproduccion r;
    
    public void getConnection() {
        try {
            c = DriverManager.getConnection(urlDb);
        } catch (SQLException e) {
        }
    }   
    
    public reproduccion getReproduccion (int id) {
    	
    	System.out.println("lista reproduccion ...." + id);
    	PreparedStatement pstmt = null;
    	try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "select * from reproduccion where id = ? ";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("rssssssssssss: "+ rs);
            c.close();
            if (rs.next()){
            	System.out.println("reproduccion: ");
                r = new reproduccion(rs.getInt("id"),rs.getString("nombre"),rs.getInt("idcancion"),rs.getString("usuario"));
            }
            pstmt.close();
            rs.close();
            return r;
        } catch (Exception ex) {
            Logger.getLogger(reproduccionRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<reproduccion> getListaCanciones(String usuario,String nombre){
    	System.out.println("lista canciones....");
    	PreparedStatement pstmt = null;
    	List<reproduccion> lista = new ArrayList<reproduccion>();
    	try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "select * from reproduccion where usuario= ? and nombre= ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, usuario);
            pstmt.setString(2, nombre);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            while (rs.next()){
            	System.out.println("diferentes listas .....");
                r = new reproduccion(rs.getInt("id"),rs.getString("nombre"),rs.getInt("idcancion"),rs.getString("usuario"));
                System.out.println("reproduccion: "+ r.getNombre());
                lista.add(r);
            }
            pstmt.close();
            rs.close();
           
        } catch (Exception ex) {
            Logger.getLogger(reproduccionRepository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    	 return lista;
    }
    
    public List<reproduccion> getListaReproduccionesUser(String usuario) {
    	PreparedStatement pstmt = null;
    	List<reproduccion> lista = new ArrayList<reproduccion>();
    	try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "select * from reproduccion where usuario= ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, usuario);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            while (rs.next()){
                r = new reproduccion(rs.getInt("id"),rs.getString("nombre"),rs.getInt("idcancion"),rs.getString("usuario"));
                lista.add(r);
            }
            pstmt.close();
            rs.close();
            
        } catch (Exception ex) {
            Logger.getLogger(reproduccionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    	return lista;
	}
    
    public void saveReproduccion(int id,String nombre,int idcancion,String usuario) {
    	PreparedStatement pstmt = null;
    	try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "insert into reproduccion values(?,?,?,?)";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, id);
            pstmt.setInt(2, idcancion);
            pstmt.setString(3, nombre);
            pstmt.setString(4, usuario);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(reproduccionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    }
    
    
}
