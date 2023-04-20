package ss11_stack_queue.bai_tap.demerging_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("123", "Duong Van Bao", true),
                new Person("124", "Duong Thi Bao", false),
                new Person("125", "Duong Van Baoo", true),
                new Person("126", "Duong Thi Baoo", false),
                new Person("127", "Duong Thi Baooo", false),
        };

        Queue<Person> NU = new LinkedList<>();
        Queue<Person> NAM = new LinkedList<>();

        for (Person per : persons) {
            if (per.isMale()) {
                NAM.add(per);
            } else {
                NU.add(per);
            }
        }

        Person[] newPersons = new Person[persons.length];
        int index = 0;
        while (!NU.isEmpty()) {
            newPersons[index] = NU.poll();
            index++;
        }
        while (!NAM.isEmpty()) {
            newPersons[index] = NAM.poll();
            index++;
        }

        for (Person per : newPersons) {
            System.out.println(per);
        }
    }
}
