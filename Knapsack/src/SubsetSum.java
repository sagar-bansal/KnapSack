//return if there is a subset that has a particular sum

public class SubsetSum {
    public boolean subsetSum(int arr[],int n,int sum){
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
            dp[i][0]=true;    // be careful in initialization
        for(int j=0;j<sum+1;j++){
            dp[0][j]=false;
        }
        //implementing choice
        for(int i=1;i<n+1;i++) {
            for (int j = 1; j < sum + 1; j++) {
                //if sum is larger than current element
                if (arr[i - 1] <= j) //be careful here
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];//be careful here
                    //if sum is smaller than current
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

//        for(int i=0;i<n+1;i++)
//        {
//        for(int j=0;j<sum+1;j++){
//            System.out.print(dp[i][j]+" ");
//        }
//        System.out.println();}

        return dp[n][sum];
    }
}
