public class Person {
    //Information of the paying passenger
    private String firstName;
    private String surName;
    private String expenses;

    public Person(String firstName, String surName, String expenses){
        this.firstName = firstName;
        this.surName = surName;
        this.expenses = expenses;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getExpenses() {
        return expenses;
    }


    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setExpenses(String cexpenses) {
        this.expenses = expenses;
    }


}