package Day3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveFiles {

    public static ArrayList<String> deletedFiles = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Base Path: ");
        String path = scanner.nextLine();

        scanner = new Scanner(System.in);
        System.out.println("Enter File Name / Similar Name:");
        String filename = scanner.nextLine();

        getFiles(path, filename);

        System.out.println("The following files are deleted: "+ deletedFiles.toString());
    }

    private static void getFiles(String path, String filename) {

        File f = new File(path);
        File[] files;
        files = f.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
            if (file.getName().toLowerCase().contains(filename)) {
                file.delete();
                deletedFiles.add(file.getName());
            }
            if (file.isDirectory()) {
                getFiles(file.getAbsolutePath(), filename);
            }

        }


    }
}
