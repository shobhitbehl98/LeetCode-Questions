import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int h = time[i] % 60;
            if (!hm.containsKey(h)) {
                hm.put(h, 1);
            } else {
                hm.put(h, hm.get(h) + 1);
            }
            time[i] = h;
        }
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < time.length; i++) {
            if ((time[i] == 30 || time[i] == 0)&&!hs.contains(time[i])) {
                ans += (hm.get(time[i]) * (hm.get(time[i]) - 1)) / 2;
                hs.add(time[i]);
            } else if (hm.containsKey(60 - time[i]) && !hs.contains(time[i])) {
                System.out.println(hm.get(time[i]) + " " + hm.get(60 - time[i]));
                ans += hm.get(time[i]) * hm.get(60 - time[i]);
                System.out.println(ans);
                hs.add(time[i]);
                hs.add(60 - time[i]);
            }
        }

        return ans;
    }
}
// @lc code=end
