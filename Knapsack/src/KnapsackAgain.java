public class KnapsackAgain {
    public int knapsack(int wt[],int val[],int W,int n){

        if(W==0||n==0)
            return 0;
        else if(wt[n-1]<=W){
            return Math.max(val[n-1]+knapsack(wt,val,W-wt[n-1],n-1),knapsack(wt,val,W,n-1));

        }
        else{
            return knapsack(wt,val,W,n-1);
        }

    }
}
