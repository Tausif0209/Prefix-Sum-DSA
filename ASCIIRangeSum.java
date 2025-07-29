import java.util.ArrayList;

public class ASCIIRangeSum {
  public ArrayList<Integer> asciirange(String s) {
        int[][] index=new int[26][2];
        for(int[] a:index) a[0]=-1;
        int len =s.length();
        int[] prefixSum=new int[len];
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            prefixSum[i]=(i==0)?ch:prefixSum[i-1]+ch;
            if(index[ch-'a'][0]==-1) index[ch-'a'][0]=i;
            index[ch-'a'][1]=i;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            if((index[i][0]==-1) || (index[i][0]==index[i][1]) 
            || index[i][0]==index[i][1]-1) continue;
            ans.add(prefixSum[index[i][1]-1]-prefixSum[index[i][0]]);
        } return ans;
    }
}
