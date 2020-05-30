package array.q1_TwoSun;

import java.util.HashMap;
import java.util.Map;

/*
    将查找的过程和存入map的过程合并，简化代码量
    空间复杂度：O(n)
    时间复杂度：O(n)
 */
public class Solution_3 {
    public int[] solution_3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap();
        // 因为要返回的是下标，而map没有根据value获取key的方法，所以选择以元素作为key，下标作为value
        for (int i = 0 ; i < nums.length ; i ++){
            int otherone = target - nums[i];
            // 如果存在 直接返回，否则继续存入并查找
            if(map.containsKey(otherone) && map.get(otherone) != i){
                return new int[]{i, map.get(otherone)};
            }
            map.put(nums[i] , i);
        }
        return null;
    }
}
