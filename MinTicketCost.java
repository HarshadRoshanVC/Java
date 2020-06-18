import java.util.*;

public class MinTicketCost
{
    public static int minCost(ArrayList<Integer> days,ArrayList<Integer>Costs){
        int[] dp=new int[366];
        int j=0;
        for(int i=days.get(0);i<366;i++){
            if(i==days.get(j)){
                dp[i]=dp[i-1]+Costs.get(0);
                if(i>=7){
                    dp[i]=Math.min(dp[i-7]+Costs.get(1),dp[i]);
                }else{
                    dp[i]=Math.min(dp[i],Costs.get(1));
                }
                if(i>=30){
                    dp[i]=Math.min(dp[i-30]+Costs.get(2),dp[i]);
                }else{
                    dp[i]=Math.min(dp[i],Costs.get(2));
                }
                j+=1;
                if(j==days.size()){
                    return dp[i];
                }
            }else{
                if(i>0){
                    dp[i]=dp[i-1];
                }
            }
        }
        return 0;  
    }
public static void main(String[] args) {
   String input;
   ArrayList <Integer> days=new ArrayList();
   ArrayList <Integer> TicketsCost=new ArrayList();
   Scanner sc=new Scanner(System.in);
input=sc.nextLine();
String[] list = input.split(" ", 0);
        for (String listItem : list){
            days.add(Integer. valueOf(listItem));
        }
        input=sc.nextLine();
list = input.split(" ", 0);
        for (String listItem : list){
            TicketsCost.add(Integer. valueOf(listItem));
        }
System.out.println(minCost(days,TicketsCost));
}
}
