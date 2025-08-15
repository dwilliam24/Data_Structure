public class DS0_CH4 {
    public static boolean balanced(int[][] grid) {
        int left=0;
        int right=0;

        for (int a=0; a< grid.length; a++) {
            for (int b=0; b<grid[0].length; b++) {
                if (grid[a][b]==0) {
                    int x=b;
                    int x2=b;
                    while (x>0){
                        x--;
                        left+=grid[b][x];
                    }
                    while (x2< grid[0].length-1){
                        x2++;
                        right+=grid[b][x2];
                    }
                }
            }
        }
        if (left==right){return true;}
        else return false;
    }
}
