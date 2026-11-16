/*
 * LeetCode 1295 - Find Numbers with Even Number of Digits (Easy)
 * Topic: Arrays, loops
 *
 * Approach: For each element, count its digits with a while loop and check if the count is even.
 * Time: O(n * d) where d = digits per number   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 06_LC1295_FindNumbersWithEvenNumberOfDigits_Easy.java
 */
class Solution {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            int digits = 0;
            while (n > 0) {
                digits++;
                n /= 10;
            }
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNumbers(new int[]{12, 345, 2, 6, 7896})); // 2
        System.out.println(s.findNumbers(new int[]{555, 901, 482, 1771})); // 1
    }
}
