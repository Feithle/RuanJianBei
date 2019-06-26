package Extract;

import DaoForInternetDataBase.CellGeter;

public class WaterMarkGetterForInternet {

	/**
	 * @param id
	 * @param hash
	 * @return
	 * TODO same as WaterMarkGetter
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

