package Embed;

import java.util.ArrayList;

import Bean.RowInBase;
import DaoForLocalDataBase.SpicialCharacterDeleter;

public class WaterMarkEmbeder {
	/**
	 * @param rowInBases
	 * @param wm_content
	 * sorted the lines with ASC MOD
	 * insert the char
	 */
	public static void embedWaterMark(ArrayList<RowInBase> rowInBases,String wm_content) {
		SpicialCharacterDeleter.DeleteTheSpicialCharacter_dot();
		int order=0;
		for(int i=0;i<rowInBases.size();i++) {
			if(i==rowInBases.size()-1)
			{
				break;
			}
			if(rowInBases.get(i).getMod()==rowInBases.get(i+1).getMod()) {
				WaterMarkInserter.insertWaterMark(order,wm_content,rowInBases.get(i).getId(),rowInBases.get(i).getHashvalue());//插入水印
			}
			if(rowInBases.get(i).getMod()!=rowInBases.get(i+1).getMod()) {
				System.out.println("finished inserting char into "+i+"th group" );
				order++;
			}
		}
		System.out.println("finish embed");
	}
}
