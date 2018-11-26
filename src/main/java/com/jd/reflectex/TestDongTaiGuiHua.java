package com.jd.reflectex;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-16 18:37
 */
public class TestDongTaiGuiHua {
    private static int[] array = new int[20];
    public static void main(String[] args) {
        //invoke();
       // int n = zouliuti(10);
       // System.out.println("n = " + n);
       // stip();
        zuichangzixulie();
    }
    private static void invoke(){

        int[] arry = {0,0,5,3,4,2,9,0};
        int[] arry_copy = new int[10];
        int[] arry_sum = new int[10];
        for(int i=2;i<arry.length;i++){

            if(arry_copy[i-1]==-1){

                arry_sum[i]=arry_sum[i-1]+arry[i];

            }else{

                if(arry_sum[i-2]+arry[i-1]+arry[i]>arry_sum[i-2]+arry[i-1]*arry[i]){
                    arry_sum[i] = arry_sum[i-2]+arry[i-1]+arry[i];

                }else{
                    arry_sum[i] = arry_sum[i-2] + arry[i-1]*arry[i];
                    arry_copy[i] = -1;
                }
            }

        }
        System.out.println("arry_sum = " + arry_sum.toString());

    }

    private static void stip(){
        int[] A = {2,1,2,1,4};
        int [][]Map = new int[10][5];
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[i];j++){
                Map[i][j] = 9999999;
            }
        }
        Map[0][0]=0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[i];j++){
                Map[i][j] = Math.min(Map[i-1][j]+1,Map[i-1][j]);
            }
        }
        System.out.println("JSON.toJSONString(Map) = " + JSON.toJSONString(Map));
    }

    private static int zouliuti(int n){
        if(array[n] > 0) return array[n];
        if( n < 1 )return 0;
        if( n < 3 ) return  array[n] =n;
        return array[n] =zouliuti(n-1)+zouliuti(n-1);
    }

    private static void  zuichangzixulie(){
        int[] array = {2,1,5,3,6,4,6,3};
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(6);
        list.add(3);
        zuichangzixulieCopy(list.size()-2,list.size()-1,list);
        
    }
    private static int zuichangzixulieCopy(int i,int j,List<Integer> array){
        if(array.size()==1){
            return 1;
        }
        if(i <=0 || j<=0){
            return 0;
        }
        System.out.println("JSON.toJSONString(array) = " + JSON.toJSONString(array));
        if(array.get(j) > array.get(i)){
            
            return zuichangzixulieCopy(i-1,j-1,array.subList(0,array.size()-1)) +1;
        }else{
            zuichangzixulieCopy(i-1,j,array);
        }
        return 0;
    }
}
