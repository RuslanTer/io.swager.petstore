package models;

public class Category {
    public int id;
    public String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {

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

        Category category = (Category) o;
        return this.id == category.id &&
                this.name.equals(category.name);
    }
}
