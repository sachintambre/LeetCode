class Solution {
    public boolean isSubsequence(String s, String t) {
        int start=0;
        int i=0;
        while(start<s.length() && i<t.length()){
            if(s.charAt(start)==t.charAt(i)) start++;
            i++;
        }
        return start==s.length();
    }
}