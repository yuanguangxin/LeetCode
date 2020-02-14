package q10;

public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            char sc = s.charAt(i);
            if (j >= p.length()) {
                return false;
            }
            char pc = p.charAt(j);

            if (j + 1 < p.length()) {
                if (p.charAt(j + 1) == '*') {
                    if (pc == '.') {
                        j+=2;
                        break;
                    } else if (pc == sc) {
                        while (i < s.length() && s.charAt(i) == pc) {
                            i++;
                        }
                    }
                    j += 2;
                } else {
                    if ((sc == pc) || (pc == '.')) {
                        i++;
                        j++;
                    } else {
                        return false;
                    }
                }
            } else {
                if ((sc == pc) || (pc == '.')) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }

        while (j < p.length()) {
            if (p.charAt(j) == '*') {
                j++;
            } else {
                if (j + 1 < p.length() && p.charAt(j) == '*') {
                    j += 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aaa", "a*a"));
    }
}
