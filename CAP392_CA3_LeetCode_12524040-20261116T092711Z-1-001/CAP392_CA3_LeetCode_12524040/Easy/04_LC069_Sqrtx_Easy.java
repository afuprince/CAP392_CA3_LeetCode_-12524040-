/*
 * LeetCode 69 - Sqrt(x) (Easy)
 * Topic: Loops, operators
 *
 * Approach: Binary search for the largest integer r such that r*r <= x.
 * long is used to avoid overflow.
 * Time: O(log x)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 04_LC069_Sqrtx_Easy.java
 */
class Solution {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long left = 1, right = x / 2, ans = 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(4));  // 2
        System.out.println(s.mySqrt(8));  // 2
        System.out.println(s.mySqrt(0));  // 0
        System.out.println(s.mySqrt(2147395599)); // 46339
    }
}
