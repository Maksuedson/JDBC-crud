
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexaoPadrao {

    
    
    public static Connection getConnection(){
        Connection con =null;
        
        try {
        con = DriverManager.getConnection("jdbc:mysql://localhost/demo", "student", "123");
        System.out.println("Concectou com sucesso!");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        return con;
    }
    
}
