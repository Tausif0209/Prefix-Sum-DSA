public class Leetcode2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int i,l=lower,u=upper,sum=0;
        for(i=0;i<differences.length;i++){
            sum+=differences[i];
            l=Math.max(l,lower-sum);
            u=Math.min(u,upper-sum);
            if(l>u) return 0;
        } return u-l+1;
    }
}
