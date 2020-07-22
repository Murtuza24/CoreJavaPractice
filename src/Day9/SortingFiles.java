package Day9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            System.out.println(file.length() / (1024 * 1024));
        }

        System.out.println("------Sorted By File Name Ascending Order-------");
        filesList = filesList.stream().sorted((f1, f2) -> (f1.getName()).compareTo(f2.getName()))
                .collect(Collectors.toList());
        filesList.forEach(file -> System.out.println(file.getName()));

        System.out.println("------Sorted By File Name Descending Order-------");
        filesList = filesList.stream().sorted((f1, f2) -> (f2.getName()).compareTo(f1.getName()))
                .collect(Collectors.toList());
        filesList.forEach(file -> System.out.println(file.getName()));


        System.out.println("------Sorted By File Type Ascending Order-------");
        filesList = filesList.stream().sorted((f1, f2) -> (f1.getName().split("\\.")[1]).compareTo(f2.getName().split("\\.")[1]))
                .collect(Collectors.toList());
        filesList.forEach(file -> System.out.println(file.getName()));

        System.out.println("------Sorted By File Type Descending Order-------");
        filesList = filesList.stream().sorted((f1, f2) -> (f2.getName().split("\\.")[1]).compareTo(f1.getName().split("\\.")[1]))
                .collect(Collectors.toList());
        filesList.forEach(file -> System.out.println(file.getName()));

    }
}
