package models;

public class Pet {
    public int id;
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

    public Pet(int id, String name, String[] photoUrls, Tag[] tags, status pet_status ) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.pet_status = pet_status;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public String getPet_status() {
        return String.valueOf(pet_status);
    }

    public void setPet_status(status pet_status) {
        this.pet_status = pet_status;
    }

    @Override
    public boolean equals(Object o){
        // 1
        if (this == o) {
            return true;
        }
        // 2
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        // 3
        Pet pet = (Pet) o;
        return this.id == pet.id &&
                this.name.equals(pet.name);
    }

}
