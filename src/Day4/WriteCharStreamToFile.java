package Day4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCharStreamToFile {

    public static void main(String[] args) {

        writeUsingBufferedWriter();
        writeUsingCharStream();
    }

    private static void writeUsingCharStream() {
        String str = "This is content of file2.";

        char[] chars = str.toCharArray();

        for (char c: chars){
            System.out.println(c);
        }

    }

    private static void writeUsingBufferedWriter() {
        String s1 = "This is content of file 1";
        int nlines = 100;

        File file = new File("M:\\UT ARLINGTON\\springdemo\\CoreJava\\src\\Day4\\file1.txt");
        FileWriter fr = null;
        BufferedWriter bwr = null;
        try {
            fr = new FileWriter(file);
            bwr = new BufferedWriter(fr);
            for (int i = 0; i<nlines; i++){
                bwr.write(s1+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bwr.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
