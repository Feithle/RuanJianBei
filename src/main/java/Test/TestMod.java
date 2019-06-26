package Test;

import java.util.ArrayList;

import Bean.RowInBase;
import Bean.UserBean;
import Sort.GetId_Modinrows;
import Sort.SortTheRowInBase;

public class TestMod {
	public static void main(String[] args) {
		 ArrayList<RowInBase> rowInbases = new ArrayList<RowInBase>();
		UserBean userBean =new UserBean();
		userBean.setKey("124");
		userBean.setMarkContent("18");
		userBean.setN(2);
		GetId_Modinrows getId_Modinrows=new GetId_Modinrows();
		SortTheRowInBase sortTheRowInBase =new SortTheRowInBase();
		rowInbases=sortTheRowInBase.SortAscend(getId_Modinrows.GetIdAndModOfEveryRows(userBean));
	
		int count11 = 0;
		for (RowInBase rowInBase:rowInbases ) {
			System.out.println(rowInBase.getId()+" "+ rowInBase.getMod());
			if(rowInBase.getMod()==0)
			{
				count11++;
			}
		
			System.out.println("***********************"+count11);
			//
		}
//        MyMap<String, String> mm = new MyMap<String, String>();
//        Long aBeginTime = System.currentTimeMillis();//记录BeginTime
//        for (int i = 0; i < 1000000; i++) {
//            mm.put("" + i, "" + i * 100);
//        }
//        Long aEndTime = System.currentTimeMillis();//记录EndTime
//        System.out.println("insert time-->" + (aEndTime - aBeginTime));
//
//        Long lBeginTime = System.currentTimeMillis();//记录BeginTime
//        mm.get("" + 100000);
//        Long lEndTime = System.currentTimeMillis();//记录EndTime
//        System.out.println("seach time--->" + (lEndTime - lBeginTime));
    }
}
