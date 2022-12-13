public class SubArraysSum {
    public int maxSubarray(int A, int B, int[] C) {
        int n=C.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        int flag=0;
        // Maximum sum of the sub-array possible using brute force method T(n)=Theta(n^2)
        for(int s=0;s<n;s++)
        {
            sum=0;
            for(int e=s;e<n;e++)
            {
                sum=sum+C[e];
                if(sum<=B)
                {
                    flag=1;
                    max=Math.max(sum,max);
                }
                else break;
            }
        }
        return  flag==0?0:max;
 
    }
    public static void main(String args[])
        {
            SubArraysSum S= new SubArraysSum();
             int [] A ={2, 1, 3, 4, 5};
             int R=S.maxSubarray(5,12,A);
             System.out.println(R);
        }
}