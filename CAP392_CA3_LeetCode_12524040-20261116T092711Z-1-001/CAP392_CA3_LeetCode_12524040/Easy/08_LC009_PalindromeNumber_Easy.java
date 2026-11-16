/*
 * LeetCode 9 - Palindrome Number (Easy)
 * Topic: String
 *
 * The assignment table lists "9 - Valid Palindrome" (topic: String). Official LeetCode No. 9 is
 * "Palindrome Number"; "Valid Palindrome" is LeetCode 125. To stay on the assigned number (9)
 * and the assigned topic (String), this file contains:
 *   1) isPalindrome(int)      -> LeetCode 9 (solved using String conversion + two pointers)
 *   2) isValidPalindrome(String) -> LeetCode 125 "Valid Palindrome" (two pointers on a String)
 *
 * Time: O(n)   Space: O(n) for the String conversion in (1), O(1) for (2)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 08_LC009_PalindromeNumber_Easy.java
 */
class Solution {

    // LeetCode 9 - Palindrome Number
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // LeetCode 125 - Valid Palindrome
    public boolean isValidPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(121));  // true
        System.out.println(sol.isPalindrome(-121)); // false
        System.out.println(sol.isPalindrome(10));   // false

        System.out.println(sol.isValidPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isValidPalindrome("race a car")); // false
        System.out.println(sol.isValidPalindrome(" "));          // true
    }
}
