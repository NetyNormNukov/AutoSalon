package entities;

public class Customer {
    private int id;
    private String name;
    private String requisites;
    private String address;
    private String phoneNumber;
    private String email;
    private String bankAccount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequisites() {
        return requisites;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bancAccount) {
        this.bankAccount = bancAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", requisites='" + requisites + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}