import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;

        // Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        // Fill remaining positions with zeros
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
