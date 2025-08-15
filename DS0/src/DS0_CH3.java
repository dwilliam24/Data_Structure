public class DS0_CH3
{
    public static int[] fewest(int cents)
    {
        int[] coins= {1,5,10,25,100,500,1000,2000,5000,10000};
        int[] last = new int[10];
        for (int a=coins.length-1; a>=0; a--){
            while (cents>=coins[a]){
                last[a]++;
                cents -= coins[a];
            }
        }
        return last;
    }
}
