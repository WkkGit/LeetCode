package array.q1_TwoSun;

import java.util.HashMap;
import java.util.Map;

/*
    使用hash表降低时间复杂度
    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution_2 {
    public int[] solution_2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap();
        // 因为要返回的是下标，而map没有根据value获取key的方法，所以选择以元素作为key，下标作为value
        // O(n)
        for (int i = 0 ; i < nums.length ; i ++){
            map.put(nums[i] , i);
        }
        // O(n)
        for (int i = 0 ; i < nums.length ; i ++){
            int otherone = target - nums[i];
            // 查看是否有符合的值，并确保不是同一元素
            if(map.containsKey(otherone) && map.get(otherone) != i){
                return new int[]{i, map.get(otherone)};
            }
        }
        return null;
    }
}
