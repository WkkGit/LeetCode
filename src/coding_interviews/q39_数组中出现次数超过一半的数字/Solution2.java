package coding_interviews.q39_数组中出现次数超过一半的数字;

import java.util.HashMap;

/*
    使用hashmap，记录出现次数，同时判断次数是否大于数组长度一半
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            if(map.get(nums[i]) > nums.length/2){
                return nums[i];
            }
        }
        return 0;
    }
}
