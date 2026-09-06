class Solution {
    public int subarraySum(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
       int count = 0;
       int preFixSum = 0;
       map.put(preFixSum,1);
       for(int i=0;i<nums.length;i++){
            preFixSum += nums[i];
            int prevSum = preFixSum - k;
            if(map.containsKey(prevSum)){
                count += map.get(prevSum);
            }
            map.put(preFixSum,map.getOrDefault(preFixSum,0)+1);  
        }
        return count;
    }
}