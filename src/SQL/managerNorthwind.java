import java.sql.*;
import java.util.Scanner;

public class managerNorthwind {
    private static String strSelect;
    private static ResultSet rset;
    private static Scanner scanner = new Scanner(System.in);
    private static int rowCount = 0;

    public static void main(String[] args) {
        queryList();
            System.out.println("Nhập lựa chọn: ");
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    ShowCustomersByID();
                    break;
                case 2:
                    FindCustomerByName();
                    break;
                case 3:
                    ShowProductList();
                    break;
                case 4:
                    FindProductByPrice();
                    break;
                case 5:
                    DetailOfProduct();
                    break;

            }

    }
    public static void queryList(){
        System.out.println("Chọn truy vấn: \n1. Hiển thị danh sách khách hàng\n2.Tìm khách hàng theo tên\n3. Hiển thị danh sách sản phẩm\n4. Tìm sản phẩm theo giá bán trong khoảng do người dùng nhập vào\n5. Hiển thị thông tin chi tiết của một đơn hàng\n");
    }


    public static void ShowCustomersByID(){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            strSelect = "select * from customers order by CustomerID ASC";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            while (rset.next()){
                String ID = rset.getString("CustomerID");
                String CompanyName = rset.getString("ContactName");
                String ContactName = rset.getString("ContactName");
                String ContactTitle = rset.getString("ContactTitle");
                String Address = rset.getString("Address");
                String City = rset.getString("City");
                String Region = rset.getString("Region");
                String PostalCode = rset.getString("PostalCode");
                String Country = rset.getString("Country");
                String Phone = rset.getString("Phone");
                String Fax = rset.getString("Fax");
                System.out.println(ID + ", " + CompanyName + ", " + ContactName + ", " + ContactTitle + ", " + Address + ", " +
                        City + ", " + Region + ", " + PostalCode + ", " + Country + ", " + Phone + ", " + Fax);
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch(SQLException ex){
            ex.printStackTrace();
        }

    }
    public static void FindCustomerByName(){

        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Nhập tên Khách hàng: ");
            String name = scanner.nextLine();
            name = scanner.nextLine();
            strSelect = "select * from customers where ContactName='" + name + "' order by CustomerID ASC";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            while (rset.next()){
                String ID = rset.getString("CustomerID");
                String CompanyName = rset.getString("ContactName");
                String ContactName = rset.getString("ContactName");
                String ContactTitle = rset.getString("ContactTitle");
                String Address = rset.getString("Address");
                String City = rset.getString("City");
                String Region = rset.getString("Region");
                String PostalCode = rset.getString("PostalCode");
                String Country = rset.getString("Country");
                String Phone = rset.getString("Phone");
                String Fax = rset.getString("Fax");
                System.out.println(ID + ", " + CompanyName + ", " + ContactName + ", " + ContactTitle + ", " + Address + ", " +
                        City + ", " + Region + ", " + PostalCode + ", " + Country + ", " + Phone + ", " + Fax);
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ShowProductList(){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            strSelect = "select * from products";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            while (rset.next()){
                int ID = rset.getInt("ProductID");
                String ProductName = rset.getString("ProductName");
                int SupplierID = rset.getInt("SupplierID");
                String QuantityPerUnit = rset.getString("QuantityPerUnit");
                double UnitPrice = rset.getDouble("UnitPrice");
                int UnitsInStock = rset.getInt("UnitsInStock");
                int UnitsOnOrder = rset.getInt("UnitsOnOrder");
                int ReorderLevel = rset.getInt("ReorderLevel");
                int Discontinued = rset.getInt("Discontinued");
                System.out.printf("%d, %s, %d, %s, %.4f, %d, %d, %d, %d %n",ID, ProductName,SupplierID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void FindProductByPrice(){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Nhập giá nhỏ nhất: ");
            double price1 = scanner.nextDouble();
            System.out.println("Nhập giá lớn nhất: ");
            double price2 = scanner.nextDouble();
            strSelect = "select * from products where UnitPrice >= '" + price1 + "' && UnitPrice <= '" + price2 + "'";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            while (rset.next()){
                int ID = rset.getInt("ProductID");
                String ProductName = rset.getString("ProductName");
                int SupplierID = rset.getInt("SupplierID");
                String QuantityPerUnit = rset.getString("QuantityPerUnit");
                double UnitPrice = rset.getDouble("UnitPrice");
                int UnitsInStock = rset.getInt("UnitsInStock");
                int UnitsOnOrder = rset.getInt("UnitsOnOrder");
                int ReorderLevel = rset.getInt("ReorderLevel");
                int Discontinued = rset.getInt("Discontinued");
                System.out.printf("%d, %s, %d, %s, %.4f, %d, %d, %d, %d %n",ID, ProductName,SupplierID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void DetailOfProduct(){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            name = scanner.nextLine();

            strSelect = "select * from products where ProductName = '" + name + "'";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            while (rset.next()){
                int ID = rset.getInt("ProductID");
                String ProductName = rset.getString("ProductName");
                int SupplierID = rset.getInt("SupplierID");
                String QuantityPerUnit = rset.getString("QuantityPerUnit");
                double UnitPrice = rset.getDouble("UnitPrice");
                int UnitsInStock = rset.getInt("UnitsInStock");
                int UnitsOnOrder = rset.getInt("UnitsOnOrder");
                int ReorderLevel = rset.getInt("ReorderLevel");
                int Discontinued = rset.getInt("Discontinued");
                System.out.printf("%d, %s, %d, %s, %.4f, %d, %d, %d, %d %n",ID, ProductName,SupplierID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
