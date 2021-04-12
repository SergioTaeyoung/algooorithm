package leetcode.medium;

import java.util.Arrays;

public class ContainerWithMostWater {
	// site : leetcode
	// prob : String to Integer(atoi)
	// diff : medium
	// url  : https://leetcode.com/problems/container-with-most-water/
	
	// 배열로 주어진 이상 item들을 모두 한번씩 순회해야한다.
	// 양끝을 start, last 에 담아 반복문 수행
	
	public static int maxArea(int[] height) {
		int start=0, last=height.length-1;
		int max = 0;
		int now = 0;
		
		while(last-start > 0) {
			now = height[last]>height[start]?height[start]:height[last];	// start, last 의 막대기 길이가 낮은걸로 해야 물이 안넘침
			max = now * (last-start)>max? now * (last-start) : max;
			if(height[last]>height[start]) {								// 모두 한번씩 순회
				start++;
			}else {
				last--;
			}
		}		
		return max;		
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = {2,2,3,4,9,8,7,3};		
		maxArea(arr);
	}

}
