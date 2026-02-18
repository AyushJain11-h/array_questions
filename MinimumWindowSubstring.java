import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int required = targetCount.size();
        int formed = 0;

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && windowCount.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }

            // Shrink window
            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                windowCount.put(c, windowCount.get(c) - 1);
                if (targetCount.containsKey(c) && windowCount.get(c) < targetCount.get(c)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}

