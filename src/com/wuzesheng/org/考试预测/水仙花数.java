package com.wuzesheng.org.考试预测;

/**
 * @author 吴泽胜
 * @FileName 水仙花数
 * @date 2020-12-07 10:13 下午
 * @Software: IntelliJ IDEA
 */

/**
 *
 * 	求100到999之间的水仙花数。
 * 水仙花数的每个位上的数字的 n 次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
 * 编程思路：
 * 1.for循环遍历100-999之间的所有数
 * 2.了解水仙花数的特点，即1^3 + 5^3+ 3^3 = 153，i的个位数 十位数 百位数三次幂之和等于i
 * 3.得到三位数的个位a,十位数b,百位数c
 * 4.if条件语句判断a^3+b^3+c^3==i，成立即得到水仙花数i输出
 */
public class 水仙花数 {


    public static void main(String[] args) {


        int count = 0;
        for (int i = 100; i < 1000; i++) {

            // 获取个位
            int num1 = i % 10;
            // 获取十位
            int num2 = i / 10 % 10;
            // 获取百位
            int num3 = i / 100;

            if ( (Math.pow(num1,3) + Math.pow(num2,3) + Math.pow(num3,3) ) == i ){
                System.out.println( i );
                count++;
            }
        }
        System.out.println("counts number:" + count);


    }

}
