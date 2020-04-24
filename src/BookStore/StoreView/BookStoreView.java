package BookStore.StoreView;

import java.util.Scanner;

import static BookStore.StoreController.customerController.*;
import static BookStore.StoreController.storeController.*;
import static BookStore.user.InsertUser;
import static BookStore.user.LogIn;

public class BookStoreView {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int loop = 0;
        int count = 1;
        while (loop < 1){
            System.out.println(">>>Wellcome to EbookStore <<<");
            System.out.println("1. Login\n2. Sign Up");
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    if(LogIn() == true){
                        int loop2 = 1;
                        int action2;
                        while (loop2 > 0){
                            System.out.println("Select your choose: ");
                            System.out.println("1. Mannager Products\n2. Manager customer\n3. Exits");
                            action2 = scanner.nextInt();
                            switch (action2){
                                case 1:
                                    ManagerStore();
                                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                                    loop2 = scanner.nextInt();
                                    System.out.println("Exiting...");
                                    break;
                                case 2:
                                    ManagerCustomer();
                                    break;
                                default:
                                    System.out.println("Exitting....");
                                    loop2=0;
                                    break;
                            }
                        }
                        loop = 1;
                        break;
                    } else {
                        System.out.println("Login again " + count);
                        count++;
                        if (count == 3){
                            System.out.println("Login after 5 minutes!!!");
                            loop = 1;
                        }
                    }
                    break;
                case 2:
                    InsertUser();
                    break;
            }
        }

    }
    public static void ManagerStore(){
        int num = 1;
        while (num > 0){
            System.out.println(">>>>>>Wellcome<<<<<<");
            System.out.println("1. View all book.\n2. Insert new book.\n3. Delete book by id.\n4. Update book \n5. Top 100 Best seller\n6. Exit");
            System.out.println("Select your choose: ");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    SelectBook();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 2:
                    InsertBook();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 3:
                    DeleteBookById();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 4:
                    UpdateBookByID();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 5:
                    BestSeller100();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    num = 0;
                    break;
            }
        }
    }
    public static void ManagerCustomer(){
        int num = 1;
        while (num > 0){
            System.out.println(">>>>>>Wellcome<<<<<<");
            System.out.println("1. View all customer.\n2. Insert new customer.\n3. Delete customer by id.\n4. Update customer information \n5. Top 100 customer\n6. Exit");
            System.out.println("Select your choose: ");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    SelectCustomer();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 2:
                    InsertCustomer();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 3:
                    DeleteCustomerById();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 4:
                    UpdateCustomerById();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 5:
                    Top100Customer();
                    System.out.println("Enter number 1 to continues\nEnter 0 to exits...");
                    num = scanner.nextInt();
                    System.out.println("Exiting...");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    num = 0;
                    break;
            }
        }
    }
}
