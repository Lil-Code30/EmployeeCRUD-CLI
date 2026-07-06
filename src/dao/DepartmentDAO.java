package dao;

import interfaces.DAO;
import models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentDAO implements DAO<Department> {
    private Connection conn;

    public DepartmentDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Optional<Department> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Department> getAll() {
        String query = "SELECT * FROM departments";

        List<Department> departments = new ArrayList<>();

        try(PreparedStatement st = conn.prepareStatement(query)){
            try(ResultSet rs = st.executeQuery()){
                while(rs.next()){
                    Department d = new Department();

                    d.setDepartment_name(rs.getString("department_name"));
                    d.setDepartment_id(rs.getInt("department_id"));
                    d.setLocation(rs.getString("location"));

                    departments.add(d);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public void insert(Department entity) {
        String sql = "INSERT INTO departments(department_name,location) VALUES(?,?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, entity.getDepartment_name());
            stmt.setString(2, entity.getLocation());

            stmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department department) {

    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
