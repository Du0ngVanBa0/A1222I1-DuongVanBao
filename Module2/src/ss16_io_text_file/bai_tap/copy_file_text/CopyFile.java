package ss16_io_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void copyFileText(String fromPath, String toPath) {
        try {
            File fromFile = new File(fromPath);
            File toFile = new File(toPath);
            if (!fromFile.exists() || !toFile.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(fromPath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(toPath));
            String line = "";
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Copy file thành công");
        } catch (IOException e) {
            System.out.println("File không tồn tại hoặc xảy ra lỗi!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file cần copy: ");
        String fromPath = sc.nextLine();
        System.out.print("Nhập đường dẫn file đích cần dán: ");
        String toPath = sc.nextLine();
        copyFileText(fromPath,toPath);
    }
}
