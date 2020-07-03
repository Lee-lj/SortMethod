package 基数排序;

import java.util.Arrays;

public class 基数排序 {

public static void main(String[]args){
        /*基数排序适用于有多个数并且位数不同的数组例如 2,26,778,126,21,32.认为有0~9个桶用来存储数据，第一轮从个位开始，按照个位的数字将它放入对应的桶中，然后按照0~9桶的顺序取出这些数
         *先放进桶中的数先取出来(放的时候是从前往后放的)，这样根据个位排序的一轮就完成了，然后根据十位上的数来进行下一轮的这样的放入取出，看最大的数有几位，就比较几轮
         */

        int[]arr=new int[]{2,95,42,61,465,728,951,23,21,78,12,459,412,4562};
        RadixSort(arr);
        System.out.println(Arrays.toString(arr));
        }

public static void RadixSort(int[]arr){
	//存取数组中最大的数
	int max=Integer.MIN_VALUE;//只能拿小的去比较大的，如果是MAX_value是无法比较的ֵ
	for(int i=0;i<arr.length;i++){
		if(arr[i]>max){
			max=arr[i];
		}
	}
	//计算最大数字是几位数，(max+"") max+一个空值就变成一个字符串，然后使用length就知道是几位的了
	int maxLength=(max+"").length();
	//用于临时存储数据的数组
	int[][] data=new int[10][arr.length];//二维数组，因为有0~9个桶，所以第一维为10，不知道一个桶中有多少个数，定义每个桶都能存放整个数组
	//用于记录在data中相应的数组中每一轮存放的数字的数量
	int[] counts=new int[10];
	//根据最大长度的数决定比较的次数，X是位数，n是位数要除以的数，得到个位数
	for(int x=0,n=1;x<maxLength;x++,n*=10){
		//把每一个数字分别计算余数
		for(int j=0;j<arr.length;j++){
			int yushu=arr[j]/n%10;//计算余数，%10就是抹去个位之前的数(451/1$10=1 450是10的倍数，被抹去)，保证每次都取到的是个位数
			//把当前遍历的数据放入指定的数组中
			data[yushu][counts[yushu]]=arr[j];
			//这个桶中的数的数量用counts来存放，刚好余数对应了0~9的桶，所以counts[yushu]就是余数为几的桶中存放的数的数量
			counts[yushu]++;
		}

		//记录从桶中取的元素需要放的位置
		int index=0;
		//把数字取出来，q指的是桶的数量，0~9的桶从前往后取
		for(int q=0;q<counts.length;q++){
			//记录数量的数组中当前余数记录的数量不为0
			if(counts[q]!=0){
				//循环取出元素
				for(int l=0;l<counts[q];l++){
					//取出元素
					arr[index]=data[q][l];
					//记录下一个位置
					index++;
				}
				//这一轮结束，把桶中的数量清零
				counts[q]=0;

			}
		/*遍历打印每一轮的排序的结果
		for(int[] nums:data) {
			System.out.println(Arrays.toString(nums));
		}*/

		}
	}

}
}

