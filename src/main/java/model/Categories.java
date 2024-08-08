package model;

public class Categories {
    int Id;
    String name;
    String description;

    public Categories(int id, String name, String description) {
        Id = id;
        this.name = name;
        this.description = description;
    }

    public Categories() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Categories(int id) {
        Id = id;
    }
}
