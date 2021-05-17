package entities;

public class Seller {
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

    public void setId(int id) {
        this.id = id;
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

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", requisites='" + requisites + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}
