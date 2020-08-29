/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntroDBAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author caiqu
 */
public class Insert {
    public static void main(String args[]) {
        String filename = "lib/verdadeiro_jpg.jpg";
        try{
        // ?useTimezone=true&serverTimezone=UTC foi necessario ser adicionado na URL por conta de erro na conexão
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/university?useTimezone=true&serverTimezone=UTC", "aula", "1234");
        System.out.println("Connection Sucessfull!");
        String updateSQL = "UPDATE instructor "
                + "SET photo = ? "
                + "WHERE id=98345";

        PreparedStatement pstmt = con.prepareStatement(updateSQL);
        System.out.println("PreparedStatement Sucessfull!");
        // read the file
        File file = new File(filename);
        FileInputStream input = new FileInputStream(file);
        System.out.println("FileInputStream Sucessfull!");

        // set parameters
        pstmt.setBinaryStream(1, input);
        System.out.println("setBinaryStream Sucessfull!");
        
        pstmt.executeUpdate();
        }catch (SQLException|FileNotFoundException sql1){
            System.out.println("Error: "+sql1);
        }
    }
    
}
