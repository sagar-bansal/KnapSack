import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [][] dp=new int[4][51];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        //System.out.println(new KnapsackMemoized().knapsack(new int[]{1, 2, 3},new int[]{60, 100, 120},5,3,dp));
        System.out.println("KnapSack "+new KnapsackTopDown().knapsack(new int[]{1, 2, 3},new int[]{60, 100, 120},5,3));

        System.out.println("Subset Sum possible? "+new SubsetSum().subsetSum(new int[]{2,3,7,8,10},5,115));

        System.out.println("Equal Sum Partition possible? "+new EqualSumPartition().equalSum(new int[]{5,10}));



    }

    //Remember here n is the size of array , so it represents the number of elements we can take
    public static int knapsack(int wt[],int v[],int W,int n){
        if(n==0 || W==0 )
            return 0;
        else if(wt[n-1]<=W){
            //Math.max(select,not select)
            return Math.max(v[n-1]+knapsack(wt,v,W-wt[n-1],n-1),knapsack(wt,v,W,n-1));
        }
        else
            return knapsack(wt,v,W,n-1);
    }


}


