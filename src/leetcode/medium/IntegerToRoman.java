package leetcode.medium;

public class IntegerToRoman {
	// site : leetcode
	// prob : String to Integer(atoi)
	// diff : medium
	// url  : https://leetcode.com/problems/integer-to-roman/
	
	//	Symbol       Value
	//	I             1
	//	V             5
	//	X             10
	//	L             50
	//	C             100
	//	D             500
	//	M             1000
	
	public static String intToRoman(int num) {
		int[] valueArr = {1000, 500, 100, 50, 10, 5, 1};
		String[] symbolArr = {"M", "D", "C", "L", "X", "V", "I"};
		int tmp;
		boolean con = false;
		StringBuffer result = new StringBuffer();
		
		for(int i =0; i<valueArr.length; i++) {
			tmp = num / valueArr[i];
			num = num % valueArr[i];
			
			if(i%2 == 0) {
				if(tmp != 4) {
					for(int j=0; j<tmp; j++) {
						result.append(symbolArr[i]);
					}
				}else{
					if(!con) result.append(symbolArr[i]+symbolArr[i-1]);
					con = false;
				}
			}else {
				if(tmp !=1 || num==0) {
					for(int j=0; j<tmp; j++) {
						result.append(symbolArr[i]);
					}
				}else{
					result.append(symbolArr[i+1]+symbolArr[i-1]);
					con = true;
				}
			}
			System.err.println(result);
		}
		System.err.println("result : " + result);
		return result.toString();
	}
	
	public static String intToRoman2(int num) {
		int[] valueArr = {1000, 500, 100, 50, 10, 5, 1};
		String[] symbolArr = {"M", "D", "C", "L", "X", "V", "I"};
		int tmp;
		boolean con = false;
		StringBuffer result = new StringBuffer();
		
		for(int i =0; i<valueArr.length; i++) {			
			
			if(i%2 == 0) {
				tmp = num / valueArr[i];
				num = num % valueArr[i];
				if(tmp != 4) {
					for(int j=0; j<tmp; j++) {
						result.append(symbolArr[i]);
					}
				}else{
					if(!con) result.append(symbolArr[i]+symbolArr[i-1]);
					con = false;
				}
			}else {
//				if(지금숫자가 500 50 5 일때,,, 앞자리가 5일때?)
				tmp = num / valueArr[i];
				num = num % valueArr[i];
				result.append(symbolArr[i+1]+symbolArr[i-1]);
				con = true;				
			}
			System.err.println(result);
		}
		System.err.println("result : " + result);
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		intToRoman(9);
	}

}
