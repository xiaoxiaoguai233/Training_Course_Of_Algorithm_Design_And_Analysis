package com.wuzesheng.org.上机考试预测;

/**
 * @author 吴泽胜
 * @FileName _4_1_活动问题_贪心算法
 * @date 2020-12-23 10:33 下午
 * @Software: IntelliJ IDEA
 */

public class _4_1_活动问题_贪心算法 {

    public int greedySelector(int[] s, int[] f, boolean[] a){
        int n = s.length-1;
        a[1] = true;		//第一个活动被选中
        int j = 1;
        int count = 1;		//被选中活动的数量，默认第一个活动被选中
        for(int i = 2; i <= n; i++){
            if( s[i] >= f[j] ){	//下一个活动开始时间大于大于等于上一个活动结束时间
                a[i] = true;
                j = i;
                count++;
            }
            else
                a[i] = false;
        }
        return count;
    }
    public static void main(String[] args) {
        int s[] = {-1,1,3,0,5,3,5,6,8,8,2,12};		//默认下标从1开始（已非减序排好序），初始的-1无用
        int f[] = {-1,4,5,6,7,8,9,10,11,12,13,14};
        boolean[] a = new boolean[s.length];
        _4_1_活动问题_贪心算法 ac = new _4_1_活动问题_贪心算法();
        int counts = ac.greedySelector(s, f, a);
        System.out.println("活动集合中最大相容活动数量为:"+counts);
        for(int i = 1; i <= s.length-1; i++){
            if( a[i] ){
                System.out.println("第"+i+"活动被选中，其开始时间为："+s[i]+"，结束时间为："+f[i]);
            }
        }
    }
}
