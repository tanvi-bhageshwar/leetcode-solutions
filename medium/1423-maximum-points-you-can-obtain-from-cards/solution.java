class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n=cardPoints.length;
      
        int ans=0;
        int sum=0;
        int right=n-1;
        for(int i=0;i<k;i++){
          sum=sum+cardPoints[i];
}
ans=sum;

      for(int i=k-1;i>=0;i--){

        sum=sum-cardPoints[i];
        sum=sum+cardPoints[right];
        right--;
        ans=Math.max(ans,sum);
      }


        
        return ans;        
    }
}