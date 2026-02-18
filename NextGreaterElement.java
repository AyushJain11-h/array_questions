import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {4,5,2,25};
        System.out.println(Arrays.toString(nextGreater(nums)));
    }

    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }
}

