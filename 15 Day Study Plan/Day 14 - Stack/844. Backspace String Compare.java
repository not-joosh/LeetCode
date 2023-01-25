/*
        844. Backspace String Compare
        Easy
        6K
        276
        Companies
        Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

        Note that after backspacing an empty text, the text will continue empty.

        

        Example 1:

        Input: s = "ab#c", t = "ad#c"
        Output: true
        Explanation: Both s and t become "ac".
        Example 2:

        Input: s = "ab##", t = "c#d#"
        Output: true
        Explanation: Both s and t become "".
        Example 3:

        Input: s = "a#c", t = "b"
        Output: false
        Explanation: s becomes "c" while t becomes "b".
        

        Constraints:

        1 <= s.length, t.length <= 200
        s and t only contain lowercase letters and '#' characters.
        

        Follow up: Can you solve it in O(n) time and O(1) space?

        Accepted
        594.8K
        Submissions
        1.2M
        Acceptance Rate
        48.0%
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            int cntS = 0, cntT = 0;
            while (i >= 0 && (s.charAt(i) == '#' || cntS > 0)) {
                if (s.charAt(i) == '#') {
                    cntS++;
                } else {
                    cntS--;
                }
                i--;
            }
            while (j >= 0 && (t.charAt(j) == '#' || cntT > 0)) {
                if (t.charAt(j) == '#') {
                    cntT++;
                } else {
                    cntT--;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--; j--;
        }
        return true;
    }
}
