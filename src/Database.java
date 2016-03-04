/* A database is a chain of transactions. Only the values of current transactions
 * are stored in a new transaction. By default, the database has one transaction.
 */


 import java.util.ArrayList;
 public class Database {
 private ArrayList < TransactionBlock > list;
 private int count;
 public Database() {
    list = new ArrayList < TransactionBlock > ();
    count = 0;
    TransactionBlock create = new TransactionBlock();
    create.toggle();
    list.add(create);
 }

 //returns the most recent value of key
 public Integer get(String key) {
    int temp = count;
    while (temp >= 0) {
        TransactionBlock current = list.get(temp);
        Integer value = current.get(key);
        switch (value) {
            case Integer.MIN_VALUE: temp--;                                    
                                    break;
            case Integer.MAX_VALUE: return Integer.MAX_VALUE;
            default:                return value;
         }
    }
  return Integer.MIN_VALUE;
 }

 /*creates a new transaction,adds it to the list of transactions and makes this transaction
   the current transaction*/
  public void begin() {
    TransactionBlock create = new TransactionBlock();
    create.toggle();
    list.add(create);
    count++;
 }

 public void numequalto(int value) {
      Integer val = getCount(value);
      if (val == null)
        System.out.println(0);
      else System.out.println(val);
 }
 
 public void set(String key, Integer value) {
    TransactionBlock current = list.get(count);
    if (current.isInProgress()) {
        Integer currentCount = getCount(value);
        if (currentCount != null)
            current.set(key, value, ++currentCount);
        else current.set(key, value, 1);
    } 
    else System.out.println("NO TRANSACTION");
 }

 //returns most recent count of variables mapped to value
 private Integer getCount(Integer value) {
    int temp = count;
    while (temp >= 0) {
        TransactionBlock current = list.get(temp);
        Integer ans = current.numequalto(value);
        if (ans != null)
            return ans;
        temp--; 
    }
     return null;
 }

 //unsets the value of key and updates the count map of current transaction
 public void unset(String key) {
    TransactionBlock current = list.get(count);
    if (current.isInProgress()) {
        Integer mostRecentValue = get(key); //most recent value of key
        Integer oldCount = getCount(mostRecentValue); //number of variables mapped to count of this key
        if (oldCount != null)
            current.unset(key, mostRecentValue, --oldCount);

    } 
    else System.out.println("NO TRANSACTION");
 }

 //deletes the current transaction
 public void rollback() {
    if (count >= 0) {
         if (list.get(count).isInProgress())
            list.remove(count--);
        else System.out.println("NO TRANSACTION");
    } 
    else System.out.println("NO TRANSACTION");
 }

 //closes all the open transactions
 public void commit() {
    for (int i = count; i >= 0; i--) {
        TransactionBlock current = list.get(i);
    if (current.isInProgress())
        current.toggle();
    }
 }
}