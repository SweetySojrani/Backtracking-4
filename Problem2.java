// Time Complexity : O(k^n/k)
// Space Complexity : O(nk) where n is the number of blocks and k is the average length of each block
// Did this code successfully run on Leetcode : Yes


class Solution {
    List<String> result = new ArrayList<>();
    public String[] expand(String S) {
        List<List<Character>> block = new ArrayList<>();
	        int i=0;
	        int n = S.length();
	        char[] sChar = S.toCharArray();
	        while(i < n){
	            List<Character> temp = new ArrayList<>();
	            if(sChar[i] == '{'){
	                i++;
	                while(sChar[i]  != '}'){
	                    if(sChar[i]  != ','){
	                        temp.add(sChar[i] );
	                    }
	                    i++;
	                }
	            }
	            else{
	                temp.add(sChar[i] );
	            }
	            block.add(temp);
	            i++;
        }
        backtrack(block,0,new StringBuilder());
        String[] out = result.toArray(new String[result.size()]);
        Arrays.sort(out);
        return out;
    }
    
    private void backtrack(List<List<Character>> block,int index, StringBuilder sb){
        // Base Case
        if(index == block.size()){
            result.add(sb.toString());
             return;
        }
           
        //logic
        for(char c: block.get(index) ){
            sb.append(c);
            backtrack(block,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
