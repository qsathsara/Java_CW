import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Ship myShip = new Ship();//all cabins gets initialized to "z"

        char option;//users option at the menu
        int cabinNum;//cabin number required
        String firstName;
        String surName;

        while (true) {
            //Option Menu
            System.out.println(
                    "\n<<<<<<<<<<<<<<<<<<<<<<<<<< Boarding System >>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
                            "V - View All Cabins\n" +
                            "A - Add Customer to Cabin\n" +
                            "E - Display Empty Cabins\n" +
                            "D - Delete customer from Cabin\n" +
                            "F - Find cabin from customer name\n" +
                            "S - Store program data into file\n" +
                            "L - Load program data from file\n" +
                            "O - Ordered alphabetically by name.\n" +
                            "T - Total expences.\n"+
                            "Q - Quit\n" +
                            "-<<<<<<<<<<<<<<<<<<<<<<<    Boarding System    >>>>>>>>>>>>>>>>>>>>>>>\n"
            );

            System.out.print("Select your option: ");
            option = (char) (input.next().charAt(0) & 0x5f);//Convert inout to upper case
            System.out.println("");

            if (option == 'V') {
                System.out.println("View all Cabins:>>>>>>>");
                //view(ship);//calling view method
                myShip.view();
            } else if (option == 'A') {
                System.out.println("Add customer to cabin:>>>>>>>");
                myShip.add();//calling add method
            } else if (option == 'E') {
                System.out.println("Empty cabins:>>>>>>>>");
                //calls the isEmpty method and checks if each cabin is empty or not
                for (int i = 0; i < myShip.getCabins().length - 1; i++) {
                    if (myShip.isEmpty(i) != -1) {
                        System.out.println("Cabin " + i);//Display cabin number is the function returns the number
                    }
                }
            } else if (option == 'D') {
                System.out.println("<<<< Delete a customer >>>>");
                System.out.print("Enter Cabin number: ");
                cabinNum = input.nextInt();//store the cabin number the user want to delete
                myShip.delete(cabinNum);
            } else if (option == 'F') {
                System.out.println("<<<< Find a customer >>>>");
                System.out.print("Enter  passenger's first name: ");
                firstName = input.next();//get the first name to find cabinnumber
                System.out.print("Enter  passenger's sur name: ");
                surName = input.next();//get the last name to find cabin number
                myShip.find(firstName, surName);
            } else if (option == 'S') {
                System.out.println("Storing data to file.");
                myShip.store();
            } else if (option == 'L') {
                System.out.println("Loading data from file.");
                myShip.load();
            } else if (option == 'O') {
                System.out.println("Names in Alphabetical order.");
                myShip.sortNames();
            } else if(option=='T') {
                System.out.println("Total Expences");
                myShip.store();

            } else if (option == 'Q') {
                System.out.println("System will terminate!");
                break;
            }
            else {
                System.out.println("Option not found!");
            }
        }
    }
}
