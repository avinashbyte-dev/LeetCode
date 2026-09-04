class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key : freq.keySet()){
            int frequency = freq.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int count = 0;
        for(int i=bucket.length - 1;i>=0;i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[count++] = num;

                    if(count == k){
                        return res;
                    }
                }
                
            }
        }
    return res;
    }
}