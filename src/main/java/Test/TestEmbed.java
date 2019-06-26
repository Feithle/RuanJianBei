package Test;

import Bean.UserBean;
import DaoForLocalDataBase.CellGeter;
import DaoForLocalDataBase.CountRowsDao;
import Embed.WaterMarkEmbeder;
import Embed.WaterMarkInserter;
import HashUtil.MyOwnHash;
import Sort.GetId_Modinrows;
import Sort.SortTheRowInBase;

public class TestEmbed {
    public static void main(String[] args) {
    	UserBean userBean =new UserBean();
    	userBean.setKey("123");
    	userBean.setMarkContent("111000");
    	userBean.setN(userBean.getMarkContent().length());
    	WaterMarkEmbeder waterMarkEmbeder =new WaterMarkEmbeder();
    	GetId_Modinrows getId_Modinrows=new GetId_Modinrows();
    	SortTheRowInBase sortTheRowInBase =new SortTheRowInBase();
    	waterMarkEmbeder.embedWaterMark(sortTheRowInBase.SortAscend(getId_Modinrows.GetIdAndModOfEveryRows(userBean)), userBean.getMarkContent());
    
    	
    	
//    	
    	
    	
//    	WaterMarkInserter waterMarkInserter=new WaterMarkInserter();
//    	CellGeter cellGeter=new CellGeter();
//    	System.out.println("原始字符串长度");
//    	System.out.println(cellGeter.GetCell(1, "content").length());
//    	System.out.println("==========================");
//    	waterMarkInserter.insertWaterMark(1, "010000001", 1, 2);
//    	System.out.println("==========================");
//    	System.out.println("更新后字符串长度");
//    	System.out.println(cellGeter.GetCell(1, "content").length());
//    	if(cellGeter.GetCell(1, "content").charAt(2)=='\n') {
//    		System.out.println("1");
//    	}
    }
}
