public class DS0_CH9 {
    public static int summation(int paramA, int paramB){
        if (paramA==paramB) return paramA;
        if(paramA+1==paramB) return paramB+paramA;
        else return paramA+ summation(paramA+1, paramB);
    }

}
