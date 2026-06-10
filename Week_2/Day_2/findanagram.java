import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        int[] map = new int[26];

        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }

        map[s.charAt(p.length() - 1) - 'a']++;

        int left = 0;

        for (int i = p.length() - 1; i < s.length(); i++) {
            map[s.charAt(i) - 'a']--;

            boolean allZero = true;
            for (int val : map) {
                if (val != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                ans.add(left);
            }

            map[s.charAt(left) - 'a']++;
            left++;
        }

        return ans;
    }
}