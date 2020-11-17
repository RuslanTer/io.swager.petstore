package models;

public class Pet {
    public long id;
    public Category category;
    public String name;
    public String[] photoUrls;
    public Tag[] tags;
    public status pet_status;
    public enum status {
        available,
        pending,
        sold
    }

    public Pet( ) {

    }

    public Pet(int id, String name ) {
        this.id = id;
        this.name = name;
    }


}
