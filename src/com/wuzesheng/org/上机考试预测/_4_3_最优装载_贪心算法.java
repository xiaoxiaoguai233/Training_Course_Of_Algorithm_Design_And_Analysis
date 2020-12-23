package com.wuzesheng.org.上机考试预测;

import java.util.Arrays;

public class _4_3_最优装载_贪心算法 {

    private static int[] x;

    /**
     *
     * @param c 总重量
     * @param w 每个集装箱的重量
     * @param x 记录是否装入 （1： 装入    0： 不装入）
     * @return
     */
    public static float Loading(float c, float[] w, int[] x) {
        int n = w.length;
        Element[] d = new Element[n];
        for (int i = 0; i < n; i++) {
            // 初始化
            d[i] = new Element(w[i], i);
        }
        Arrays.sort(d);
        // 记录最优值
        float opt = 0;
        for (int i = 0; i < n; i++) {
            // 初始化
            x[i] = 0;
        }
        for (int i = 0; i < n && d[i].w <= c; i++) {
            x[d[i].i] = 1;
            opt += d[i].w;
            c -= d[i].w;
        }
        return opt;
    }

    public static void main(String[] args) {
        float c = 10;
        float[] w = new float[]{4, 2, 5, 1, 3};
        x = new int[w.length];
        float opt = Loading(c, w, x);
        System.out.println("最优值为: " + opt);
        System.out.println("最优解为： " + Arrays.toString(x));
    }

    public static class Element implements Comparable<Element> {
        float w;
        int i;

        public Element(float w, int i) {
            this.w = w;
            this.i = i;
        }

        /**
         * 按照升序排列
         */
        public int compareTo(Element o) {
            if (this.w < o.w)
                return -1;
            else if (this.w == o.w)
                return 0;
            else
                return 1;
        }
    }
}
