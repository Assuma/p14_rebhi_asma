package connessione_al_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyDB {

     static MyDB instance;
     String url;
     String login = "asma";
     String pwd = "asma";
     
     Connection con;
     
     @SuppressWarnings("empty-statement")
     private MyDB()
     {
        this.url = "jdbc:mysql://localhost:3306/database";

         try
         {
            
             con = DriverManager.getConnection(url, login, pwd);
             System.out.println("Connessione OK!!");
         }
         catch(SQLException ex)
                 {
                     System.out.println("Problema di connessione!"+ex);;
                 }
     }


    public Connection getConnexion() {
        return con ; 
    }

    public static connessione_al_database.MyDB getInstance() {
        if(instance==null)
        {
            instance = new MyDB();
        }
        return instance;
    }
}
