package Day4;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ListFilesFoldersInDir {
    public static ArrayList<String> allFilNames = new ArrayList<>();

    public static void main(String[] args) {
//        String path = "M:\\UT ARLINGTON\\springdemo\\CoreJava\\src";
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
                allFilNames.add(file.getName());
                getFile(file.getAbsolutePath());
            }

        }

    }


}
