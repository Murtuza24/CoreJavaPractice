package Day9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortingFiles {

    static List<File> filesList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Base Path: ");
        String path = scanner.nextLine();
        getFile(path);
    }

    public static void getFile(String path) {
//        System.out.println(path);
        File f = new File(path);
        File[] files;
        files = f.listFiles();
        for (File file : files) {
            System.out.println(file.getName());


            if (file.isDirectory()) {
                getFile(file.getAbsolutePath());
            } else {
//                String[] fname = file.getName().split("\\.");
//                String extension = fname[1];

                filesList.add(file);


            }

        }

        System.out.println(filesList);
        for (File file : filesList) {
            System.out.println(file.getName());
        }
    }
}
