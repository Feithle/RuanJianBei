package HashUtil;

import Bean.UserBean;

import java.util.Random;

public class HashMap {
    public static int Hash(int key, int Primary) {

    	MyOwnHash myOwnHash=new MyOwnHash();
    	myOwnHash.initHashTable();//
    	myOwnHash.insert(key,Primary);
        return myOwnHash.find(key,Primary);
    }
}
