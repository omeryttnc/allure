package Tests.DataBaseTest.dao;

import Tests.DataBaseTest.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserJDBCTemplate extends GenericJDBCTemplate <User>{

    protected DataSource dataSource;
    protected JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource ds) throws Exception {

        try {
            this.dataSource = ds;
            this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
        } catch (Exception e) {
            throw new Exception("Cannot connect");
        }
    }

    @Override
    public List<User> get() {
        String SQL = "SELECT * FROM user";
        List <User> users = jdbcTemplateObject.query(SQL, new UserMapper());
        return users;
    }

    @Override
    public User get(int id) {
        String SQL = "select * FROM user where id=" + id;
        User c = (User) jdbcTemplateObject.queryForObject(SQL, new UserMapper());
        return c;
    }

    @Override
    public int add(User user) {
        String SQL = "INSERT INTO user (first_name, middle_name, last_name, email, zip_code, is_verified, phone, lat, lng) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return (jdbcTemplateObject.update(SQL, user.getFirst_name(), user.getMiddle_name(), user.getLast_name(),
                user.getEmail(), user.getZip_code(), user.getIs_verified(), user.getPhone(), user.getLat(), user.getLng()));
    }

    @Override
    public int delete(User user) {
        String SQL = "DELETE From user WHERE id=?";
        return (jdbcTemplateObject.update(SQL, user));
    }

    @Override
    public int update(User user) {
        String SQL = "UPDATE user SET first_name=?, middle_name, last_name=?, email=?, zip_code=?, is_verified=?, phone=?, lat=?, lng=? WHERE (id = ?);";
        return (jdbcTemplateObject.update(SQL, user.getFirst_name(), user.getMiddle_name(), user.getLast_name(),
                user.getEmail(), user.getZip_code(), user.getIs_verified(), user.getPhone(), user.getLat(), user.getLng()));
    }


}
