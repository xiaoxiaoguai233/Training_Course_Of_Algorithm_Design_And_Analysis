package com.wuzesheng.org.上机考试预测;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 吴泽胜
 * @FileName _4_4_哈夫曼编码_贪心算法
 * @date 2020-12-23 10:47 下午
 * @Software: IntelliJ IDEA
 */

public class _4_4_哈夫曼编码_贪心算法 {

    /**
     * @param args
     */
    private static LinkedList<HufNode> hufList = new LinkedList<HufNode>();//容器存放节点值
    class HufNode implements Comparable<HufNode>{
        int value;
        String name;
        HufNode Lchild = null;
        HufNode Rchild = null;
        public HufNode(){

        }
        public HufNode(int v,String s){
            value = v;
            name = s;
        }
        public HufNode(HufNode l,HufNode r){
            Lchild =l;
            Rchild =r;
            value = Lchild.value + Rchild.value;

        }
        @Override
        public int compareTo(HufNode node1) {
            // TODO Auto-generated method stub
            if (value<node1.value) {
                return -1;
            }else if (value == node1.value) {
                return 0;
            }else {
                return 1;
            }
        }
    }
    //哈夫曼编码
    public static void HufmanCode(){
        if (hufList.size()==1) {
            return;
        }
        while(hufList.size()>1){
            Collections.sort(hufList);
            HufNode node = new _4_4_哈夫曼编码_贪心算法().new HufNode(hufList.get(0),hufList.get(1));
            hufList.remove();
            hufList.remove();
            hufList.add(node);
        }//此时hufList中只有一个元素，这就是编码后的哈夫曼树的根节点
    }
    //解码，后序遍历
    public static void decode(HufNode n,String code){
        if ((n.Lchild==null)&&(n.Rchild==null)) {
            System.out.print("元素值为 "+n.name+"   编码为："+code);
            System.out.println();
            return;
        }
        decode(n.Lchild, code+"0");
        decode(n.Rchild, code+"1");
        return;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//待编码元素个数
        for(int i=0;i<N;i++){
            hufList.add(new _4_4_哈夫曼编码_贪心算法().new HufNode(scanner.nextInt(),scanner.next()));
        }
        HufmanCode();
        decode(hufList.get(0), "");
    }


}

/**
 输入：
    7
    10 a
    15 e
    12 i
    3 s
    4 t
    13 space
    1 newline
 输出：
    元素值为 i   编码为：00
    元素值为 space   编码为：01
    元素值为 e   编码为：10
    元素值为 t   编码为：1100
    元素值为 newline   编码为：11010
    元素值为 s   编码为：11011
    元素值为 a   编码为：111
 */