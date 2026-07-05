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

                // check if the result set is not null else return and optional empty
                if(rs.next()){

                    Employee newEmployee = new Employee();

                    newEmployee.setEmployee_id(rs.getInt("employee_id"));
                    newEmployee.setFirst_name(rs.getString("first_name"));
                    newEmployee.setLast_name(rs.getString("last_name"));
                    newEmployee.setEmail(rs.getString("email"));
                    newEmployee.setHire_date(rs.getDate("hire_date").toLocalDate());
                    newEmployee.setPhone(rs.getString("phone"));
                    newEmployee.setSalary(rs.getLong("salary"));
                    newEmployee.setStatus(rs.getString("status"));
                    newEmployee.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());

                    return Optional.of(newEmployee);
                }else {
                    return Optional.empty();
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
            // not yet implemented
    }

    @Override
    public boolean delete(int  id) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try(PreparedStatement st = conn.prepareStatement(sql)){
            st.setInt(1, id);

            st.executeUpdate();

            if(st.executeUpdate() > 0){
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    public Optional<List<Employee>> getByName(String name) {
        String sql = "SELECT * FROM employees WHERE first_name LIKE ? OR last_name LIKE ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");

            List<Employee> fetchEmployees = new ArrayList<>();

            try(ResultSet rs = stmt.executeQuery()){

                // check if the result set is not null else return and optional empty
                while(rs.next()){

                    Employee newEmployee = new Employee();

                    newEmployee.setEmployee_id(rs.getInt("employee_id"));
                    newEmployee.setFirst_name(rs.getString("first_name"));
                    newEmployee.setLast_name(rs.getString("last_name"));
                    newEmployee.setEmail(rs.getString("email"));
                    newEmployee.setHire_date(rs.getDate("hire_date").toLocalDate());
                    newEmployee.setPhone(rs.getString("phone"));
                    newEmployee.setSalary(rs.getLong("salary"));
                    newEmployee.setStatus(rs.getString("status"));
                    newEmployee.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());

                    fetchEmployees.add(newEmployee);
                }

                return Optional.of(fetchEmployees);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public  Optional<Employee> getByEmail(String email) {
        String sql = "SELECT * FROM employees WHERE email = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, email);

            try(ResultSet rs = stmt.executeQuery()){

                // check if the result set is not null else return and optional empty
                if(rs.next()){

                    Employee newEmployee = new Employee();

                    newEmployee.setEmployee_id(rs.getInt("employee_id"));
                    newEmployee.setFirst_name(rs.getString("first_name"));
                    newEmployee.setLast_name(rs.getString("last_name"));
                    newEmployee.setEmail(rs.getString("email"));
                    newEmployee.setHire_date(rs.getDate("hire_date").toLocalDate());
                    newEmployee.setPhone(rs.getString("phone"));
                    newEmployee.setSalary(rs.getLong("salary"));
                    newEmployee.setStatus(rs.getString("status"));
                    newEmployee.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());

                    return Optional.of(newEmployee);
                }else {
                    return Optional.empty();
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void filterByDepartment(Employee employee) {
    }

    public List<Employee> sortByHireDate() {

        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY hire_date";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    Employee e = new Employee();

                    e.setEmployee_id(rs.getInt("employee_id"));
                    e.setFirst_name(rs.getString("first_name"));
                    e.setLast_name(rs.getString("last_name"));
                    e.setEmail(rs.getString("email"));
                    e.setHire_date(rs.getDate("hire_date").toLocalDate());
                    e.setPhone(rs.getString("phone"));
                    e.setSalary(rs.getLong("salary"));
                    e.setStatus(rs.getString("status"));
                    e.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                    e.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());

                    employees.add(e);

                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return employees;
    }

    public List<Employee> filterBySalary(long amount) {

        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees Where salary >= ? ORDER BY salary DESC";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, amount);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    Employee e = new Employee();

                    e.setEmployee_id(rs.getInt("employee_id"));
                    e.setFirst_name(rs.getString("first_name"));
                    e.setLast_name(rs.getString("last_name"));
                    e.setEmail(rs.getString("email"));
                    e.setHire_date(rs.getDate("hire_date").toLocalDate());
                    e.setPhone(rs.getString("phone"));
                    e.setSalary(rs.getLong("salary"));
                    e.setStatus(rs.getString("status"));
                    e.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                    e.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());

                    employees.add(e);

                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return employees;
    }
}
