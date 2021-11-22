
package Models;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

public class EntityData {
    public List<Entity> getAllEntitys() {
        List<Entity> entitys = DataSource.getDataSource().query("select * from entity", new EntityMapper());
        return entitys;
    }

    public Entity getEntityId(int idEntity) {
        Entity entity = (Entity) DataSource.getDataSource().queryForObject("select * from entity where id_entity=?", new Object[]{idEntity}, new BeanPropertyRowMapper<>(Entity.class));
        return entity;
    }

    public void saveEntity(Entity s) {
        if (s.getId_entity()!= 0) {
            DataSource.getDataSource().update("update entity set name=?,email=?,adress=?,telephone=? where id_entity=?",
                    new Object[]{s.getName(), s.getEmail(), s.getAdress(), s.getTelephone(),s.getId_entity()});

        } else {
            DataSource.getDataSource().update("insert into entity(name,email,adress,telephone) values(?,?,?,?)",
                    new Object[]{s.getName(), s.getEmail(),s.getAdress(), s.getTelephone()});
        }
    }

    public void deleteEntity(int id) {
        DataSource.getDataSource().update("delete from entity where id_entity=?",
                new Object[]{id});

    }

    private class EntityMapper implements RowMapper<Entity> {

        @Override
        public Entity mapRow(java.sql.ResultSet rs, int i) throws SQLException {
            return new Entity(rs.getInt("id_entity"), rs.getString("name"), rs.getString("email"),rs.getString("adress"), rs.getString("telephone"));
        }
    }
}
