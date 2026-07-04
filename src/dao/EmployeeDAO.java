package dao;

import interfaces.DAO;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO implements DAO<Employee> {
    private Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Optional<Employee> get(int id) {

        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                rs.next();

                // check if the result set is not null else return and optional empty
                if(!rs.wasNull()){

                    Employee neweEmployee = new Employee();

                    neweEmployee.setEmployee_id(rs.getInt("employee_id"));
                    neweEmployee.setFirst_name(rs.getString("first_name"));
                    neweEmployee.setLast_name(rs.getString("last_name"));
                    neweEmployee.setEmail(rs.getString("email"));
                    neweEmployee.setHire_date(rs.getDate("hire_date").toLocalDate());
                    neweEmployee.setPhone(rs.getString("phone"));
                    neweEmployee.setSalary(rs.getLong("salary"));
                    neweEmployee.setStatus(rs.getString("status"));
                    neweEmployee.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());

                    return Optional.of(neweEmployee);
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    Employee employee = new Employee();

                    employee.setEmployee_id(rs.getInt("employee_id"));
                    employee.setFirst_name(rs.getString("first_name"));
                    employee.setLast_name(rs.getString("last_name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setHire_date(rs.getDate("hire_date").toLocalDate());
                    employee.setPhone(rs.getString("phone"));
                    employee.setSalary(rs.getLong("salary"));
                    employee.setStatus(rs.getString("status"));
                    employee.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                    employee.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());

                    employees.add(employee);

                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public void insert(Employee e) {
        String sql = "INSERT INTO employees (first_name, last_name, email, phone, hire_date, salary) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1, e.getFirst_name());
            st.setString(2, e.getLast_name());
            st.setString(3, e.getEmail());
            st.setString(4, e.getPhone());
            st.setDate(5, Date.valueOf(e.getHire_date()));
            st.setLong(6, e.getSalary());

            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    public Optional<Employee> getByName(String name) {
        return Optional.empty();
    }

    public  Optional<Employee> getByEmail(String email) {
        return Optional.empty();
    }

    public void filterByDepartment(Employee employee) {
    }

    public void filterByHireDate(Employee employee) {
    }
}
