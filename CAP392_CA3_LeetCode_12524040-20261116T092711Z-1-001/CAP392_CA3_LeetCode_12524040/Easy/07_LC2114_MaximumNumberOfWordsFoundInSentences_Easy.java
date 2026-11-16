/*
 * LeetCode 2114 - Maximum Number of Words Found in Sentences (Easy)
 * Topic: Strings
 *
 * Approach: Words are separated by single spaces, so words = (number of spaces) + 1.
 * Scan each sentence once, count spaces, and keep the maximum.
 * Time: O(total characters)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 07_LC2114_MaximumNumberOfWordsFoundInSentences_Easy.java
 */
class Solution {

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int words = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    words++;
                }
            }
            max = Math.max(max, words);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mostWordsFound(new String[]{
                "alice and bob love leetcode", "i think so too", "this is great thanks very much"})); // 6
        System.out.println(s.mostWordsFound(new String[]{
                "please wait", "continue to fight", "continue to win"})); // 3
    }
}
