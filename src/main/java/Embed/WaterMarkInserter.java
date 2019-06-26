package Embed;

import java.util.ArrayList;

import Bean.RowInBase;
import DaoForLocalDataBase.CellGeter;
import DaoForLocalDataBase.CellUpdater;
public class WaterMarkInserter {
	/**
	 * @param WaterMarkContent  0101001100
	 * @param order which code do we want to use
	 * @param id primary key
	 * @param hash hash value
	 */
	public static void insertWaterMark(int order,String WaterMarkContent,int id,int hash) {
		CellGeter cellGeter=new CellGeter();
		String oriStr=cellGeter.GetCell(id, "content");
		String code="";
		if(WaterMarkContent.charAt((order%WaterMarkContent.length()))=='0') {
			code="\r";
		}
		if(WaterMarkContent.charAt((order%WaterMarkContent.length()))=='1') {
			code="\n";
		}
		StringBuffer oriStr_Buffer=new StringBuffer(oriStr).insert(hash%(oriStr.length()), code);
		String ChangedStr=oriStr_Buffer.toString(); 
		CellUpdater cellUpdater =new CellUpdater();
		cellUpdater.updateCell(id, "content", ChangedStr);
		
	}
}
