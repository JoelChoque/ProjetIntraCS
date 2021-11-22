
package Models;

public class Entity {
    private int id_entity;
    private String name;
    private String email;
    private String adress;
    private String telephone;

    public Entity() {
    }

    public Entity(int id_entity, String name, String email, String adress, String telephone) {
        this.id_entity = id_entity;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.telephone = telephone;
    }

    public Entity(String name) {
        this.name = name;
    }
    
    

    public int getId_entity() {
        return id_entity;
    }

    public void setId_entity(int id_entity) {
        this.id_entity = id_entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
}
