package algorithms;

public class ArraySearchObject {
    public static void main(String[] args) {
        int n = 8; //value of numbers in array
        int arr[] = {1, 4, 5, 3, 7, 8, 6};

        int sumOfNumbers = sumOfNumbers(n);
        int sumOfElements = sumOfElements(arr);
        int missingNumber = sumOfNumbers - sumOfElements;

        System.out.println("Missing number is: " + missingNumber);
    }

    //Method to calculate sum of 'n' numbers
    static int sumOfNumbers(int n) {
        int sum = (n * (n + 1)) / 2;
        return sum;
    }

    //Method to calculate sum of all elements of array (actually)
    static int sumOfElements(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
