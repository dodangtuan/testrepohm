package qlnhanvien.DAO;

import qlnhanvien.Database.Connect;
import qlnhanvien.Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void insert(List<Employee> employees) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "INSERT INTO employees(empFullName, empAddress, empSalary, empAge, empGender) VALUES (?,?,?,?,?)";
            prst = conn.prepareStatement(sql);
            for(Employee e : employees) {
                prst.setString(1, e.getFullName());
                prst.setString(2, e.getAddress());
                prst.setDouble(3, e.getSalary());
                prst.setInt(4, e.getAge());
                prst.setString(5, e.getGender());
                prst.executeUpdate();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public List<Employee> showAll() {
        List<Employee> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Employee e = new Employee(rs.getInt("empCode"),
                        rs.getString("empFullname"),  // lấy dữ liệu từng cot trong bảng
                        rs.getString("empAddress"),
                        rs.getFloat("empSalary"),
                        rs.getInt("empAge"),
                        rs.getString("empGender"));
                ls.add(e);  // lưu theo hàng vào list ls
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ls;
    }

    public Employee showById(int id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employees WHERE empCode = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            Employee e = null;
            while(rs.next()) {
                Integer empCode = rs.getInt("empCode");
                String fullName = rs.getString("empFullName");
                String address = rs.getString("empAddress");
                Double salary = rs.getDouble("empSalary");
                Integer age = rs.getInt("empAge");
                String gender = rs.getString("empGender");
                e = new Employee(empCode, fullName,address,salary,age,gender);
            }
            return e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public Employee update(int id, Employee e) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employees SET `empFullName`= " + "'" + e.getFullName() + "'"
                        + ", `empAddress`= " + "'" + e.getAddress() + "'"
                        + ", `empSalary`= " + e.getSalary()
                        + ", `empAge`= " + e.getAge()
                        + ", `empGender`= '" + e.getGender() + "'"
                        + " WHERE empCode = " + id;
            prst = conn.prepareStatement(sql);
            System.out.println(prst.toString());
            prst.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return e;
    }

    public Employee delete(int id) {
        Connection conn = null;
        Statement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            prst = conn.createStatement();
            String sql = "DELETE FROM employees WHERE empCode =" + id;
            prst.executeUpdate(sql);
            System.out.println("Xóa thành công người có id :" + id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //Bước 1: Kết nối CSDL
        //Bước 2: Chuẩn bị câu truy vấn delete
        //Bước 3: Thực thi câu truy vấn, đóng kết nối.
        return null;
    }
    //Thêm các phương thức còn lại.
}
