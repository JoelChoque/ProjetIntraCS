package Models;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

public class ActivityData {

    public List<Activity> getAllActivitys() {
        List<Activity> activitys = DataSource.getDataSource().query("select * from activity", new ActivityMapper());
        return activitys;
    }

    public Activity getActivityId(int idActivity) {
        Activity activity = (Activity) DataSource.getDataSource().queryForObject("select * from activity where id_activity=?", new Object[]{idActivity}, new BeanPropertyRowMapper<>(Activity.class));
        return activity;
    }

    public boolean existsActivity(int idActivity) {
        Integer count= DataSource.getDataSource().queryForObject("select count(*) from choix where id_activity=?", new Object[]{idActivity},Integer.class);
        return count>0;
    }

    public Activity getActivityIdEdentity(int idEdentity) {
        Activity activity = (Activity) DataSource.getDataSource().queryForObject("select * from activity where id_entity=?", new Object[]{idEdentity}, new BeanPropertyRowMapper<>(Activity.class));
        return activity;
    }

    public void saveActivity(Activity s) {
        if (s.getId_activity() != 0) {
            DataSource.getDataSource().update("update activity set id_entity=?, name=?,date_ini=?,date_fin=? where id_activity=?",
                    new Object[]{s.getId_entity(), s.getName(), s.getDate_ini(), s.getDate_fin(), s.getId_activity()});

        } else {
            DataSource.getDataSource().update("insert into activity(id_entity,name,date_ini,date_fin) values(?,?,?,?)",
                    new Object[]{s.getId_entity(), s.getName(), s.getDate_ini(), s.getDate_fin()});
        }
    }

    public void deleteActivity(int id) {
        DataSource.getDataSource().update("delete from activity where id_activity=?",
                new Object[]{id});

    }

    private class ActivityMapper implements RowMapper<Activity> {

        @Override
        public Activity mapRow(java.sql.ResultSet rs, int i) throws SQLException {
            return new Activity(rs.getInt("id_activity"), rs.getInt("id_entity"), rs.getString("name"), rs.getString("date_ini"), rs.getString("date_fin"));
        }
    }
}
