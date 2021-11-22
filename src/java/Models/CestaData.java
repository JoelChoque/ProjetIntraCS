package Models;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public class CestaData {

    public List<Cesta> getAllCesta(int id_student) {
        String sql = "SELECT c.id_student,s.name,a.id_activity,e.name,a.name,a.date_ini,a.date_fin\n"
                + "FROM choix c INNER JOIN student s \n"
                + "ON c.id_student=s.id_student INNER JOIN activity a\n"
                + "ON c.id_activity=a.id_activity INNER JOIN entity e\n"
                + "ON a.id_entity=e.id_entity\n"
                + "WHERE c.id_student=?";
        List<Cesta> cestaAll = DataSource.getDataSource().query(sql, new Object[]{id_student}, new CestaData.CestaMapper());
        return cestaAll;
    }

    public Integer getCountCart(int id_student) {
        Integer count = DataSource.getDataSource().queryForObject("select count(*) from choix where id_student=?", new Object[]{id_student}, Integer.class);
        return count;
    }

    public boolean existsActivity(int idStudent, int idActivity) {
        Integer count= DataSource.getDataSource().queryForObject("select count(*) from choix where id_student=? and id_activity=?", new Object[]{idStudent,idActivity},Integer.class);
        return count>0;
    }
    
    public void addToCesta(int id_student, int id_activity, String detalle) {
        DataSource.getDataSource().update("insert into choix(id_student,id_activity,detalle) values(?,?,?)",
                new Object[]{id_student, id_activity, detalle});

    }
    
    public void deleteEntity(int idStudent, int idActivity) {
        DataSource.getDataSource().update("delete from choix where id_student=? and id_activity=?",
                new Object[]{idStudent,idActivity});

    }

    private class CestaMapper implements RowMapper<Cesta> {

        @Override
        public Cesta mapRow(java.sql.ResultSet rs, int i) throws SQLException {
            Student student = new Student(rs.getInt(1), rs.getString(2));
            Entity entity=new Entity(rs.getString(4));
            ActivityAll activityAll = new ActivityAll(rs.getInt("id_activity"), entity, rs.getString(5), rs.getString(6), rs.getString(7));
            return new Cesta(student, activityAll, "");
        }
    }

}
