import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLength = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) { // start of a sequence
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
