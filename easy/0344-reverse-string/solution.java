class Solution {
    public void reverseString(char[] s) {
        
        int n=s.length;

         int i=0;
         int j=n-1;

         while(i<n/2){

            swap(i,j,s);
            i++;
            j--;
         }
         }

         public static void swap(int i,int j, char[] s){

            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
         }
    
}