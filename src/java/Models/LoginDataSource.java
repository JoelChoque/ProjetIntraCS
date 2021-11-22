/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Maria Claudia
 */
public class LoginDataSource extends DriverManagerDataSource {
    public LoginDataSource(){
       // super("jdbc:sqlserver://localhost;databaseName=libraire","sa","sql"); **************  OJO 
       
        super("jdbc:mysql://localhost:3306/librairie", "root", "root");
//        super("jdbc:sqlserver://localhost:1433;databaseName=librairie", "user", "123");
     // super("jdbc:sqlserver://localhost;databaseName=libraire","claudia","sql1");
this.setDriverClassName("com.mysql.cj.jdbc.Driver");
//this.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

}
public LoginDataSource(String url,String username, String password, String className){
        super(url, username,password);
        this.setDriverClassName(className);
}

public JdbcTemplate createJdbcTemplate(){
        return new JdbcTemplate(this);
}

}
