package Contact;

public class Person{
    private String firstName;
    private String lastName;
    private  String phoneNumber;
    private String address;
    public Person(String firstName, String lastName, String number, String address){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.phoneNumber=number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return lastName+", "+firstName;
    }
}
