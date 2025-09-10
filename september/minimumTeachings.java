//day31
import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length; // number of users
        // Convert to sets for easy checking
        List<Set<Integer>> langSets = new ArrayList<>();
        for (int[] lang : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : lang) set.add(l);
            langSets.add(set);
        }
        
        // Find problematic friendships
        Set<Integer> problemUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1; // zero-based
            Set<Integer> setU = langSets.get(u);
            Set<Integer> setV = langSets.get(v);
            
            boolean canCommunicate = false;
            for (int l : setU) {
                if (setV.contains(l)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                problemUsers.add(u);
                problemUsers.add(v);
            }
        }
        
        // If no problematic friendships → no teaching needed
        if (problemUsers.isEmpty()) return 0;
        
        int minTeach = Integer.MAX_VALUE;
        
        // Try each language
        for (int lang = 1; lang <= n; lang++) {
            int alreadyKnow = 0;
            for (int user : problemUsers) {
                if (langSets.get(user).contains(lang)) {
                    alreadyKnow++;
                }
            }
            int needTeach = problemUsers.size() - alreadyKnow;
            minTeach = Math.min(minTeach, needTeach);
        }
        
        return minTeach;
    }
}
