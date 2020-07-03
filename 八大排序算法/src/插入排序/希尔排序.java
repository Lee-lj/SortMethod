package 插入排序;

import java.util.Arrays;
//简单来说希尔排序就是根据步长分组，在组中进行插入排序，然后缩小步长，再排序，直到不能缩小步长为止
public class 希尔排序 {

public static void main(String[]args){
        //根据数组的长度，确定一个步长，从第一个数开始，它之后的距离为步长或步长的倍数的数就跟它为一个抽象的数组。例如步长是5，那么下面数组中{5，1}为一个数组，然后在数组内进行插入排序之后，
        int[]arr=new int[]{5,8,6,2,4,1,3,7,9,0};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        //System.out.println(Arrays.toString(arr));
        }

public static void shellSort(int[]arr){
	int k=0;
	//遍历所有的步长
	for(int l=arr.length/2;l>0;l/=2){
		//遍历所有的元素，那么起始位置就是arr.length/2下标所在的位置
		for(int i=l;i<arr.length;i++){
			//遍历根据步长划分的组中的所有元素
			for(int j=i-l;j>=0;j-=l){
				//如果当前元素大于下标加上步长之后的元素，将两个数调换位置
				if(arr[j]>arr[j+l]){
					int temp=arr[j+l];
					arr[j+l]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("第"+(k+1)+"次的排序结果"+Arrays.toString(arr));
		k++;
	}
}

}
