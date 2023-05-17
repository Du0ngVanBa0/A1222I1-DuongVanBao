package ss16_io_text_file.bai_tap.read_file_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static void readFile(String filePath) {
        List<String> result;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(readLineCsv(line));
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi hoặc file không tồn tại!");
        }
    }

    public static List<String> readLineCsv(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] resultArr = csvLine.split(",");
            Collections.addAll(result, resultArr);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn cần đọc file .csv: ");
        String path = sc.nextLine();
        readFile(path);
    }
}
