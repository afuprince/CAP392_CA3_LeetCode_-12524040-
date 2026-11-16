/*
 * LeetCode 217 - Contains Duplicate (Easy)
 * Topic: ArrayList
 *
 * Approach: Walk through nums and keep the values seen so far in an ArrayList.
 * If a value is already in the list, a duplicate exists.
 * (ArrayList.contains is O(n), so this is O(n^2); a HashSet version is included as the
 * optimized O(n) alternative.)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 09_LC217_ContainsDuplicate_Easy.java
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    // ArrayList-based approach: O(n^2) time, O(n) space
    public boolean containsDuplicate(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        for (int n : nums) {
            if (seen.contains(n)) {
                return true;
            }
            seen.add(n);
        }
        return false;
    }

    // Optimized approach: O(n) time, O(n) space
    public boolean containsDuplicateFast(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 1}));  // true
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 4}));  // false
        System.out.println(s.containsDuplicateFast(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); // true
    }
}
