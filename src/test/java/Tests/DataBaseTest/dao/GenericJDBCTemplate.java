package Tests.DataBaseTest.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public abstract class GenericJDBCTemplate <T> {

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


    //crud methods

    abstract public List<T> get();

    abstract public T get(int id);

    abstract public int add(T t);

    abstract public int delete(T t);

    abstract public int update(T t);
}
