import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Shrink window if duplicate found
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
