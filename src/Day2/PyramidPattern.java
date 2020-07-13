package Day2;

public class PyramidPattern {

    public static void main(String[] args) {
        int rows = 7;

        for (int i = 0; i <= rows; i++) {
            int k = 1;
            StringBuilder str = new StringBuilder();

            for(int space = 1; space <= rows - i; space++) {
                System.out.print("  ");
            }

            while (k <= 2 * i + 1) {
                k++;
                str.append("* ");
            }
            System.out.println(str);
            System.out.println();
        }


    }
}
