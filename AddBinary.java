public class AddBinary {
    public String addBinary(String a, String b) {
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (len1 >= 0 || len2 >= 0){
            int sum = carry;
            // converts the charcter to Unicodes and does the operation which results in int
            if (len1 >= 0) sum += a.charAt(len1) - '0';
            if (len2 >= 0) sum += b.charAt(len2) - '0';
            
            //remainder goes below
            sb.append(sum%2);
            // carry is forwarded
            carry = sum/2;
    
            len1--;
            len2--;
        
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString(); 
    }

    public static void main(String args[]){
        AddBinary R=  new AddBinary();
        System.out.println(R.addBinary("11","10"));
    }
}
