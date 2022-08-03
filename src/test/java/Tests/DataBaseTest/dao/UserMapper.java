package Tests.DataBaseTest.dao;

import Tests.DataBaseTest.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirst_name(rs.getString("first_name"));
        user.setMiddle_name(rs.getString("middle_name"));
        user.setLast_name(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setZip_code(rs.getInt("zip_code"));
        user.setIs_verified(rs.getInt("is_verified"));
        user.setPhone(rs.getString("phone"));
        user.setLat(rs.getString("lat"));
        user.setLng(rs.getString("lng"));

        return user;

    }
}
