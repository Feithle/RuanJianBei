package Encode;

import java.util.Arrays;

public class StrBinaryTurn {
 
	public static String test4(String content){//content 
		StrBinaryTurn strBinaryTurn = new StrBinaryTurn();
		String binString ="";
		binString=strBinaryTurn.StrToBinStr(content);
		return binString;
	}
	public static String  test6(String markcontent){//markcontent
		StrBinaryTurn strBinaryTurn = new StrBinaryTurn();
		String binString = strBinaryTurn.BinStrToStr(markcontent);
		return binString;
	}
	 
	public void test5(){
		String string = "lavi";
		StrBinaryTurn strBinaryTurn = new StrBinaryTurn();
		int[] intArr = strBinaryTurn.StrToBinArr(string);
		System.out.println(Arrays.toString(intArr));
		String resultString = strBinaryTurn.BinArrToStr(intArr);
		System.out.println(resultString);
	}
	public String StrToBinStr(String str){
		return BoolArrToBinStr(StrToBool(str));
	}
	public String BinStrToStr(String arrStr){
		return BoolToStr(BinStrToBoolArr(arrStr));
	}
	public int[] StrToBinArr(String str){
		return BoolArrToBinArr(StrToBool(str));
	}
	public String BinArrToStr(int[] intArr){
		return BoolToStr(BinArrToBoolArr(intArr));
	}
	public int[] BoolArrToBinArr(boolean[] boolArr){
		int[] intArr = new int[boolArr.length];
		for (int i= 0;i < boolArr.length;i++) {
			intArr[i] = boolArr[i] ? 1 : 0;
		}
		return intArr;
	}
	public boolean[] BinArrToBoolArr(int[] intArr){
		boolean[] boolArr = new boolean[intArr.length];
		for (int i= 0;i < intArr.length;i++) {
			boolArr[i] = intArr[i]==1 ? true : false;
		}
		return boolArr;
	}
	public String BoolArrToBinStr(boolean[] boolArr){
		StringBuffer stringBuffer = new StringBuffer();
		for (boolean b : boolArr) {
			if(b){
				stringBuffer.append("1");
			}else{
				stringBuffer.append("0");
			}
		}
		return stringBuffer.toString();
	}
	public boolean[] BinStrToBoolArr(String str){
		char[] chs = str.toCharArray();
		boolean[] boolArr = new boolean[chs.length];
		for (int i = 0;i < chs.length;i++) {
			if(chs[i] == '0'){
				boolArr[i] = false;
			}else {
				boolArr[i] = true;
			}
		}
		return boolArr;
	}
    public boolean[] StrToBool(String input){
        boolean[] output=Binstr16ToBool(BinstrToBinstr16(StrToBinstr(input)));
        return output;
    }
    public String BoolToStr(boolean[] input){
        String output=BinstrToStr(Binstr16ToBinstr(BoolToBinstr16(input)));
        return output;
    }
    private String StrToBinstr(String str) {
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }
        return result;
    }
    private String BinstrToStr(String binStr) {
        String[] tempStr=StrToStrArray(binStr);
        char[] tempChar=new char[tempStr.length];
        for(int i=0;i<tempStr.length;i++) {
            tempChar[i]=BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }
    private String BinstrToBinstr16(String input){
        StringBuffer output=new StringBuffer();
        String[] tempStr=StrToStrArray(input);
        for(int i=0;i<tempStr.length;i++){
            for(int j=16-tempStr[i].length();j>0;j--)
                output.append('0');
            output.append(tempStr[i]+" ");
        }
        return output.toString();
    }
    private String Binstr16ToBinstr(String input){
        StringBuffer output=new StringBuffer();
        String[] tempStr=StrToStrArray(input);
        for(int i=0;i<tempStr.length;i++){
            for(int j=0;j<16;j++){
                if(tempStr[i].charAt(j)=='1'){
                    output.append(tempStr[i].substring(j)+" ");
                    break;
                }
                if(j==15&&tempStr[i].charAt(j)=='0')
                    output.append("0"+" ");
            }
        }
        return output.toString();
    }   
    private boolean[] Binstr16ToBool(String input){
        String[] tempStr=StrToStrArray(input);
        boolean[] output=new boolean[tempStr.length*16];
        for(int i=0,j=0;i<input.length();i++,j++)
            if(input.charAt(i)=='1')
                output[j]=true;
            else if(input.charAt(i)=='0')
                output[j]=false;
            else
                j--;
        return output;
    }
    private String BoolToBinstr16(boolean[] input){ 
        StringBuffer output=new StringBuffer();
        for(int i=0;i<input.length;i++){
            if(input[i])
                output.append('1');
            else
                output.append('0');
            if((i+1)%16==0)
                output.append(' ');           
        }
        output.append(' ');
        return output.toString();
    }
    private char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;   
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }   
        return (char)sum;
    }
    private String[] StrToStrArray(String str) {
        return str.split(" ");
    }
    private int[] BinstrToIntArray(String binStr) {       
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];   
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }
}