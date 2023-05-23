package ss17_io_binary_file_serialization.bai_tap.copy_file_binary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class copyFileBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.print("Enter destination file:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            // copyFileUsingStream(sourceFile, destFile);
            System.out.print("Copy completed");
        } catch (IOException ioe) {
            System.out.print("Can't copy that file");
            System.out.print(ioe.getMessage());
        }
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}