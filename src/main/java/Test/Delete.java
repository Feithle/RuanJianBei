package Test;

import DaoForLocalDataBase.CellGeter;
import DaoForLocalDataBase.CellUpdater;
import DaoForLocalDataBase.CountRowsDao;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CellGeter cellGeter = new CellGeter();
		CellUpdater cellUpdater = new CellUpdater();
		CountRowsDao countRowsDao= new CountRowsDao();
		int count = 0;//替换次数
		for(int i = 1; i<= countRowsDao.GetTheRowsOfTheTable();i++)
		{
			String str = cellGeter.GetCell(i, "content");
			if(str.contains("'"))
			{
				str = str.replaceAll("'", "");
				cellUpdater.updateCell(i, "content", str);
				System.out.println(i);
				count++;
			}

		}
		System.out.println("共替换了"+count+"次");
		
	}

}
