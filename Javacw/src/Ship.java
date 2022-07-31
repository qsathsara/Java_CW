import java.util.Locale;
import java.util.Scanner;
import java.io.File;//File Classes to create file
import java.io.IOException;// class ro handle error in file handling
import java.io.FileWriter;//File class to write to file
import java.io.FileNotFoundException;//Exception if file was not found

public class Ship {
    private final Cabin[] cabins = new Cabin[12];//Ship contains 12 cabins
    private final Queue waitingList = new Queue();//Waiting list

    public Cabin[] getCabins() {
        return cabins;
    }

    public Ship() {
        for (int x = 0; x < getCabins().length; x++) {
            getCabins()[x] = new Cabin(x, "e");
        }
    }

    //Find empty cabins
    public int isEmpty(int cabinNum) {

        if (getCabins()[cabinNum].getCabinName().equals("e")) {
            return cabinNum;
        } else

            return -1;
    }

    //View all cabins
    public void view() {
        for (int x = 0; x < getCabins().length; x++) {
            if (isEmpty(x) != -1) {

                System.out.println("cabin " + x + " is empty");
            } else {
                //display
                System.out.println("cabin" + x + " occupied by " + getCabins()[x].getPayingPassenger().getFirstName() + " " + getCabins()[x].getPayingPassenger().getSurName());
            }
        }
    }

