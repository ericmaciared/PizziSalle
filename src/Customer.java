public class Customer {
    private String name;
    private String phone;
    private int age;
    private String address;
    private Boolean firstOrder;
    private String delegation;

    public Customer(String name, String phone, int age, String address, boolean firstOrder, String delegation) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.firstOrder = firstOrder;
        this.delegation = delegation;
    }

    public Boolean getFirstOrder() {
        return firstOrder;
    }

    public String getDelegation() {
        return delegation;
    }

    @Override
    public String toString() {
        return name + ", with phone number ("+ phone + "), at address: " + address;
    }

    public int getAge() {
        return this.age;
    }
}
