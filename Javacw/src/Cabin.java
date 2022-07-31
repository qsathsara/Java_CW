public class Cabin {
    private final int cabinNum;
    private String cabinName;
    private int noOfPassengers;
    private Person payingPassenger;

    public Cabin(int cabinNum, String cabinName){
        this.cabinNum = cabinNum;
        this.cabinName = cabinName;
        this.noOfPassengers = 3;
        this.payingPassenger = null;
    }

    //Getters
    public int getcabinNum() {
        return cabinNum;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public Person getPayingPassenger() {
        return payingPassenger;
    }

    public String getCabinName(){
        return cabinName;
    }

    //Setters
    public void setCabinName(String cabinName){
        this.cabinName = cabinName;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public void addPayingPassenger(String firstName, String surName, String expenses){
        this.payingPassenger = new Person(firstName, surName, expenses);
    }

    public void setPayingPassenger(Person payingPassenger) {
        this.payingPassenger = payingPassenger;
    }

    public void deletePayingPassenger(){
        this.payingPassenger = null;
    }
}

