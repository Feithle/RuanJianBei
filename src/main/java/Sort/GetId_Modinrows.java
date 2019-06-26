package Sort;

import Bean.RowInBase;
import Bean.UserBean;
import DaoForLocalDataBase.CountRowsDao;
import DaoForLocalDataBase.IDValueGetter;
import HashUtil.MyOwnHash;

import java.util.ArrayList;

/*
get id and mod of every rows
return the list of RowInBase
todo:group the rows with the mod
*/
public class GetId_Modinrows {
    public ArrayList<RowInBase> GetIdAndModOfEveryRows(UserBean userBean) {
        ArrayList<RowInBase> rowInbases = new ArrayList<RowInBase>();
        int items = 0;
        items = CountRowsDao.GetTheRowsOfTheTable();
        MyOwnHash myoOwnHash=new MyOwnHash();
    	myoOwnHash.initHashTable();
        for (int i = 1; i <=items; i++)
        {
            RowInBase rowInBase = new RowInBase();
           int number=Integer.parseInt(IDValueGetter.GetId(i));
            myoOwnHash.insert(Integer.parseInt(userBean.getKey()),number);
            int hashvalue = myoOwnHash.find(Integer.parseInt(userBean.getKey()),number);//location is the location in a cell where the code insert into.
         
            rowInBase.setId(number);
            rowInBase.setMod(hashvalue % userBean.getN());
            rowInBase.setHashvalue(hashvalue);
            rowInbases.add(rowInBase);
        }
        myoOwnHash.cleanhashtable();
        System.out.println("computed the hash value!");
        return rowInbases;
    }
}