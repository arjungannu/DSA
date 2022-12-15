public class ChristmasTree {

        public int solve(int[] A, int[] B) {
            int n=A.length;
            int m=B.length;
            int min=Integer.MAX_VALUE;
            
            for(int j=1;j<n-1;j++)
            {
               int r=0,l=0;
               int lmin=Integer.MAX_VALUE, rmin=Integer.MAX_VALUE;
                for(int i=j-1;i>=0;i--)
                {
                    if(A[i]<A[j])
                    {
                        lmin=Math.min(lmin,B[i]);
                    }
                }
                 for(int k=j+1;k<n;k++)
                {
                    if(A[k]>A[j])
                    {
                        rmin=Math.min(rmin,B[k]);
                    }
                }
                 //To capture overflow, on addition
                min =(rmin==Integer.MAX_VALUE || lmin==Integer.MAX_VALUE) ? min :  Math.min(min,rmin+lmin+B[j]);
            }
             // to capture edge case if no such case where A[i]<A[j]<A[k] exists
            return min==Integer.MAX_VALUE?-1:min;
        }
        public static void main(String args[]){
            ChristmasTree R=  new ChristmasTree();
            int [] A={ 100,101,100};
            int [] B={100,101,100};
            int a=R.solve(A,B);
        }
    
}
