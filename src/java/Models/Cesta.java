
package Models;

public class Cesta {
    private Student student;
    private ActivityAll activity;
    private String detalle;

    public Cesta() {
    }

    public Cesta(Student student, ActivityAll activity, String detalle) {
        this.student = student;
        this.activity = activity;
        this.detalle = detalle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ActivityAll getActivity() {
        return activity;
    }

    public void setActivity(ActivityAll activity) {
        this.activity = activity;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}
