package by.str.connector.dao;

import by.str.connector.model.CheckData;
import by.str.connector.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DataRepo implements Data{

    private final JdbcTemplate jdbcTemplate;

    public DataRepo(DataSource dataSoruce) {
        jdbcTemplate = new JdbcTemplate(dataSoruce);
    }

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO employee(EMPLOYEE_ID,NAME,AGE,SALARY) values(?,?,?,?)";

        try {

           jdbcTemplate.update(sql,
                    new Object[] { employee.getId(), employee.getName(), employee.getAge(), employee.getSalary() });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String checkData(Long id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("library").withProcedureName("read_employee");
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_employeeId", id);
        Map<String, Object> out = jdbcCall.execute(in);
        String jsonOut = (String) out.get("string");
        return jsonOut;
    }

}
