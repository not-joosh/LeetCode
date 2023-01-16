/*
        409. Longest Palindrome
        Easy
        4.2K
        253
        Companies
        Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

        Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

        

        Example 1:

        Input: s = "abccccdd"
        Output: 7
        Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
        Example 2:

        Input: s = "a"
        Output: 1
        Explanation: The longest palindrome that can be built is "a", whose length is 1.
        

        Constraints:

        1 <= s.length <= 2000
        s consists of lowercase and/or uppercase English letters only.
        Accepted
        450.4K
        Submissions
        826.5K
        Acceptance Rate
        54.5%
*/
class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        int ans = 0;
        boolean hasOdd = false;
        for (int cnt : freq) {
            if (cnt % 2 == 0) {
                ans += cnt;
            } else {
                ans += cnt - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            ans++;
        }
        return ans;
    }
}