    //Add customers
    public void add() {
        Scanner input = new Scanner(System.in);
        String cabinName;
        String firstName;
        String surName;
        String expenses;//Use for Expences
        int cabinNum;
        int passengers = 3;

        while (true) {
            String num;
            if (!isFull()) {
                System.out.print("Enter cabin number (0-11) and 12 to stop: ");
                num = input.next();//input cabin number
                try {
                    cabinNum = Integer.parseInt(num);

                    if (cabinNum < 12 && cabinNum >= 0) {
                        if (isEmpty(cabinNum) != -1) {
                            //Name for cabin
                            cabinName = "seafare"; //input.next();//store name for cabin
                            cabinName = cabinName.substring(0, 1).toUpperCase(Locale.ROOT) + cabinName.substring(1);
                            getCabins()[cabinNum].setCabinName(cabinName);//set name for cabin

                            //Input number of Passengers
                            String noOfPassengers;
                            //System.out.print("Enter number of Passengers in the cabin: ");
                            noOfPassengers ="3"; //input.next();

                            try {
                                passengers = Integer.parseInt(noOfPassengers);
                                //Maximum of 3 passengers are allowed in a cabin
                                if (passengers < 4 && passengers > 0) {
                                    getCabins()[cabinNum].setNoOfPassengers(passengers);//set number of passengers
                                } else {
                                    System.out.println("Please choose another cabin for the remaining Passengers!\n" +
                                            "3 passengers are added to this cabin.");
                                    getCabins()[cabinNum].setNoOfPassengers(3);//set number of passengers as 3
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter an Integer.");
                                System.out.print("Enter number of Passengers in the cabin: ");
                                noOfPassengers = input.next();
                            }
                            //Additional information of passenger Expenses
                            System.out.println("\nAdditional information of the Paying passenger.");
                            //System.out.print("Enter first name: ");
                            firstName = "";//input.next();
                            System.out.print("Enter first name: \n");
                            surName = input.next();
                            expenses = "0000 0000 0000 0000";//use credit card

                            while (true) {
                                if (expenses.length() != 16) {
                                    System.out.println("Expenses : <<<<<< User of  cash or creditcard for the payment >>>>>>\n");
                                    System.out.println("Expenses : - Use credit card -");
                                    System.out.print("Expenses : please enter the Credit card number : ");

                                    expenses = input.next();


                                } else {
                                    System.out.println("Invalid credit card number. Please re-enter the number.");
                                    break;
                                }
                            }
                            //Adding paying passenger to cabin
                            getCabins()[cabinNum].addPayingPassenger(firstName, surName, expenses);

                            System.out.println("Customer " + getCabins()[cabinNum].getPayingPassenger().getFirstName() + " " + getCabins()[cabinNum].getPayingPassenger().getSurName() + " was successfully added to cabin " + cabinNum + "\n");
                        } else {
                            System.out.println("Sorry! This cabin is already occupied. Please choose a different cabin.\n");
                        }
                    }
                    //if number is 12 stop adding customers
                    else if (cabinNum == 12) {
                        System.out.println("Enter 12 to Stop!!!!!!");
                        System.out.println("Stopped adding customers to cabin");
                        break;
                    }
                    //Entered an invalid cabin number
                    else {
                        System.out.println("\nInvalid cabin number!\n");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please enter an Integer.");
                }
            }
            else
            {
                //the customer in the waiting list

                System.out.println("\nSorry, cabins are full! You will be added to the waiting list\n");

                if(waitingList.isFull())
                {
                    System.out.println("Waiting list is full!");
                }
                else {
                    //Name for cabin
                    cabinName = "seafare"; //input.next();
                    cabinName = cabinName.substring(0, 1).toUpperCase(Locale.ROOT) + cabinName.substring(1);

                    //Input number of passenger
                    String noOfPassengers;
                    noOfPassengers ="3"; //input.next();

                    try {
                        passengers = Integer.parseInt(noOfPassengers);
                        //Maximum of 3 passengers are allowed in a cabin
                        if (passengers > 4 || passengers < 0) {
                            System.out.println(" Please choose another cabin for the remaining cabins!\n" + "3 passengers is added to this cabin.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter an Integer.");
                        System.out.print("Enter number of passengers in the cabin: ");
                        noOfPassengers = input.next();
                    }

                    //Additional information of paying passenger
                    System.out.println("\nAdditional information of the Paying passenger.");
                    //System.out.print("Enter first name: ");
                    firstName = "";//input.next();
                    System.out.print("Enter sur name: ");
                    surName = input.next();
                    expenses = "0000 0000 0000 0000";//use credit card
                    while (true) {
                        if (expenses.length() != 16) {
                            System.out.print("Expenses :<<<<< User of  cash or creditcard for the payment >>>>>");
                            System.out.println("Expenses : Please pay cash and get cabin number");
                            System.out.println("Expenses : - Use credit card - ");
                            System.out.print("Expenses : please re-enter the credit card number ");
                            expenses = input.next();

                        } else {
                            System.out.println("Invalid credit card number. Please re-enter the number.");
                            break;
                        }
                    }
                    Cabin cabin = waitingList.push();
                    Person payingPassenger = new Person(firstName, surName, expenses);

                    cabin.setCabinName(cabinName);
                    cabin.setNoOfPassengers(passengers);
                    cabin.setPayingPassenger(payingPassenger);

                    System.out.println("Customer " + payingPassenger.getFirstName() + " " + payingPassenger.getSurName() + " is added to the waiting list." + "\n");
                }
            }
        }
    }

    //Delete customers from cabins
    public void delete(int cabinNum) {
        Scanner input = new Scanner(System.in);
        char ans;


        if (isEmpty(cabinNum) == -1) {
            System.out.print("Are you sure you want to remove Customer " + getCabins()[cabinNum].getPayingPassenger().getFirstName() + " " + getCabins()[cabinNum].getPayingPassenger().getFirstName() + " from cabin" + cabinNum + "(y/n)?");
            ans = (char) (input.next().charAt(0) & 0x5f);//Convert inout to upper case

            //remove the customer if the request was confirmed or else cancel the requests
            if (ans == 'Y') {
                System.out.println(getCabins()[cabinNum].getPayingPassenger().getFirstName() + " " + getCabins()[cabinNum].getPayingPassenger().getFirstName() + "removed cabin " + cabinNum);
                getCabins()[cabinNum].setCabinName("e");
                getCabins()[cabinNum].setNoOfPassengers(0);
                getCabins()[cabinNum].deletePayingPassenger();

                if (!waitingList.isEmpty()){
                    //Executed to add next customer in the waiting list to cabin if present....

                    Cabin newCabin = waitingList.pop(); //get the first cabin object of the cabin....


                    getCabins()[cabinNum].setCabinName(newCabin.getCabinName());
                    getCabins()[cabinNum].setNoOfPassengers(newCabin.getNoOfPassengers());
                    getCabins()[cabinNum].setPayingPassenger(newCabin.getPayingPassenger());

                    System.out.println("Customer " + newCabin.getPayingPassenger().getFirstName()+ " " + newCabin.getPayingPassenger().getSurName() + "was added to cabin " + cabinNum);
                }

            } else {
                System.out.println("Request has been canceled! Customer " + getCabins()[cabinNum].getPayingPassenger().getFirstName() + " " + getCabins()[cabinNum].getPayingPassenger().getSurName() + " was not removed.");

            }
        } else {
            System.out.println("\nSorry! This cabin is already empty.\n");

        }
    }

    //Find customer from name
    public void find(String firstName, String surName) {
        for (int i = 0; i < getCabins().length; i++) {

            if (getCabins()[i].getPayingPassenger() != null) {
                if (getCabins()[i].getPayingPassenger().getFirstName().equalsIgnoreCase(firstName)
                        && getCabins()[i].getPayingPassenger().getSurName().equalsIgnoreCase(surName)
                ) {
                    System.out.println("Customer " + getCabins()[i].getPayingPassenger().getFirstName() + " " + getCabins()[i].getPayingPassenger().getSurName() + " is in cabin" + i);
                    break;
                }
                if (i == getCabins().length - 1) {
                    System.out.println("Sorry! Customer " + firstName + " " + surName + " was not found.");
                    break;
                }
            }
            if (i == getCabins().length - 1) {
                System.out.println("Sorry! Customer " + firstName + " " + surName + " was not found.");
            }
        }
    }

    //Store program data to file
    public void store() {
        //Writing data to file
        try {
            FileWriter writerObject = new FileWriter("data.txt");//Writer object

            //writing data to file
            for (int i = 0; i < getCabins().length; i++) {
                if (isEmpty(i) != -1) {

                    writerObject.write("cabin " + i + " is empty\n\n");
                } else {

                    writerObject.write("Cabin " + i + "\n");
                    writerObject.write("- cabin name : " + getCabins()[i].getCabinName() + "\n");//cabin name
                    writerObject.write("- Number of passengers : " + getCabins()[i].getNoOfPassengers() + "\n");
                    writerObject.write("<_______________________________________________>\n\n");
                    writerObject.write("Expences of Paying passengers\n");
                    writerObject.write("- First Name : " + getCabins()[i].getPayingPassenger().getFirstName() + "\n");
                    writerObject.write("- Last Name : " + getCabins()[i].getPayingPassenger().getSurName() + "\n");
                    writerObject.write("- Expenses for: " + getCabins()[i].getPayingPassenger().getExpenses() + "\n\n");
                }
            }
            writerObject.close();//close file
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred! Could not write to file.");
            e.printStackTrace();
        }
    }

    //Loading data from file
    public void load() {
        try {
            File fileObject = new File("data.txt");
            Scanner fileReader = new Scanner(fileObject);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //View guests ordered alphabetically by name.
    public void sortNames() {
        String temp;


        for (int j = 0; j < getCabins().length; j++) {
            for (int i = j + 1; i < getCabins().length; i++) {
                if (!(getCabins()[i].getCabinName().equals("e"))) {

                    if (getCabins()[i].getCabinName().compareTo(getCabins()[j].getCabinName()) < 0) {
                        temp = getCabins()[j].getCabinName();
                        getCabins()[j].setCabinName(getCabins()[i].getCabinName());
                        getCabins()[i].setCabinName(temp);
                    }
                }
            }
        }

        for (int i = 0; i < getCabins().length; i++) {
            if (!(getCabins()[i].getCabinName().equals("e"))) {
                System.out.println(getCabins()[i].getCabinName());
            }
        }
    }

    //Check if the Shipboardig is full
    public boolean isFull() {
        for (int i = 0; i < getCabins().length; i++) {
            if (getCabins()[i].getCabinName().equals("e")) {
                return false;
            }
        }
        return true;
    }
}
