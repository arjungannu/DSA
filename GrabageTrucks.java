//Minimum Amount of Time to Collect Garbage
/*You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at 
the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. 
Picking up one unit of any type of garbage takes 1 minute.You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
Return the minimum number of minutes needed to pick up all the garbage. */
//Link : https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/ 
public class GrabageTrucks {

        // Travelling time
    public int TravelTime(int index,int garbage, int[] travel)
        {
            int TT=0;
            if(index!=0)
                TT= travel[index-1];
            else TT=0;
            return garbage+TT;
        }
    public int garbageCollection(String[] garbage, int[] travel) {
        int TT=0;
        int sum=0;
        int paper=0;
        int glass=0;
        int metal=0;
        int n=garbage.length;
        int glass_last=0;
        int metal_last=0;
        int paper_last=0;
        // int last=0;
        // prefix sum for travelling
        for(int k=1;k<travel.length;k++)
            {
                travel[k]=travel[k]+travel[k-1];
            }
    
         for(int i=0;i<n;i++)
            {
                for(int j=0;j<garbage[i].length();j++)
                { 
                    
                    if(garbage[i].charAt(j)=='G')
                    {
                        glass_last=i;
                        glass++;
                    }      
                    
                    if(garbage[i].charAt(j)=='M')
                    {
                        metal_last=i;
                        metal++;
                    }

                    if(garbage[i].charAt(j)=='P')
                    {
                        paper_last=i;
                        paper++;
                    }
                        
                        
                }
            }
       
           return TravelTime(glass_last,glass,travel)+TravelTime(paper_last,paper,travel)+TravelTime(metal_last,metal,travel);
        }

                        //elegant solution
                class Solution {
                    public int garbageCollection(String[] garbage, int[] travel) {
                        int time = 0;
                        // total time to collec garbage
                        for (String g : garbage) {
                            time += g.length();
                        }
                        
                        //prefix sum of travel
                        int[] sumTravel = new int[travel.length + 1];
                        for (int i = 1; i < sumTravel.length; i++) {
                            sumTravel[i] = travel[i - 1] + sumTravel[i - 1];
                        }
                        
                        time += travelTime(garbage , sumTravel, 'M');
                        time += travelTime(garbage, sumTravel, 'P');
                        time += travelTime(garbage, sumTravel, 'G');
                        
                        return time;
                    }

                    //more elegant
                    class Solution {
                        public int garbageCollection(String[] garbage, int[] travel) {
                            int total = 0,foundM = 0, foundP = 0, foundG = 0;
                            for(int i = garbage.length - 1; i > 0; i--){
                                total += garbage[i].length();// garbage collection time 
                                // Time to travel 
                                if(foundM == 0 && garbage[i].contains("M")) foundM = 1;
                                if(foundP == 0 && garbage[i].contains("P")) foundP = 1;
                                if(foundG == 0 && garbage[i].contains("G")) foundG = 1;
                                total += travel[i - 1] * (foundM + foundP + foundG);
                            }
                            // total+garbage collection time for 0th house
                            return total + garbage[0].length();
                        }
                    }
                    
                    private int travelTime(String[] garbage, int[] sumTravel, char type) {

                        //travelling from backwards to find last house Garge type was picked up
                        for (int i = garbage.length - 1; i >= 0; i--) {
                            if (garbage[i].indexOf(type) != -1) {
                                return sumTravel[i];
                            }
                        }
                        
                        return 0;
                    }
                }
        public static void main(String args[]){
            GrabageTrucks R=  new GrabageTrucks();
            String[] G={"G","P","GP","GG"};
            int[] T={2,4,3};
            System.out.println(R.garbageCollection(G,T));
            
        }
}
