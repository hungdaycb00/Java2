package ManagerStudent;

import java.sql.*;
import java.util.Scanner;

public class StudentMenu  {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println(">>>Welcome<<<");
        System.out.println("1. Add student records\n2. Display student records\n3. Save\n4. Exit\n");
        System.out.println("Select your choose: ");
        int action = scanner.nextInt();
        switch (action){
            case 1:
                AddStudent();
                break;
            case 2:
                ViewStudent();
                break;
            case 3:
                break;
            case 4:
                System.out.println("Exit....");
                break;
        }
    }
    private static void AddStudent(){
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/list_students?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            Student student = new Student();
            System.out.println("Enter new id: ");
            int id = scanner.nextInt();
            student.setStudentID(id);
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            name = scanner.nextLine();
            student.setName(name);
            System.out.println("Enter student address: ");
            String address = scanner.nextLine();
            student.setAddress(address);
            System.out.println("Enter student phone: ");
            int phone = scanner.nextInt();
            student.setPhone(phone);
            int countInsert = stmt.executeUpdate("insert into students values (" + student.getStudentID() + ", '" + student.getName() + "', '" + student.getAddress() + "', " + student.getPhone() );
            System.out.println(countInsert + " records intserted.");
            System.out.println("The value is: ");
            System.out.println(student.toString());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private static void ViewStudent(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/list_students?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            ResultSet rset = stmt.executeQuery("select * from students");
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();
            for(int i = 1; i <= numColumns; ++i){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();
            for(int i = 1; i <= numColumns; ++i){
                System.out.printf("%-30s","(" + rsetMD.getColumnClassName(i) + ")");
            }
            System.out.println();
            int rowCount = 0;
            while (rset.next()){
                for(int i = 1; i <= numColumns; ++i){
                    System.out.printf("%-30s", rset.getString(i));
                }
                rowCount++;
                System.out.println();
            }
            System.out.println("Total number of records = " + rowCount);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
