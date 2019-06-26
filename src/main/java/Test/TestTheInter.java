package Test;

import Bean.UserBean;
import Encode.StrBinaryTurn;
import Extract.WaterMarkExtracterInternet;
import Sort.GetId_ModinrowsForInternet;
import Sort.SortTheRowInBase;

public class TestTheInter {


    public static void main(String[] args) {
    	UserBean userBean =new UserBean();
    	userBean.setKey("5126");
    	//userBean.setMarkContent("111000");
    	userBean.setN(96);
    	//userBean.setN(3);
    	WaterMarkExtracterInternet waterMarkExtracterInternet=new WaterMarkExtracterInternet();
    	GetId_ModinrowsForInternet getId_ModinrowsForInternet=new GetId_ModinrowsForInternet();
    	SortTheRowInBase sortTheRowInBase =new SortTheRowInBase();
    	System.out.print(StrBinaryTurn.test6(waterMarkExtracterInternet.extractWaterMark(sortTheRowInBase.SortAscend(getId_ModinrowsForInternet.GetIdAndModOfEveryRows(userBean)))));
    }


}
