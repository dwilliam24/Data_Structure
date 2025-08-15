public class DS0_CH1
{
    public static int uniqueCount(int[] list)
        {
            int amount = list.length;
            for(int a = 0; a<list.length; a++)
            {
                for (int e=0; e<a; e++)
                {
                    if (list[e]==list[a]){amount--; break;}

                }
            }
            return amount;
        }
}
