package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Pet {
    public int id;
    public Category category;
    public String name;
    public String[] photoUrls;
    public Tag[] tags;
    @JsonProperty("status")
    public status pet_status;
    public enum status {
        @JsonProperty("available")
        available,
        @JsonProperty("pending")
        pending,
        @JsonProperty("sold")
        sold
    }

    public Pet( ) {

    }

    public Pet(int id, String name ) {
        this.id = id;
        this.name = name;
    }

    public Pet(int id, String name, String[] photoUrls, Tag[] tags, status pet_status, Category category ) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.pet_status = pet_status;
        this.category = category;
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

    public void setPet_status(String pet_status) {
        if (!pet_status.equals("null")){
            this.pet_status = status.valueOf(pet_status);
        }

    }

    @JsonCreator
    public void statusFromString(@JsonProperty("status") String string) {
        if (!string.equals("null")) {
            this.pet_status = status.valueOf(string);
        }
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

        Pet pet = (Pet) o;

        if (this.pet_status == null){
            return this.id == pet.id &&
                    this.name.equals(pet.name);
        }
        return this.id == pet.id &&
                this.name.equals(pet.name) &&
                this.pet_status.equals(pet.pet_status) &&
                this.category.equals(pet.category) &&
                Arrays.equals(this.tags, pet.tags) &&
                Arrays.equals(this.photoUrls, pet.photoUrls);
    }

}
