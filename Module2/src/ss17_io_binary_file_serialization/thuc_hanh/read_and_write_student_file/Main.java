package ss17_io_binary_file_serialization.thuc_hanh.read_and_write_student_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\ss17_io_binary_file_serialization\\thuc_hanh\\read_and_write_student_file\\student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\ss17_io_binary_file_serialization\\thuc_hanh\\read_and_write_student_file\\student.txt");
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("File không tìm thấy hoặc xảy ra lỗi!");
        }
        return students;
    }

    public static void writeToFile(String path, List<Student> studentList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Không tìm thấy file hoặc xảy ra lỗi");
        }
    }
}
