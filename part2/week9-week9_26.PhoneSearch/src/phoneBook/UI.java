/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneBook;

import java.util.Scanner;

/**
 *
 * @author Marcell
 */
public class UI {
    private Scanner reader;
    private PhoneBook phoneBook;
    
    public UI(Scanner reader) {
        this.reader = reader;
        this.phoneBook = new PhoneBook();
        
    }
    
    public void start() {
        System.out.println("phone search");
        printCommands();
        while(true){
            System.out.print("command: ");
            String command = this.reader.nextLine();
            if(!command.equals("x")) {
                computeCommand(command);
            }else{
                break;
            }
        }
    }
    
    private void printCommands() {
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        System.out.println("");
    }
    
    private void computeCommand(String command) {
        if(command.length() == 1){
            switch(command.charAt(0)){
                case '1': addNumber(); break;
                case '2': searchByName(); break;
                case '3': searchByNumber(); break;
                case '4': addAddress(); break;
                case '5': getInfo(); break;
                case '6': remove(); break;
                case '7': searchByKeyword(); break;
            }
        }
    }
    
    private void addNumber() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();
        
        this.phoneBook.addNumber(name, number);
        System.out.println("");
    }
    
    private void addAddress() {
        System.out.print("whose address: ");
        String name = this.reader.nextLine();
        System.out.print("street: ");
        String street = this.reader.nextLine();
        System.out.print("city: ");
        String city = this.reader.nextLine();
        System.out.println("");
        this.phoneBook.addAddress(name, street + " " + city);
        System.out.println("");
    }
    
    private void getInfo() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        if(this.phoneBook.searchByName(name) == null && this.phoneBook.getAddresses(name) == null) {
            System.out.println("  not found");
            return;
        }
        if(this.phoneBook.getAddresses(name) != null) {
            for(String address : this.phoneBook.getAddresses(name)) {
                System.out.println("  address: " + address);
            }
        }else{
            System.out.println("  address unknown");
        }
        if(this.phoneBook.searchByName(name) != null) {
            System.out.println("  phone numbers:");
            for(String number : this.phoneBook.searchByName(name)){
                System.out.println("   " + number);
            }
        }else{
            System.out.println("  phone number not found");
        }
        System.out.println("");
    }
    
    private void searchByName() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        if(this.phoneBook.searchByName(name) != null) {
            for(String number : this.phoneBook.searchByName(name)){
                System.out.println(" " + number);
            }
        }else{
            System.out.println("  not found");
        }
        System.out.println("");
    }
    
    private void searchByNumber() {
        System.out.print("number: ");
        String number = this.reader.nextLine();
        if(this.phoneBook.searchByNumber(number) != null) {
            System.out.println("  " + this.phoneBook.searchByNumber(number));
        }else{
            System.out.println("  not found");
        }
        System.out.println("");
    }
    
    private void remove() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        System.out.println("");
        this.phoneBook.remove(name);
    }
    
    private void searchByKeyword() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();
        System.out.println("");
        if(this.phoneBook.searchByKeyword(keyword).isEmpty()){
            System.out.println(" keyword not found");
        }else{
            for(String name : this.phoneBook.searchByKeyword(keyword)) {
                System.out.println("  " + name);
                if(this.phoneBook.getAddresses(name) != null) {
                    for(String address : this.phoneBook.getAddresses(name)) {
                        System.out.println("  address: " + address);
                    }
                }else{
                    System.out.println("   address unknown");
                }
                if(this.phoneBook.searchByName(name) != null) {
                    System.out.println("   phone numbers:");
                    for(String number : this.phoneBook.searchByName(name)){
                        System.out.println("    " + number);
                    }
                }else{
                    System.out.println("   phone number not found");
                }
                System.out.println("");
            }
        }
    }
}
