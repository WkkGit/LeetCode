package coding_interviews.q12_矩阵中的路径;

/**
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
    [['a','b','c','e'],
    ['s','f','c','s'],
    ['a','d','e','e']]
    但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
/*
    1.word转化为char[] 方便遍历对比
    2.每个节点都当做入口，进行一次DFS
        1.如果当前位置的char与word[index]匹配，那么将当前节点标记为以访问，防止下次重复访问
        2.然后对当前节点的上下左右节点进行DFS，只要四个路径中有一个符合，就返回true；

        3.如果不匹配或者当前节点已经访问过，或者边界溢出，返回false；


    递归参数： 当前元素在矩阵 board 中的行列索引 row 和 col ，当前目标字符在 word 中的索引 index 。
    终止条件：
        返回 false ： 1.行或列索引越界 或 2.当前矩阵元素与目标字符不同 或 3.当前矩阵元素已访问过 （3可合并至2 ） 。
        返回 true ： 字符串 word 已全部匹配，即 index = len(word) - 1 。
    递推工作：
        标记当前矩阵元素：
            将 board[row][col] 值暂存于变量 temp ，并修改为字符 '/' ，代表此元素已访问过，防止之后搜索时重复访问。
        搜索下一单元格：
            朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需一条可行路径） ，并记录结果至 flag 。
        还原当前矩阵元素：
            将 temp 暂存值还原至 board[row][col] 元素。
        回溯返回值：
            返回 flag ，代表是否搜索到目标字符串。
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || word.equals("")){
            return false;
        }
        char[] words = word.toCharArray();
        // 每个节点都作为第一个入口尝试查找
        for(int row = 0 ; row  < board.length; row ++){
            for(int col = 0 ; col < board[0].length; col ++){
                if(dfs(board, words, row, col, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int row, int col, int index){
        // 边界越界或者元素不相等，返回false
        if(row < 0 || col < 0 || row > board.length-1 || col > board[0].length-1 || board[row][col] != words[index]){
            return false;
        }
        // 元素相等，且如果是words的最后一个字符，返回true
        if(index == words.length-1){
            return true;
        }
        // 不是最后一个元素，对上下左右进行下一个字符搜索，并将当前这个符合的元素设置为'/'表示访问过了，防止后面重复访问
        char temp = board[row][col];
        board[row][col] = '/';
        // 一次为上、下、左、右，其中任何一条路径匹配就算成功，所以使用 ||
        boolean flag = dfs(board, words, row - 1, col, index + 1)
                || dfs(board, words, row + 1, col, index + 1)
                || dfs(board, words, row, col - 1, index + 1)
                || dfs(board, words, row, col + 1, index + 1);
        // 搜索结束后将当前元素的值还原
        board[row][col] = temp;

        return flag;
    }
}
