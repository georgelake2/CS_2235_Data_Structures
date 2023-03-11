package Chapter_5;

public class Recursion {
    private static int binarySearch(int[] data, int target) {
        return binarySearch (data, target, 0, data.length - 1);
    }

    private static int binarySearch(int[] data, int target, int low, int high) {
        int middle = (high + low) / 2;

        if (data[middle] == target) {
            return middle;
        } else if (target < data[middle]) {
            return binarySearch(data, target, low, middle - 1);
        } else {// (target > data[middle]) {
            return binarySearch(data, target, middle + 1, high);
        }
    }





    public static void main(String[] args) {
        int[] numbers = {2,4,5,7,8,9,12,14,17,19,22,25,27,28,33,37};

        System.out.println(binarySearch(numbers, 27));
    }
}
