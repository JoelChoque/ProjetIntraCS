package Models;

public class Activity {
    private int id_activity;
    private int id_entity;
    private String name;
    private String date_ini;
    private String date_fin;

    public Activity() {
    }

    public Activity(int id_activity, int id_entity, String name, String date_ini, String date_fin) {
        this.id_activity = id_activity;
        this.id_entity = id_entity;
        this.name = name;
        this.date_ini = date_ini;
        this.date_fin = date_fin;
    }

    public int getId_activity() {
        return id_activity;
    }

    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
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

    public String getDate_ini() {
        return date_ini;
    }

    public void setDate_ini(String date_ini) {
        this.date_ini = date_ini;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }
    
    
}
