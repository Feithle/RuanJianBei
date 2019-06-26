package Test;

import Bean.HashTable;
import DaoForLocalDataBase.CountRowsDao;
import HashUtil.HashMap;
import HashUtil.MyOwnHash;
import java.util.ArrayList;
public class HashTest {
    public static void main(String[] args) {
    	MyOwnHash myoOwnHash=new MyOwnHash();
    	myoOwnHash.initHashTable();
        for (int i = 1; i < CountRowsDao.GetTheRowsOfTheTable()+1; i++) {
        	myoOwnHash.insert(124, i);
           System.out.println(i + " " +myoOwnHash.find(124, i));
        }
    }
}
