package models;

public class Order {
    public int id;
    public int petId;
    public int quantity;
    public String shipDate;
    public String status;
    public boolean complete;


    public Order() {

    }

    public Order(int id, int petId) {
        this.id = id;
        this.petId = petId;
    }

    public Order(int id, int petId, int quantity, String shipDate, String status , boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;

    }

    @Override
    public boolean equals(Object o) {
        // 1
        if (this == o) {
            return true;
        }
        // 2
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;
        if (this.status == null){
            return this.id == order.id &&
                    this.petId == order.petId;
        }

        return this.id == order.id &&
                this.petId == order.petId &&
                this.quantity == order.quantity &&
                this.status.equals(order.status);
    }

}
