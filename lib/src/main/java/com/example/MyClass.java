package com.example;

public class MyClass {
    //冒泡排序
    public static void bubbleSort(int[] array){
        int middle;  //临时变量
        boolean flag; // 是否排序的标志位
        for (int i = 0; i < array.length - 1; i++) {
            flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    middle = array[j];
                    array[j] = array[j+1];
                    array[j+1] = middle;
                    flag = true;
                }
            }
            if (!flag){  //这一轮排序中数据没有发生变化代表数据已经排好了，所以不用继续循环了
                break;
            }
        }
    }

    //选择排序
    public static void selectionSort(int[] array){
        int index = 0;  //索引
        int middle;
        for (int i = 0; i < array.length-1; i++) {
            index = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j+1]){
                    index = j+1;
                }
            }
            middle = array[index];
            array[index] = array[array.length - 1-i];
            array[array.length - 1-i] = middle;
        }
    }


    public static void main(String[] args){
        int[] array = {1,2,3,4,9,8,7,6,5,0};
        //bubbleSort(array);  //冒泡
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
