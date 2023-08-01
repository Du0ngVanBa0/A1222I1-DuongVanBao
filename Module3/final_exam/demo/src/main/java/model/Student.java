package model;

public class Student {
    private int id;
    private String name;
    private String s_class;

    public Student(int id, String name, String s_class) {
        this.id = id;
        this.name = name;
        this.s_class = s_class;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }
}
