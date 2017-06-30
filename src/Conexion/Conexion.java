/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author DIANA
 */
public class Conexion {

    /**
     * @param args the command line arguments
     */
    public Connection conectar(){
        
        Connection co=null;
        
        try{
            //declarar libreria
            Class.forName("org.hsqldb.jdbcDriver");
            co=DriverManager.getConnection("jdbc:hsqldb:file:Probando/BaseD","SA","");
            System.out.println("CONEXION EXITOSA");
        
    }catch(Exception ex){
            System.err.println("SIN CONEXION" +ex);
    }
        return co;
    }
    public ResultSet consultar(){
        Connection con=conectar();
        ResultSet rs=null;
        try{
            PreparedStatement ps=con.prepareStatement("Select * from persona");
            rs=ps.executeQuery();
        
            
        }catch(Exception ex){
            System.err.println("Error" + ex);
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println("Falló" + ex);
            }
            return rs;
        }
        
       
    }
    //mostrar datos
    
    public static void main(String[] args) throws Exception{
        Conexion con=new Conexion();
        //con.conectar();
        ResultSet rs=con.consultar();
        try{
            //mostrar, recorrer
            while(rs.next()){
            
            JOptionPane.showMessageDialog(null, rs.getString(1) + ", " + rs.getString(2)+ ", " + rs.getString(3));
        }
        }catch(Exception ex){
            System.out.println("Error" +ex);
            
        }   
            
            
            
        }
        
    }
    

