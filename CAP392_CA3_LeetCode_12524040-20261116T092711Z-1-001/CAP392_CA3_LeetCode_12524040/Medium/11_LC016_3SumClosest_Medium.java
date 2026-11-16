/*
 * LeetCode 16 - 3Sum Closest (Medium)
 * Topic: Arrays, loops, operators
 *
 * Approach: Sort the array. For each first element, use two pointers on the rest and track
 * the sum whose absolute difference from target is smallest. Return early on an exact match.
 * Time: O(n^2)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 11_LC016_3SumClosest_Medium.java
 */
import java.util.Arrays;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // 2
        System.out.println(s.threeSumClosest(new int[]{0, 0, 0}, 1));      // 0
    }
}
