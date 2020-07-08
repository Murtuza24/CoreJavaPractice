package OOP;

public class MethodOverloading {
    public static void main(String[] args) {
        int res1 = Operations.multiply(4,8);
        System.out.println("Result:"+res1);

        float res2 = Operations.multiply(3.5f, 4.0f);
        System.out.println("Result:"+res2);
    }

    private static class Operations {
        public static int multiply(int a, int b) {
            return (a*b);
        }

        public static float multiply(float a, float b) {
            return (a*b);
        }

    }
}
