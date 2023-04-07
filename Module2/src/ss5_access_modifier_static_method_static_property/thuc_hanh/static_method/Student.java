package ss5_access_modifier_static_method_static_property.thuc_hanh.static_method;

public class Student {
    private int rollNo;
    private String name;
    private static String college = "BBDIT";

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    static void change() {
        college = "CodeGym";
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + college);
    }
}
