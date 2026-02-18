public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest element does not exist");
        } else {
            System.out.println("Second largest element is: " + secondLargest);
        }
    }
}
