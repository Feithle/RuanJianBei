package Test;

import Bean.UserBean;
import Extract.WaterMarkExtracter;
import Sort.GetId_Modinrows;
import Sort.SortTheRowInBase;

public class TestExtract {

    public static void main(String[] args) {
    	UserBean userBean =new UserBean();
    	userBean.setKey("5214");
    	//userBean.setMarkContent("111000");
    	userBean.setN(96);
    	//userBean.setN(3);
    	WaterMarkExtracter waterMarkExtracter=new WaterMarkExtracter();
    	GetId_Modinrows getId_Modinrows=new GetId_Modinrows();
    	SortTheRowInBase sortTheRowInBase =new SortTheRowInBase();
    	System.out.print(waterMarkExtracter.extractWaterMark(sortTheRowInBase.SortAscend(getId_Modinrows.GetIdAndModOfEveryRows(userBean))));
    }
}
