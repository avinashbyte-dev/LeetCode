class Solution {
    static String getFrequency(String str){
        int[] charArray = new int[26];
        for(char ch : str.toCharArray()){
            charArray[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i : charArray){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }   
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String,List<String>> frequencyStringMap = new HashMap<>();
        for(String str : strs){
            String frequencyString = getFrequency(str);

            if(frequencyStringMap.containsKey(frequencyString)){
                frequencyStringMap.get(frequencyString).add(str);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                frequencyStringMap.put(frequencyString,list);
                
            }
        }
        return new ArrayList<>(frequencyStringMap.values());
    }

}
