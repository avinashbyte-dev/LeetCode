class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums2){
            if(set1.contains(num)){
                set2.add(num);
            }
        }

        int[] res = new int[set2.size()];
        int i = 0;
        for(int num : set2){
            res[i] = num;
            i++;
        }
        return res;
    }
}