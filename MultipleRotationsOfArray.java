import java.util.Arrays;


public class MultipleRotationsOfArray {
        public int[][] solve(int[] A, int[] B) 
        {
            
            int n=A.length;
            int m=B.length;
            int res[][]=new int[m][];
            for(int i=0;i<m;i++)
            {
                //converting all the elements in B to be in the range of 0 & n-1;
                int R=B[i]%n;
                int arr[]=Arrays.copyOf(A, 5);
                if(R==0) 
                {
                    res[i]=arr;
                }
                else
                {
                    //Right Rotation...
                    arr=reverse(arr,0,n-1);
                    arr=reverse(arr,0,R-1);
                    arr=reverse(arr,R,n-1);
                    //for left rotation add the below and remove from above
                    //arr=reverse(arr,0,n-1);
                    res[i]=arr;
                }
            }
            return res;
    
        }
        //reveresing the array
        public int[] reverse(int[]C,int start, int end)
        {
            
            int i=start;
            int j=end;
              //swapping the elements
            while(i<j)
            {
                int temp=C[i];
                C[i]=C[j];
                C[j]=temp;
                i++;
                j--;
            }
            return C;
        }
        public static void main(String args[]){
            MultipleRotationsOfArray R=  new MultipleRotationsOfArray();
            int [] A={1,2,3,4,5};
            int [] B={2,3};
            R.solve(A,B);
        }
    
    
}
/*
 * 
 Simplest way for rotating array using index manipulation
 public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList< ArrayList<Integer> > ans = new ArrayList<>();
        int n = a.size();
        for(int x : b) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++)  temp.add(a.get( (i+x) % n ));// handling overflow (for left rotation add,for right rotation substract)
            ans.add(temp);
        }
        return ans;
    }
}
 */
