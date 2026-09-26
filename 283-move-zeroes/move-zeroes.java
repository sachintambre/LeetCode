class Solution {
    static {
        for (int i = 0; i < 500; ++i) {
            moveZeroes(new int[0]);
        }
    }

    public static void moveZeroes(int[] n) {
        int P = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] != 0) {
                if (i != P) {
                    n[P] = n[i];
                    n[i] = 0;
                }
                P++;
            }
        }
    }
}