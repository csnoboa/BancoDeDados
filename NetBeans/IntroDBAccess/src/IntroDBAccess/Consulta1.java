/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntroDBAccess;

import java.sql.*;


/**
 *
 * @author caiqu
 */
public class Consulta1 {
    public static void main(String[] args) throws Exception {
        
        //carregar o driver do MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Import JDBC Success!");    
        
        // iniciar a conexão com servidor
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/university?useTimezone=true&serverTimezone=UTC", "aula", "1234");
        System.out.println("Connection Success!");
        
        //criar um statement
        Statement stat = con.createStatement();
        System.out.println("Statement Create Success!");
        
        //executar uma query
        ResultSet rs = stat.executeQuery("select * from instructor");
        
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        
        // fechar a conexão
        con.close();
        
        
    }
}
