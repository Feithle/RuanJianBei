package HashUtil;

import Bean.HashTable;
import DaoForLocalDataBase.CountRowsDao;

import java.util.ArrayList;

/**
 *
 */
public class MyOwnHash {
    public static int items =CountRowsDao.GetTheRowsOfTheTable();
    public static ArrayList<HashTable> hashTables = new ArrayList<HashTable>();

    /**
     * @param hashTables
     */
    public void initHashTable() {
        for (int i = 0; i < items; i++) {
            HashTable hashTable = new HashTable();
            hashTable.setIsNull(1);
            hashTables.add(hashTable);
        }
    }

    public void insert(int key, int id) {
        int address = (key * id) % items;//getHashAddressOfEveryRow( key, id, items);
        if (hashTables.get(address).getIsNull() == 1) {//no conflict
            hashTables.get(address).setData(id);
            hashTables.get(address).setIsNull(0);
        } else {//handle the conflict
            while (hashTables.get(address).getIsNull() == 0 && address < items) {
                address++;
            }
            try {
                if (address == items) {
                    System.out.println("Hash memory out");//Hash memory  out
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashTables.get(address).setData(id);
            hashTables.get(address).setIsNull(0);
        }
    }
    public int find(int key, int id) {
        int address = (key * id) % items;
        while (!(hashTables.get(address).getIsNull() == 0 && hashTables.get(address).getData() == id && address < items)) {
            address++;
        }
        if (address == items) {
            address = -1;
        }
        return address;
    }
    public void cleanhashtable() {
    	hashTables.clear();
    }
}
