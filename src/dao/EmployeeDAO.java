package dao;

import interfaces.DAO;
import models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO implements DAO<Employee> {
    private Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Optional<Employee> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public void insert(Employee e) {
        String sql = "INSERT INTO employees () VALUES ()";

        try{
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, e.getFirst_name());
            // TODO: TO BE CONTINUE
            st.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }
}
