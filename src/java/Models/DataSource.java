package Models;

import org.springframework.jdbc.core.JdbcTemplate;

public class DataSource {

    private static GestDriverManagerDataSource dataSource = null;

    private static final String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=libraire";
    private static final String USENAME = "root";
    private static final String PASSWORD = "root";

//    private static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/librairie";
    
    public static JdbcTemplate getDataSource() {
        dataSource = new GestDriverManagerDataSource(CLASSNAME, URL, USENAME, PASSWORD);
        return dataSource.createJdbcTemplate();
    }
}
