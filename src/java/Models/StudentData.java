package Models;

import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

public class StudentData {

    public List<Student> getAllStudents() {
        List<Student> students = DataSource.getDataSource().query("select * from student", new StudentMapper());
        return students;
    }

    public Student getStudentId(int idStudent) {
        Student student = (Student) DataSource.getDataSource().queryForObject("select * from student where id_student=?", new Object[]{idStudent}, new BeanPropertyRowMapper<>(Student.class));
        return student;
    }

    public Student getStudentId(String username) {
        Student student=null;
        try {
            student = (Student) DataSource.getDataSource().queryForObject("select * from student where username=?", new Object[]{username}, new BeanPropertyRowMapper<>(Student.class));
        } catch (DataAccessException e) {
            System.out.println("Error:"+e);
        }
        
        return student;
    }

    public boolean existsActivity(int idStudent) {
        Integer count = DataSource.getDataSource().queryForObject("select count(*) from choix where id_student=?", new Object[]{idStudent}, Integer.class);
        return count > 0;
    }

    public void saveStudent(Student s) {
        DataSource.getDataSource().update("insert into student(name,email,telephone,sexo,username) values(?,?,?,?,?)",
                new Object[]{s.getName(), s.getEmail(), s.getTelephone(), s.getSexo(), s.getUsager().getUsername()});

    }

    public void updateStudent(Student s) {
        DataSource.getDataSource().update("update student set name=?,email=?,telephone=?,sexo=? where id_student=?",
                new Object[]{s.getName(), s.getEmail(), s.getTelephone(), s.getSexo(), s.getId_student()});

    }

    public void deleteStudent(int id) {
        DataSource.getDataSource().update("delete from student where id_student=?",
                new Object[]{id});

    }

    private class StudentMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(java.sql.ResultSet rs, int i) throws SQLException {
            return new Student(rs.getInt("id_student"), rs.getString("name"), rs.getString("email"), rs.getString("telephone"), rs.getString("sexo"));

        }
    }

}
