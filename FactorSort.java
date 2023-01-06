import java.util.*;

public class FactorSort {
    Integer countFactors(Integer n){
        Integer count = 0;
        for(Integer i = 1 ; i * i <= n ; i++){
    		if(n % i == 0){
    			count++;
    			if(i * i != n){
    				count++;
    			}
    		}
    	}
        return count;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator< Integer >(){
            @Override
            public int compare(Integer val1, Integer val2) {
                Integer count1 = countFactors(val1);
                Integer count2 = countFactors(val2);
                if(count1 == count2){
                    return val1 - val2;
                }
                return count1 - count2;
            }    
        });
        return A;
    }
    public static void main(String args[]){
        FactorSort R=  new FactorSort();
        int A[]={-4, 7, 5,30};
        ArrayList<Integer> values = new ArrayList<>();
        // we require for loop to add array to ArrayList
        for (int id: A) {
            values.add(id);
        }
        System.out.println(R.solve(values));
        
    }
}