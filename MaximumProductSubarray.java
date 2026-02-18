public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = maxProd;

            maxProd = Math.max(num, Math.max(maxProd * num, minProd * num));
            minProd = Math.min(num, Math.min(tempMax * num, minProd * num));

            result = Math.max(result, maxProd);
        }

        return result;
    }
}
