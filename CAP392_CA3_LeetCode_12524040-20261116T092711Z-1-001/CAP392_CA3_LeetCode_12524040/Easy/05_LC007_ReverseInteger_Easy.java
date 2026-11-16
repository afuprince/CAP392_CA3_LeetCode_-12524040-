/*
 * LeetCode 7 - Reverse Integer (Easy)
 * Topic: While loop
 *
 * Approach: Pop the last digit with % 10 and push it onto the result, checking for
 * 32-bit overflow before each push. Return 0 if the reversed value overflows.
 * Time: O(log x)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 05_LC007_ReverseInteger_Easy.java
 */
class Solution {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            result = result * 10 + digit;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123));  // 321
        System.out.println(s.reverse(-123)); // -321
        System.out.println(s.reverse(120));  // 21
        System.out.println(s.reverse(1534236469)); // 0 (overflow)
    }
}
