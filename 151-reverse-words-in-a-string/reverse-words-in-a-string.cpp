class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        string wd;
        vector<string> wds;
        while(ss >> wd) {
            wds.push_back(wd);
        }
        reverse(wds.begin(), wds.end());
        string ans;
        for(int i=0; i<wds.size(); i++) {
            if(i > 0) ans += " ";
            ans += wds[i];
        }
        return ans;
    }
};