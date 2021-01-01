package com.lgf.jzoffer.chapterTwo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Q13 {
    //避免递归传参，定义全局变量
    int m, n, k;
    //标记是否访问
    boolean[][] visited;
    public int movingCount1(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj){
        //下标越界，数位或大于指定值以及已经访问，都返回0
        if (i >= m || j >= n || k < si + sj || visited[i][j]){
            return 0;
        }
        //标记访问过的元素为true
        visited[i][j] = true;
        // 1.当x或者y从n9进位成(n+1)0时，数位和减小了8
        //    设进位后数的数位和为n，差值为x，得出方程n=(n-1)+9+x，即x=-8
        // 2.当x或者y在个位数从0到8的范围内加1时，数位和增加了1，这是常识。
        //    至于为什么只向右和向下扩张是因为不用回溯已走过的路径，扩张的路径只会向下或者向右
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }



    //BFS
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }
}
