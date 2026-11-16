/*
 * LeetCode 1342 - Number of Steps to Reduce a Number to Zero (Easy)
 * Topic: While loop
 *
 * Approach: While num > 0, halve it if even, otherwise subtract 1. Count each step.
 * Time: O(log n)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 01_LC1342_NumberOfStepsToReduceNumberToZero_Easy.java
 */
class Solution {

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfSteps(14)); // 6
        System.out.println(s.numberOfSteps(8));  // 4
        System.out.println(s.numberOfSteps(123)); // 12
        System.out.println(s.numberOfSteps(0));  // 0
    }
}
