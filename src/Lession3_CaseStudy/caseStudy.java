package Lession3_CaseStudy;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Contact{
    private String name;
    private String phone;

    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    ArrayList<String> contactList = new ArrayList<>();

    public void setContactList(ArrayList<String> contactList) {
        this.contactList = contactList;
    }

    public ArrayList<String> getContactList(){
        return contactList;
    }
    public void printContractLists(){
        System.out.println("You have " + contactList.size() + "contacts");
        for(int i = 0; i < contactList.size(); i++){
            System.out.println(i + " - " + contactList.get(i) );
        }
    }
    public static Contact creatContact(String name, String phone){
        return new Contact(name,phone);
    }



}
class Contactlist {

    private List<Contact> ct = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // danh sách danh bạ có sẵn
    public void Contacted() {
        ct.add(new Contact("Manh Hung", "123456789"));
        ct.add(new Contact("m", "1"));
        ct.add(new Contact("Manh Thai", "1212356789"));
        ct.add(new Contact("Tuan hung", "123888889"));
    }

    // thêm danh bạ mới
    public void addNewContact() {
        int result = findContact();
        if (result < 0){
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter phone number: ");
            String phone = scanner.nextLine();
            Contact newContact = Contact.creatContact(name, phone);
            System.out.println(newContact);
            ct.add(newContact);
            System.out.println("Add contact successfully!");
        } else {
            System.out.println("The contact is exited!");
        }
    }

    // hiển thị danh bạ
    public void printList() {
        for (int i = 0; i < ct.size(); i++) {
            System.out.println((i + 1) + "-" + ct.get(i));
        }
    }

    //sửa đổi danh bạ
    public void updateContact() {
        int result = findContact();
        if (result > 0) {
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            System.out.println("Enter new number: ");
            String phone = scanner.nextLine();
            ct.set(result, new Contact(name, phone));
            System.out.println("Update contact successfully!");
        } else if (result < 0) {
            System.out.println("Invalid contact!!!!");
        }
    }

    //xóa liên hệ trong danh bạ
    public void removeContacted() {
        int result = findContact();
        if (result > 0) {

            ct.remove(result);
            System.out.println("Delete successfully!");
        } else if (result < 0) {
            System.out.println("Invalid contact!!!!");
        }
    }

    // tìm trong danh bạ
    public int findContact() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter number: ");
        String phone = scanner.nextLine();
        for (Contact x : ct) {
            if (x.getName().equals(name) && x.getPhone().equals(phone)) {
                System.out.println(ct.indexOf(x) + "-" + x);

                return ct.indexOf(x);
            }

        }
        System.out.println("Invalid contact");
        return -1;
        //hiển thị  cấu trúc
    }

    public void queryContact() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        for (Contact x : ct) {
            if (x.getName().equals(name)) {
                System.out.println(x.toString());
                break;
            }
            System.out.println("Null");
        }

    }


    public void main(){
        System.out.println("Starting phone...");
        System.out.println("Available actions: \nPress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contact\n" +
                "2 - to add a new contacts\n" +
                "3 - to update existing an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - to query if an existing contact exists\n" +
                "6 - to print a list of available actions.\n" +
                "Choose your action\n" +
                "Enter action: (6 to show available actions)");

    }
}

public class caseStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contactlist ct1 = new Contactlist();
        ct1.main();
        ct1.Contacted();

        int action = scanner.nextInt();

            switch (action) {
                case 0:
                    System.out.println("Shutdown.....!!!!");
                    break;
                case 1:
                    ct1.printList();
                    break;
                case 2:
                    ct1.addNewContact();
                    break;
                case 3:
                    ct1.updateContact();
                    break;
                case 4:
                    ct1.removeContacted();
                    break;
                case 5:
                    ct1.queryContact();
                    break;
                case 6:
                    ct1.main();


            }
        }
}
