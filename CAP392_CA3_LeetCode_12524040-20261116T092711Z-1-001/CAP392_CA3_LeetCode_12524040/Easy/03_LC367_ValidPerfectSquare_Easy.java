/*
 * LeetCode 367 - Valid Perfect Square (Easy)
 * Topic: Loops
 *
 * Approach: Binary search on [1, num] using a while loop; compare mid*mid with num.
 * long is used to avoid int overflow when squaring.
 * Time: O(log n)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 03_LC367_ValidPerfectSquare_Easy.java
 */
class Solution {

    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPerfectSquare(16)); // true
        System.out.println(s.isPerfectSquare(14)); // false
        System.out.println(s.isPerfectSquare(1));  // true
        System.out.println(s.isPerfectSquare(2147395600)); // true (46340^2)
    }
}
