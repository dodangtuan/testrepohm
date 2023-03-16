package DAO;

import Database.Connect;
import Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Database.Connect.getConnection;

public class StudentDAO {

    public List<Student> showAll() {
        List<Student> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Student std = new Student(
                        rs.getInt("stdCode"),
                        rs.getString("stdname"),  // lấy dữ liệu từng cot trong bảng
                        rs.getInt("stdAge"),
                        rs.getString("stdClass"),
                        rs.getDouble("stdGpa"),
                        rs.getString("stdGender"));
                ls.add(std);  // lưu theo hàng vào list ls
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

    public Student showById(int id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM students WHERE stdCode = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            Student s = null;
            while(rs.next()) {
                Integer stdCode = rs.getInt("stdCode");
                String stdName = rs.getString("stdName");
                Integer stdAge = rs.getInt("stdAge");
                String stdClass = rs.getString("stdClass");
                Double stdGpa = rs.getDouble("stdGpa");
                String stdGender = rs.getString("stdGender");
                s = new Student(stdCode,stdName,stdAge,stdClass,stdGpa,stdGender);
            }
            return s;
        } catch (Exception s) {
            throw new RuntimeException(s);
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


    public void insert(List<Student> students) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "INSERT INTO students(stdName, stdAge, stdClass, stdGPA, stdGender) VALUES (?,?,?,?,?)";
            prst = conn.prepareStatement(sql);
            for(Student s : students) {
                prst.setString(1, s.getStdName());
                prst.setInt(2, s.getStdAge());
                prst.setString(3, s.getStdClass());
                prst.setDouble(4, s.getStdGPA());
                prst.setString(5, s.getStdGender());
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

    public Student update(int id, Student std) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE students SET " +
                    "`stdName`= " + "'" + std.getStdName() + "'"
                    + ", `stdAge`= " + "'" + std.getStdAge() + "'"
                    + ", `stdClass`= " + "'"+ std.getStdClass() +"'"
                    + ", `stdGpa`= " + std.getStdGPA()
                    + ", `stdGender`= '" + std.getStdGender() + "'"
                    + " WHERE stdCode = " + id;
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
        return std;
    }

    public Student delete(int id) {
        Connection conn = null;
        Statement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            prst = conn.createStatement();
            String sql = "DELETE FROM students WHERE stdCode =" + id;
            prst.executeUpdate(sql);
            System.out.println("Xóa thành công sinh vien có id :" + id);
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
        return null;
    }


    public Student showByName(String name) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM students WHERE stdName = '" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);
            Student s = null;
            while(rs.next()) {
                Integer stdCode = rs.getInt("stdCode");
                String stdName = rs.getString("stdName");
                Integer stdAge = rs.getInt("stdAge");
                String stdClass = rs.getString("stdClass");
                Double stdGpa = rs.getDouble("stdGpa");
                String stdGender = rs.getString("stdGender");
                s = new Student(stdCode,stdName,stdAge,stdClass,stdGpa,stdGender);
            }
            return s;
        } catch (Exception s) {
            throw new RuntimeException(s);
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

    public List<Student> showGPAhight8() {
        List<Student> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM students WHERE stdGPA > 8.0";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Student std = new Student(
                        rs.getInt("stdCode"),
                        rs.getString("stdname"),  // lấy dữ liệu từng cot trong bảng
                        rs.getInt("stdAge"),
                        rs.getString("stdClass"),
                        rs.getDouble("stdGpa"),
                        rs.getString("stdGender"));
                ls.add(std);  // lưu theo hàng vào list ls
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


//    public List<Student>  findStudentsByGPAAndClass(double stdGpa, String stdClass) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            conn = Connect.getInstance().getConnection();
//            stmt = conn.createStatement();
//            String sql = "SELECT * FROM students WHERE GPA > " + stdGpa + "AND stdClass = '" + stdClass + "' ";
//            ResultSet rs = stmt.executeQuery(sql);
//            Student s = null;
//            while(rs.next()) {
//                Integer stdCode = rs.getInt("stdCode");
//                String stdName = rs.getString("stdName");
//                Integer stdAge = rs.getInt("stdAge");
//
//                String stdGender = rs.getString("stdGender");
//                s = new Student(stdCode,stdName,stdAge,stdClass,stdGpa,stdGender);
//            }
//            return s;
//        } catch (Exception s) {
//            throw new RuntimeException(s);
//        } finally {
//            if(stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
}

