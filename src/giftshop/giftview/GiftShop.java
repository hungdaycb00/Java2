package giftshop.giftview;

import giftshop.giftcontroller.GiftController;

import java.util.Scanner;

public class GiftShop extends GiftController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>>>>>Wellcome<<<<<<");
        System.out.println("1. View all gift.\n2. Insert new gift.\n3. Delete gift by id.\n4. Exit");
        System.out.println("Select your choose: ");
        int action = scanner.nextInt();
        switch (action){
            case 1:
               SelectBook();
               break;
            case 2:
                InsertBook();
                break;
            case 3:
                DeleteBookById();
                break;
            case 4:
                break;
        }
    }
}
