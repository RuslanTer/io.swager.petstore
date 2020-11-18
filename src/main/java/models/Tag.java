package models;

public class Tag {
    public int id;
    public String name;



    public Tag() {

    }

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
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

        Tag tag = (Tag) o;
        return this.id == tag.id &&
                this.name.equals(tag.name);
    }
}
