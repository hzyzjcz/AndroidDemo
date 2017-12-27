package com.example;

public class MyClass {
    //冒泡排序
    public static void bubbleSort(int[] array){
        int count = 0;
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
                    count++;
                }
            }
            if (!flag){  //这一轮排序中数据没有发生变化代表数据已经排好了，所以不用继续循环了
                break;
            }
        }
        System.out.println("冒泡排序所需要的步数："+count);
    }

    //选择排序
    public static void selectionSort(int[] arr){
        int count = 0;
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){
                    k = j; //记下目前找到的最小值所在的位置
                    count++;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println("选择排序所需要的步数："+count);
    }

    //插入排序
    public static void insertionSort(int[] array){
        int count = 0;
        int temp;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(array[j] < array[j-1]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    count ++;
                }else{         //不需要交换
                    break;
                }
            }
        }
        System.out.println("插入排序所需要的步数："+count);
    }


    public void charupaixu(int[] array){
        int middle;
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (array[j] < array[j-1]){
                    middle = array[j];
                    array[j] = array[j-1];
                    array[j-1] = middle;
                }
            }
        }
    }



    public static void main(String[] args){
        int[] array = {1,2,3,4,9,8,7,6,5,0};
        bubbleSort(array);  //冒泡
        //selectionSort(array);  //选择排序
        //insertionSort(array);  //插入排序
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
