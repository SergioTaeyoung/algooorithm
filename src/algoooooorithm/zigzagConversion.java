package algoooooorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zigzagConversion {
	
	// site : leetcode
	// prob : zigzagConvertion
	// diff : medium
	// url  :  https://leetcode.com/problems/zigzag-conversion/solution/

	public static String convert(String s, int numRows) {
		
		if(numRows == 1) return s;
		
		int x=0, y=0;
		boolean condition = false;
		char[][] array = new char[numRows][s.length()==1?1:s.length()/2+1];
		String result = "";
		StringBuffer arr = new StringBuffer();
		
		if(numRows > s.length() || numRows == 1) {
			result = s;
		}else{
			for(int i=0; i<s.length(); i ++) {			
				array[x][y] = s.charAt(i);
				//System.err.println("i : " + i + "\tx : " + x + "\ty : " + y + "\tcondition: " + condition);
				
				if(i % (numRows -1) == 0) {
					condition = !condition;
				}
				if(condition == true) {
					x++;
				}else {
					x--;
					y++;
				}
			}
	
			for(int o = 0; o<numRows; o++) {
				for(int k = 0; k<s.length()/2+1; k++) {
					if(array[o][k]!=0) {
						arr.append(array[o][k]);
					}
				}			
			}
			result = arr.toString();
		}
		
		System.out.println("result : " + result);
		return result;
	}
	
    public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        System.out.println("result : " + ret);
        return ret.toString();
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convert("A", 2);
		convert("ABC", 2);
		convert("PAYPALISHIRING", 4);
		
		System.out.println();
		System.out.println("convert2");
		System.out.println();
		
		convert2("A", 2);
		convert2("ABC", 2);
		convert2("PAYPALISHIRING", 4);
	}
}
