import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return level;

                for (String neighbor : getNeighbors(word, wordSet)) {
                    queue.offer(neighbor);
                    wordSet.remove(neighbor);
                }
            }
            level++;
        }

        return 0;
    }

    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }

            chars[i] = original;
        }

        return neighbors;
    }
}

