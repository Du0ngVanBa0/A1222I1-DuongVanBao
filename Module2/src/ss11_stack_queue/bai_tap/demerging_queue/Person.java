package ss11_stack_queue.bai_tap.demerging_queue;

public class Person {
    private String id;
    private String name;
    private boolean isMale;

    public Person(String id, String name, boolean isMale) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
    }

    public boolean isMale() {
        return isMale;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isMale=" + isMale +
                '}';
    }
}
