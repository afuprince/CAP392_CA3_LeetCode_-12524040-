/*
 * LeetCode 41 - First Missing Positive (Hard)
 * Topic: Array manipulation
 *
 * Approach (cyclic sort, O(1) extra space): The answer is always in [1, n + 1].
 * Place every value v with 1 <= v <= n at index v - 1 by swapping. After that, the first
 * index i where nums[i] != i + 1 gives the answer i + 1; if all positions match, answer is n + 1.
 * Time: O(n) (each swap puts one value in its final place)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 16_LC041_FirstMissingPositive_Hard.java
 */
import java.util.Arrays;

class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int target = nums[i] - 1;
                int temp = nums[target];
                nums[target] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{1, 2, 0}));        // 3
        System.out.println(s.firstMissingPositive(new int[]{3, 4, -1, 1}));    // 2
        System.out.println(s.firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // 1
        System.out.println(s.firstMissingPositive(new int[]{1, 1}));           // 2
    }
}
