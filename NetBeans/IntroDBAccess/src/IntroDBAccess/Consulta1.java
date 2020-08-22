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
    public static void main(String[] args) {
          
        try{
            // iniciar a conexão com servidor
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/university?useTimezone=true&serverTimezone=UTC", "aula", "1234");
            System.out.println("Connection Success!");

            //criar um statement
            Statement stat = con.createStatement();
            System.out.println("Statement Create Success!");

            //executar uma query
            int filtroSalario = 80000;
            ResultSet rs = stat.executeQuery("select id, name, dept_name, salary from instructor where salary >= " + filtroSalario);

            while (rs.next()){
                System.out.println(rs.getString("name") + " / " + rs.getString("dept_name") + " / " + rs.getString("salary"));
            }

            // fechar a conexão
            con.close();
        } catch(SQLException sql1) {
            System.out.println("Error in Database "+sql1);
        }
        
    }
}
