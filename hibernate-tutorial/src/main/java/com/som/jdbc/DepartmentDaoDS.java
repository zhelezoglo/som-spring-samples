package com.som.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDaoDS {
    private String userName = "postgres";
    private String password = "pizdec";
    private String dbms = "postgresql";
    private String serverName = "localhost";
    private int portNumber = 5432;
    private String dbName = "test_db";

//    private String userName = "admin";
//    private String password = "vb_jM654lptA";
//    private String dbms = "postgresql";
//    private String serverName = "localhost";
//    private int portNumber = 5432;
//    private String dbName = "test_db";

    public synchronized Connection getConnection() throws SQLException {

//        Connection conn = DriverManager.getConnection(
//                "jdbc:postgresql://127.0.0.1:5433/postgres","admin", "vb_jM654lptA");

//        Connection conn = DriverManager.getConnection(
//                "jdbc:postgresql://admin:vb_jM654lptA@127.0.0.1:5433/blog");

        Connection conn = DriverManager.getConnection(
                "jdbc:" + this.dbms + "://" +
                        this.serverName +
                        ":" + this.portNumber + "/" + this.dbName,
                this.userName, this.password);
        System.out.println("Connected to database");
        return conn;
    }

    public void createDepartment(String name)
            throws SQLException {

        PreparedStatement createDepartmentStmt = null;
        String createString = "INSERT INTO department (dep_name) VALUES ( ? );";
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            createDepartmentStmt = connection.prepareStatement(createString);
            createDepartmentStmt.setString(1, name);
            createDepartmentStmt.executeUpdate();
            connection.commit();
            System.out.println(name + " department inserted");
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
        } finally {
            if (createDepartmentStmt != null) {
                createDepartmentStmt.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        DepartmentDaoDS departmentDaoDS = new DepartmentDaoDS();
//        departmentDao.createDepartment("Financial");
//        departmentDao.createDepartment("Administrative");


        Connection connection = departmentDaoDS.getConnection();
    }
}
