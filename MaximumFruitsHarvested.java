public class MaximumFruitsHarvested {
  public int maxTotalFruits(int[][] fruits, int startPos, int k) {
         int n=fruits.length;
        int len=Math.max(startPos,fruits[n-1][0]);//length of x-axis
        int[] prefixSumLeft=new int[len+1];
        int[] prefixSumRight=new int[len+1];
        int[] xAxis=new int[len+1];
        for (int[] fruit : fruits) {
            xAxis[fruit[0]] = fruit[1];
        }
        for(int i=0;i<len+1;i++) {
            prefixSumLeft[i]=(i==0)?xAxis[0]:xAxis[i]+prefixSumLeft[i-1];
            prefixSumRight[len-i]=(len-i==len)? xAxis[len]:xAxis[len-i]+prefixSumRight[len-i+1];
        }
        if(startPos==0) return  prefixSumLeft[Math.min(k,len)];
        else if(startPos==len) return prefixSumRight[Math.max(len-k,0)];
        int max=Math.max(prefixSumLeft[Math.min(startPos + k, len)]-prefixSumLeft[Math.max(startPos - 1, 0)],
                prefixSumRight[Math.max(startPos - k, 0)]-prefixSumRight[Math.min(startPos + 1, len)]);

//        System.out.println(max);
//        System.out.println(Arrays.toString(prefixSumRight));
//        System.out.println(Arrays.toString(prefixSumLeft));

        int a,b;
        if(k%2==0){
            a=k/2-1;
            b=k/2+1;
        } else{
            a=k/2;
            b=a+1;
        }

        while(a>=0){
            max=Math.max(max,Math.max(prefixSumLeft[Math.min(startPos + a, len)]-prefixSumLeft[Math.max(startPos - 1, 0)]+
                            (prefixSumRight[Math.max(startPos + a - b, 0)]-prefixSumRight[startPos]),
                    prefixSumRight[Math.max(startPos - a, 0)]-prefixSumRight[Math.min(startPos + 1, len)]+
                            (prefixSumLeft[Math.min(startPos - a + b, len)]-prefixSumLeft[startPos])));
            a--;
            b++;
        } return max;
    }
}
