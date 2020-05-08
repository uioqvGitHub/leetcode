package com.uioqv.leetcode.mincostTickets;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 * <p>
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LiuGuoQing
 * @since 2020-05-06
 * @deprecated  错误解法
 */
@Deprecated
public class MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        // 可以组成多少个以下七天票时使用七天票
        double nums = (double) costs[2] / costs[1];
        int sevenMaxNum = (int) Math.ceil(nums);
        // 30天票价可以组成多少个以下一天票时使用一天票
        nums = costs[1] / costs[0];
        int oneSevenNum = (int) Math.ceil(nums);

        int[] maxDay = {-1, oneSevenNum, sevenMaxNum * 7};
        int[] returnIndexAndPrice = {0, 0};
        int total = 0;
        while (returnIndexAndPrice[0] < days.length) {
            setPrice(returnIndexAndPrice, days, costs, maxDay, 30);
            total += returnIndexAndPrice[1];
        }
        return total;
    }

    private void setPrice(int[] returnIndexAndPrice, int[] days, int[] costs, int[] maxDay, int day) {
        int startIndex = returnIndexAndPrice[0];
        int endIndex = 0;
        for (int i = startIndex; i < days.length && days[i] - days[startIndex] < day; i++) {
            endIndex = i + 1;
        }
        int maxDayIndex;
        int costsIndex;
        int nextDay = -1;
        if (day == 30) {
            maxDayIndex = 2;
            costsIndex = 2;
            nextDay = 7;
        } else if (day == 7) {
            maxDayIndex = 1;
            costsIndex = 1;
            nextDay = 1;
        } else {
            maxDayIndex = 0;
            costsIndex = 0;
        }

        if (endIndex - startIndex > maxDay[maxDayIndex]) {
            returnIndexAndPrice[1] = costs[costsIndex];
            returnIndexAndPrice[0] = endIndex;
        } else {
            setPrice(returnIndexAndPrice, days, costs, maxDay, nextDay);
        }
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] consts = {2, 7, 15};
        int i = new MincostTickets().mincostTickets(days, consts);
        System.out.println(i);


        days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};
        consts = new int[]{2,7,15};
        i = new MincostTickets().mincostTickets(days, consts);
        System.out.println(i);

        days = new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        consts = new int[]{3,13,45};
        i = new MincostTickets().mincostTickets(days, consts);
        System.out.println(i);


    }
}
