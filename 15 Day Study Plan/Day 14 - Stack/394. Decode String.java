/*
        394. Decode String
        Medium
        10.2K
        454
        Companies
        Given an encoded string, return its decoded string.

        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

        You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

        The test cases are generated so that the length of the output will never exceed 105.

        

        Example 1:

        Input: s = "3[a]2[bc]"
        Output: "aaabcbc"
        Example 2:

        Input: s = "3[a2[c]]"
        Output: "accaccacc"
        Example 3:

        Input: s = "2[abc]3[cd]ef"
        Output: "abcabccdcdcdef"
        

        Constraints:

        1 <= s.length <= 30
        s consists of lowercase English letters, digits, and square brackets '[]'.
        s is guaranteed to be a valid input.
        All the integers in s are in the range [1, 300].
        Accepted
        608.6K
        Submissions
        1.1M
        Acceptance Rate
        57.9%
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                resStack.push(res);
                num = 0;
                res = "";
            } else if (c == ']') {
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder(resStack.pop());
                for (int j = 0; j < repeat; j++) {
                    temp.append(res);
                }
                res = temp.toString();
            } else {
                res += c;
            }
        }
        return res;
    }
}
