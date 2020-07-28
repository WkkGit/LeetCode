package leetcode.q690_员工的重要性;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
    DFS，使用栈的辅助
 */
public class Solution2 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        Stack<Integer> stack = new Stack();
        stack.push(id);
        int sum = 0;
        while(!stack.empty()){
            int temp = stack.pop();
            sum += map.get(temp).importance;
            for(int sub : map.get(temp).subordinates){
                stack.push(sub);
            }
        }
        return sum;
    }
}
