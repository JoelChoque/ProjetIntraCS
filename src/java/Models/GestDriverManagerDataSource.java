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
public class GestDriverManagerDataSource {
    private String className ;
    private String url ;
    private String useName ;
    private String password ;

    public GestDriverManagerDataSource(String className, String url, String useName, String password) {
        this.className = className;
        this.url = url;
        this.useName = useName;
        this.password = password;
    }
    
 public GestDriverManagerDataSource() {
    }
 
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public JdbcTemplate createJdbcTemplate(){    
       JdbcTemplate jt = new JdbcTemplate();
       DriverManagerDataSource ds = new DriverManagerDataSource( this.url, this.useName ,  this.password);
       ds.setDriverClassName(this.className);
       jt.setDataSource(ds);
       return jt;
   }
}
