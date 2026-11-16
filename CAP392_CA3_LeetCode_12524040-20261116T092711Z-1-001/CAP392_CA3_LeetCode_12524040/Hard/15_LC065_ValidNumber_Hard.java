/*
 * LeetCode 65 - Valid Number (Hard)
 * Topic: String, Parsing
 *
 * A valid number is a decimal or integer, optionally followed by an exponent (e/E + integer).
 * Approach: Single left-to-right scan keeping three flags:
 *   seenDigit - a digit has appeared in the current part (before the exponent / after it)
 *   seenDot   - a '.' has appeared (not allowed twice, or inside the exponent)
 *   seenExp   - an 'e'/'E' has appeared (not allowed twice)
 * Rules:
 *   digit : mark seenDigit
 *   + or -: only at index 0, or immediately after e/E
 *   e / E : needs a digit before it and no earlier exponent; reset seenDigit so that a
 *           digit is required after it
 *   '.'   : not allowed after another '.' or after the exponent
 *   other : invalid
 * The string is valid only if a digit was seen in the final part.
 * Time: O(n)   Space: O(1)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 15_LC065_ValidNumber_Hard.java
 */
class Solution {

    public boolean isNumber(String s) {
        boolean seenDigit = false, seenDot = false, seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false; // need at least one digit after the exponent
            } else if (c == '.') {
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } else {
                return false;
            }
        }
        return seenDigit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] valid = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] invalid = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", ".", "+", "e", ""};

        for (String v : valid) {
            System.out.println("\"" + v + "\" -> " + s.isNumber(v) + " (expected true)");
        }
        for (String v : invalid) {
            System.out.println("\"" + v + "\" -> " + s.isNumber(v) + " (expected false)");
        }
    }
}
