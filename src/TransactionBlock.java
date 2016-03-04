/*A transaction block has 2 maps. One for key-value mapping and the other for counting number
 * of variable set to a given value
 */

import java.util.HashMap;

public class TransactionBlock {
  private HashMap<String,Integer> map ;
  private HashMap<Integer,Integer> count ;
  private boolean isInProgress;
  public TransactionBlock(){
	  map = new HashMap<String,Integer>();
	  count = new HashMap<Integer,Integer>();
	  isInProgress = false;	  
  }

  // sets key to value and updates number of variables mapped to value
  public void set(String key, Integer value,Integer counterValue){
	  map.put(key, value);
	  count.put(value, counterValue);
  }  
  
  // returns count of variables mapped to value  
  public Integer numequalto(int value){
	  return count.get(value);
  }
 
  // maps key to null and updates count map
 public void unset(String key,Integer counterKey,Integer counterValue) {
	  map.put(key, null);
	  count.put(counterKey, counterValue);	  
  }
  
 /* returns the value of key if key is present
  * returns Integer.MAX_VALUE if unset operation was used for the key
  * returns Integer.MIN_VALUE if no operation has been used for the key*/
  public Integer get(String key){	  
	  if(map.containsKey(key))  
	  {
		  Integer value = map.get(key);
		  if(value == null)
			  return Integer.MAX_VALUE;
		  else return value;
	  }
	  else return Integer.MIN_VALUE;	  
  }  
 
  //returns the state of transaction
  public boolean isInProgress(){
	  return isInProgress;
  }

 //toggles the state of transaction
 public void toggle(){
	  isInProgress = !isInProgress;
  }
}
