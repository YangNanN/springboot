package example.dao;

import example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(final User user) {
        final String sql = "INSERT INTO User(Name,Age) VALUES(?,?)";
        Object[] params = new Object[] {user.getName(), user.getAge()};
        jdbcTemplate.update(sql, params);
    }

    public void addUser(final String name, final int age) {
        final String sql = "INSERT INTO User(Name,Age) VALUES(?,?)";
        Object[] params = new Object[] {name, age};
        jdbcTemplate.update(sql, params);
    }
    
    public void deleteUserByID(final int id) {
    	final String sql = "DELETE FROM User WHERE ID = ?";
    	Object[] params = new Object[] {id};
    	jdbcTemplate.update(sql, params);
    }
    
    public void deleteUserByName(final String name) {
    	final String sql = "DELETE FROM User WHERE Name = ?";
    	Object[] params = new Object[] {name};
    	jdbcTemplate.update(sql, params);
    }
    
    public void updateUserNameByID(final int id, final String name) {
    	final String sql = "UPDATE User SET Name = ? WHERE ID = ?";
    	Object[] params = new Object[] {name, id};
    	jdbcTemplate.update(sql, params);
    }
    
    public String queryNameByID(final int id) {
    	final String sql = "SELECT Name FROM User WHERE ID = ?";
    	Object[] params = new Object[] {id};
    	return jdbcTemplate.queryForObject(sql, params, String.class);
    }

    @SuppressWarnings("unchecked")
    public List<User> queryUserByName(final String name) {
    	final String sql = "SELECT * FROM User WHERE Name = ?";
    	Object[] params = new Object[] {name};
    	return (List<User>)jdbcTemplate.query(sql, params, new RowMapper() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getString("Name"), rs.getInt("Age"));
            }
        });
    }
}
