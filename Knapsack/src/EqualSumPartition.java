import java.util.Arrays;

//given an array return if it can be partitioned into two equal sum subset
public class EqualSumPartition {

    public boolean equalSum(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        if(sum%2==1)
            return false;
        else
            return subsetSum(arr, sum /2);

        }

//        arr[2,3,4,1]
//                 i    0 1 2 3 4  - j (sum)      j:0->sum+1        i: 0->n+1
//    {}           0    T F F F F
//    {0}          1    T
//    {0,1}        2    T
//    {0,1,3}      3    T
//    {0,1,3,4}    4    T

        //now given an array see if there is a subset with that sum
        public boolean subsetSum(int arr[],int sum) {
        int n= arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<sum+1;i++){
            dp[0][i]=false;
        }
        for(int j=0;j<n+1;j++){
            dp[j][0]=true;
        }
//        for(int i=0;i<n+1;i++){
//            for(int j=0;j<sum+1;j++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }


        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){//be careful here
                if(arr[i-1]<=j)// be careful here
                {
                    dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i][j-1];
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }


        return dp[n][sum]; // be careful here
        }


}
