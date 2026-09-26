class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int l=Integer.MIN_VALUE;
        int n=candies.length;
        List<Boolean> b=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(candies[i]>l){
                l=candies[i];
            }
        }
        for(int i=0;i<n;i++){
            if((candies[i]+extraCandies)>=l){
                b.add(true);
            }
            else{
                b.add(false);
            }
        }
        return b;
    }
}