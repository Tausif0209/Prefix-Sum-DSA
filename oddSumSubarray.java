class Solution {
    public int numOfSubarrays(int[] arr) {
        if(arr.length==1) return (arr[0]%2==0)?0:1;
        long count=0;
        int evenSum=1,oddSum=0,totalSum=0;
        for(int el:arr)
        {
            totalSum+=el;
            if(totalSum%2==0){
                count+=oddSum;
                evenSum++;
            }
            else{
                count+=evenSum;
                oddSum++;
            }
        }
        int den=(int)Math.pow(10,9)+7;
        return (int)(count%den);
    }
}