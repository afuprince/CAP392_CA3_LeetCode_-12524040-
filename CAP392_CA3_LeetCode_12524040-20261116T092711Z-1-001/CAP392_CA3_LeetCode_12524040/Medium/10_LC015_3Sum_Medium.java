/*
 * LeetCode 15 - 3Sum (Medium)
 * Topic: Arrays, nested loops, conditional statements
 *
 * Approach: Sort the array. Fix the first number with an outer loop, then use two pointers
 * (left, right) in the remaining part to find pairs that make the sum zero.
 * Skip duplicate values to avoid repeated triplets.
 * Time: O(n^2)   Space: O(1) extra (excluding output)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 10_LC015_3Sum_Medium.java
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                break; // smallest number is positive, no triplet can sum to 0
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicate first elements
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(s.threeSum(new int[]{0, 1, 1}));             // []
        System.out.println(s.threeSum(new int[]{0, 0, 0}));             // [[0, 0, 0]]
    }
}
