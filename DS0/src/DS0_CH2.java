import java.util.Arrays;

public class DS0_CH2 {
    public static void commonNeighbors(int[] list) {
        for(int a=0; a< list.length; a++) {
            if (list.length==1){
                list[0]=0;
                break;
            }

            if (a==0) {
                if (list[a+1] != list[a]) {
                    list[a] = 0;
                }
            }

            else if (a==list.length-1){
                if (list[a-1] != list[a]) {
                    list[a] = 0;
                }
            }

            else {
                if (list[a-1] != list[a] && list[a+1] != list[a]) {list[a] = 0;}
            }
        }
    }
}

