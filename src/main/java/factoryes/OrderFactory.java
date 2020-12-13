package factoryes;
import models.*;
import org.apache.commons.lang3.RandomStringUtils;

public class OrderFactory {
    public Order createRandomOrder(int petId){
        int id = 1 + (int) (Math.random()*9999);
        int quantity = 1 + (int) (Math.random()*9999);
        String status = "placed";

        return new Order(id, petId, quantity, "2020-12-13T10:46:09.800Z" ,status, true);
    }

}
