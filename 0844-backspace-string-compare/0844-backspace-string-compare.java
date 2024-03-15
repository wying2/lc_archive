class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sp = s.length()-1, tp = t.length()-1;
        int s_skip = 0, t_skip = 0;
        while (sp >= 0 || tp >= 0) {
            while (sp >= 0) {
                if (s.charAt(sp) == '#') {s_skip ++; sp --;}
                else if (s_skip > 0) {s_skip --; sp --;} 
                else break;
            }
            while (tp >= 0) {
                if (t.charAt(tp) == '#') {t_skip ++; tp --;}
                else if (t_skip > 0) {t_skip --; tp --;} 
                else break;
            }
            if (sp >= 0 && tp >= 0 && s.charAt(sp) != t.charAt(tp))
                return false;
            if ((sp >= 0) != (tp >= 0))
                return false;
            sp--; tp--;
        }
        return true;
    }
}