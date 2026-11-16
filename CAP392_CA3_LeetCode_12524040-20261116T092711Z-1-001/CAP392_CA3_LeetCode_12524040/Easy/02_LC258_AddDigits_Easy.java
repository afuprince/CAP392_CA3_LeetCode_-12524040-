/*
 * LeetCode 258 - Add Digits (Easy)
 * Topic: Operators, loops
 *
 * Approach: Repeatedly replace num with the sum of its digits until it has a single digit.
 * Digit extraction uses the % and / operators.
 * Time: O(log n)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 02_LC258_AddDigits_Easy.java
 */
class Solution {

    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addDigits(38)); // 2
        System.out.println(s.addDigits(0));  // 0
        System.out.println(s.addDigits(999)); // 9
    }
}
