class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        // set has [100,4,200,1,3,2] randomly and no duplicates
        int len = 0;
        for(int ele : set){
            if(!set.contains(ele - 1)){
                int curr = 1;
                int current = ele;
                while(set.contains(current + 1)){
                    curr++;
                    current++;

                }

                len = Math.max(len,curr);

            }

        }
    return len;
    }
}