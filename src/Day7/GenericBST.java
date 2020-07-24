package Day7;

public class GenericBST {
    public static void main(String[] args) {

        Integer[] intArray = {
                1, 4, 6, 7, 8, 9, 10, 18, 26, 56
        };

        System.out.println("Final pos:"+genericBST(intArray, 6, 0, 9));

    }

    public static <T extends Comparable<T>> int genericBST(T[] arr, T value, int low, int high) {
        if (low < high) {
            int mid = (low+ high)/2;
            int compVal = arr[mid].compareTo(value);
            System.out.println(compVal);

            if (compVal < 0) {
                return genericBST(arr, value, low, mid - 1);
            }
            if (compVal > 0) {
                return genericBST(arr, value, mid + 1, high);
            }
            return mid;
        }

        return -1;
    }

}
