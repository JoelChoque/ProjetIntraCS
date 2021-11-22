package Models;

public class Student {

    private int id_student;
    private String name;
    private String email;
    private String telephone;
    private String sexo;
    
    private Usager usager;

    public Student() {
    }

    public Student(int id_student, String name, String email, String telephone, String sexo, Usager usager) {
        this.id_student = id_student;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.sexo = sexo;
        this.usager = usager;
    }

    public Student(int id_student, String name, String email, String telephone, String sexo) {
        this.id_student = id_student;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.sexo = sexo;
    }

    public Student(int id_student, String name) {
        this.id_student = id_student;
        this.name = name;
    }

    

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    
   

}
