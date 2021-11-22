/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Maria Claudia
 */
public class LibrairieDataContext {
    
   private final JdbcTemplate jdbcTemplate;
   private GestDriverManagerDataSource driverManagerDataSOurce; // *****cest correct  ????
        
    public LibrairieDataContext(){
// La création du DriverManagerDataSource 
        DriverManagerDataSource ds= new DriverManagerDataSource("jdbc:mysql://localhost:3306/librairie", "root", "root");
//        DriverManagerDataSource ds= new DriverManagerDataSource("jdbc:sqlserver://localhost:1433;databaseName=librairie", "claudia", "sql1");
      //  DriverManagerDataSource ds= new DriverManagerDataSource("jdbc:sqlserver://localhost;databaseName=Northwind";Integreted security=true");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // La création jdbctemplate
        this.jdbcTemplate=new JdbcTemplate(ds);
    }
    
    //permet selectionner tous livres dans la table Livre
    public List<Livre> selectLivre(){
        List<Livre> liste=this.jdbcTemplate.query("select isbn,auteur,titre,prix,quantite,photo, resum from livre", new LivreMapper() );
        return liste;

    }

    //permet d'insérer un livre dans la table Livre
    public void insertLivre(Livre p){
                // exécuter la requete
        jdbcTemplate.update("insert into livre(auteur,titre,prix,quantite,photo,resum) values(?,?,?,?,?,?)",
                new Object[]{p.getAuteur(), p.getTitre(), p.getPrix(),p.getQuantite(),p.getPhoto(),p.getResum()});
       
    }
    
    //permet d'insérer une ligne dans la table "DetailsFacture". OJO **********************
    // public void insertDetails(int numFacture,String isbn,double prix){
      public void insertDetails(Details p){
                // exécuter la requete
        jdbcTemplate.update("insert into details(numFacture,isbn,prix) values(?,?,?)",
               new Object[]{p.getNumFacture(),p.getIsbn(),p.getPrix()});
       
    }
    
  //   permet d'insérer une facture dans la table "Facture". OJO***** CON  numFacture;
       public void insertFacture(Facture p){
                // exécuter la requete
        jdbcTemplate.update("insert into facture(numFacture,telephone,nomClient,adresse,email,montantht,mttaxe) values(?,?,?,?,?,?,?)",
               new Object[]{p.getNumFacture(),p.getTelephone(),p.getNomClient(),p.getAdresse(),p.getEmail(),p.getMontantht(),p.getMttaxe()});
       
   }

   // lv.getIsbn().equals(isbn)   
//get la liste du panier, pour livreachete
public Livre getLivre(int isbn){
    for(Livre lv : this.selectLivre()){
       if(lv.getIsbn()==isbn){
       return lv;
       }
    }
    return null;
}
          // ***************************** ojo con este resto de codigo ! 
public Livre selectByID(int isbn) {
        Livre  livr=this.jdbcTemplate.queryForObject("select isbn,auteur,titre,prix,quantite,photo, resume from livre where isbn=?",
                new Object[]{isbn}, new LivreMapper());
                return livr;
    }
public void updateLivre(Livre p) {
        jdbcTemplate.update("update livre set  auteur=?,titre=?,prix=?,quantite=?,photo=? resum=? where isbn=?",
                new Object[]{p.getAuteur(),p.getTitre(),p.getPrix(), p.getQuantite(),p.getPhoto(),p.getResum()});
               // p.getAuteur(),p.getTitre(),p.getPrix(), p.getQuantite(),p.getPhoto(),p.getResum());
    }


    public Long getLivreCount() {
        return jdbcTemplate.queryForObject("select count(*) from livre",
                Long.class);
    }
public void delete(int isbn) {
        jdbcTemplate.update("delete from livre where isbn=?",new Object[]{isbn});
      //  jdbcTemplate.update("delete from livre where isbn=?",isbn);
    }

private class LivreMapper implements RowMapper<Livre>{
        @Override
        public Livre mapRow(ResultSet rs, int i) throws SQLException {
            return new Livre( rs.getInt("isbn"), rs.getString("auteur"), rs.getString("titre"), rs.getDouble("prix"), rs.getInt("quantite"), rs.getString("photo"), rs.getString("resum"));
        }
    }


}
