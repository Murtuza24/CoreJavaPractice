package Day9;

import java.io.File;
import java.io.FilenameFilter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class QueuingImages {

    static Queue<File> imagesQueue = new PriorityQueue<File>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Base Path: ");
        String path = scanner.nextLine();
        getImages(path);
    }

    private static void getImages(String path) {

        File f = new File(path);
        File[] files;
        files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().contains(".jpg");
            }
        });

        if (files != null) {
            for (File file : files) {
                // converting file size to MB.
                double fSize = (double) file.length() / (1024 * 1024);
                if (fSize > 1) {
                    imagesQueue.add(file);
                }
            }
        } else {
            System.out.println("No Jpeg Files.");
        }
        imagesQueue.forEach(image -> System.out.println(image.getName()));
    }
}
