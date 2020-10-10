package com.spring.boot.demo.algorithm.sort;

/**
 * https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode/
 * 加油站，代码挺简单的，理解了思路挺好实现。
 * 定一个一个总剩余油和当前加油站剩余的油。当前加油站剩余的油小于0时，表示我们无法到达该加油站。则从下一个加油站重新出发。
 *
 * https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/ 这个思路更简单，就不实现了，可以参考
 * Created by weiyongjun on 2020/8/14
 */
public class GasStation_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_gap = 0;
        int current_gap = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            total_gap += gas[i] - cost[i];
            current_gap += gas[i] - cost[i];
            if(current_gap < 0 ){
                index = i+1;
                current_gap = 0;
            }

        }
        return total_gap >=0? index: -1;
    }

}
