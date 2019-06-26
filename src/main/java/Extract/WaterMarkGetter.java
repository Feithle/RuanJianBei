package Extract;

import DaoForLocalDataBase.*;;

public class WaterMarkGetter {
	
	/**
	 * @param id
	 * @param hash
	 * @return code
	 * TODO id and hash can help us to locate the cell in some line 
	 * using the same way that embed code but the process
	 */
	public static String getWaterMark(int id,int hash) {
		CellGeter cellGeter=new CellGeter();
		String oriStr=cellGeter.GetCell(id, "content");
		String code="";
		if(oriStr.charAt(hash%oriStr.length())=='\n') {
			code="1";
		}
		if(oriStr.charAt(hash%oriStr.length())=='\r') {
			code="0";
		}
		return code;
	}
	
}

