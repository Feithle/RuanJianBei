package Sort;

import java.util.ArrayList;

import Bean.RowInBase;
import Bean.UserBean;
import DaoForInternetDataBase.CountRowsDao;
import DaoForInternetDataBase.IDValueGetter;
import HashUtil.MyOwnHashForInternet;

/*
get id and mod of every rows
return the list of RowInBase
todo:group the rows with the mod
*/
public class GetId_ModinrowsForInternet {
    public ArrayList<RowInBase> GetIdAndModOfEveryRows(UserBean userBean) {
        ArrayList<RowInBase> rowInbases = new ArrayList<RowInBase>();
        int items = 0;
        items = CountRowsDao.GetTheRowsOfTheTable();
        MyOwnHashForInternet myoOwnHashForInternet=new MyOwnHashForInternet();
        myoOwnHashForInternet.initHashTable();
        for (int i = 1; i <=items; i++)//
        {
            RowInBase rowInBase = new RowInBase();
           int number=Integer.parseInt(IDValueGetter.GetId(i));
           myoOwnHashForInternet.insert(Integer.parseInt(userBean.getKey()),number);
            int hashvalue = myoOwnHashForInternet.find(Integer.parseInt(userBean.getKey()),number);//location is the location in a cell where the code insert into.
            rowInBase.setId(number);
            rowInBase.setMod(hashvalue % userBean.getN());
            rowInBase.setHashvalue(hashvalue);
            rowInbases.add(rowInBase);
        }
        myoOwnHashForInternet.cleanhashtable();
        System.out.println("computed the hash value!");
        return rowInbases;
    }
}