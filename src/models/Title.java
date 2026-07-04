package models;

public class Title {
    private int title_id;
    private String title_name;
    private String description;

    public Title(int title_id, String title_name) {
        this.title_id = title_id;
        this.title_name = title_name;
    }

    // getters + setters

    public int getTitle_id() {
        return title_id;
    }
    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    public String getTitle_name() {
        return title_name;
    }
    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + title_id +
                ", name='" + title_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
