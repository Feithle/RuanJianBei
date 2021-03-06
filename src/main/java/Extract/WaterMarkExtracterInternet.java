package Extract;
import java.util.ArrayList;

import Bean.RowInBase;
public class WaterMarkExtracterInternet {
	public String extractWaterMark(ArrayList<RowInBase> rowInBases) {
	int order=1;
	String WaterMarkCode="";
	String watermark ="";
	String watermark_code ="";
	for(int i=0;i<rowInBases.size();i++) {
		if(i==rowInBases.size()-1)
		{
			break;
		}
		if(rowInBases.get(i).getMod()==rowInBases.get(i+1).getMod()) {
			watermark_code=WaterMarkGetterForInternet.getWaterMark(rowInBases.get(i).getId(), rowInBases.get(i).getHashvalue());
			if(!watermark_code.equals("")) {
				watermark=watermark_code;
			}
		}
		if(rowInBases.get(i).getMod()!=rowInBases.get(i+1).getMod()) {
			order=order+1;
			WaterMarkCode=WaterMarkCode+watermark;
	        System.out.println("get the code in "+i+"th group");
	        System.out.print("last group's code is"+watermark);
		}
	}
	WaterMarkCode=WaterMarkCode+watermark;
	System.out.println("finished extracting the code in base and the code is:"+WaterMarkCode);
	return WaterMarkCode;
	}
}
