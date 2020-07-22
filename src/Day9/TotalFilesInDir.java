package Day9;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


public class TotalFilesInDir {

    static HashMap<String, Integer> filesCountMap = new HashMap<>();

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
                String[] fname = file.getName().split("\\.");
                String extension = fname[1];

                if (filesCountMap.containsKey(extension)) {
                    filesCountMap.put(extension, filesCountMap.get(extension) + 1);
                } else {
                    filesCountMap.put(extension, 1);
                }
            }

        }

        System.out.println(filesCountMap);
        for (String k : filesCountMap.keySet()) {
            System.out.println(filesCountMap.get(k) + " " + k + " files");
        }
    }
}
