package Sort;

import Bean.RowInBase;

import java.util.ArrayList;
import java.util.Collections;

/**
 * bubble sort
 * return the current order using RowInBase
 */
public class SortTheRowInBase {
    public ArrayList<RowInBase> SortAscend(ArrayList<RowInBase> rowInBases) {
        for (int i = 0; i < rowInBases.size(); i++) {//bubble sort method
            for (int j = i; j < rowInBases.size(); j++) {
                if (rowInBases.get(i).getMod() >= rowInBases.get(j).getMod()) {
                	 Collections.swap(rowInBases, i, j);
                }
            }
        }
        System.out.println("sorted the lines！");
        return rowInBases;
    }
}