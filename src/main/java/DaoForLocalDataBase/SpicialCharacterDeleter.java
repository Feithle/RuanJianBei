package DaoForLocalDataBase;

public class SpicialCharacterDeleter {
	public static void DeleteTheSpicialCharacter_dot() {
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
			System.out.println("hadeling the"+i+"th line");
			count++;
		}
	}
	System.out.println("delete the char compeletly");
	}
	public static void main(String[] args) {
		SpicialCharacterDeleter.DeleteTheSpicialCharacter_dot();
	}
}
