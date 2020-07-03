package 交换排序;

import java.util.Arrays;

public class 冒泡排序{

public static void main(String[]args){

        int[]arr=new int[]{2,9,5,7,4,0,3,8,6};
        //System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        //System.out.println(Arrays.toString(arr));


        }

/**
 * 
 *
 * @param arr
 * 一共需要比较length-1轮
 * 2,9,5,7,4,0,3,8,6
 * 2,9,5,7,4,0,3,8,6
 * 2,5,9,7,4,0,3,8,6
 * 2,5,7,9,4,0,3,8,6
 * 2,5,7,4,9,0,3,8,6
 * 2,5,7,4,0,9,3,8,6
 * 2,5,7,4,0,3,9,8,6
 * 2,5,7,4,0,3,8,9,6
 * 2,5,7,4,0,3,8,6,9
 */
public static void bubbleSort(int[]arr){
        //for循环遍历数组中的所有元素，控制需要比较多少轮
	for(int i=0;i<arr.length-1;i++){
		//控制每轮中需要比较的次数
		for(int j=0;j<arr.length-1-i;j++){
			if(arr[j]>arr[j+1]){//前面的数如果大于后面的数，就将这两个数位置替换
				int small=arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=small;
				System.out.println(Arrays.toString(arr));
			}
		}
	}
}

}
