public class SubArraysSum {
    public int maxSubarray(int A, int B, int[] C) {
        int n=C.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        // maxium sum possible which is <=B of all the sub-array sums
        // Maximum sum of the sub-array possible using brute force method T(n)=Theta(n^2)
        for(int s=0;s<n;s++)
        {
            sum=0;
            for(int e=s;e<n;e++)
            {
                sum=sum+C[e];
                if(sum<=B)
                {
  
                    max=Math.max(sum,max);
                }
            
            }
        }

        return  max;
 
    }
    public static void main(String args[])
        {
            SubArraysSum S= new SubArraysSum();
             int [] A ={2, 1, 3, 4, 0};
             int R=S.maxSubarray(5,12,A);
             System.out.println(R);
        }
}