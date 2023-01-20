public class Customer {
    private String name;
    private String phone;
    private String address;
    private Boolean firstOrder;
    private PizziSalle delegation;

    public Customer() {
    }

    public Customer(String name, String phone, String address, boolean firstOrder) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.firstOrder = firstOrder;

    }
}
