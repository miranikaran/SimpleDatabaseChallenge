import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class SimpleDatabaseChallenge {
   
  public static void main(String[] args) {
		
      Database d = new Database();
      Scanner kbd;
      kbd = new Scanner(System.in);
      System.out.println("Enter 1 for interactive mode");
      System.out.println("Enter 2 to use a file");
      int mode = kbd.nextInt();
      //check mode of interaction
       if(mode == 2)
       {
    	   System.out.println("Enter file path");
    	   String path = "";
    	   path = kbd.nextLine();
    	   path = kbd.nextLine();
    	   try{
    		   File file = new File(path);
    		   kbd = new Scanner(file);
    	   }
    	   catch(FileNotFoundException f){
    		   System.out.println("File not found at the given path");
    		   System.exit(0);
    	   }
    	   
       }
    	   
      while(kbd.hasNext()){
    	 String command = kbd.next();
    	 command = command.toLowerCase();
 	 
    	 switch (command){
    	 
    	 case "end":System.exit(0);
    	            break;
    	 case "begin": d.begin();
    	               break;
    	 case "set": String key = kbd.next();
    	             int value = kbd.nextInt();
    	             d.set(key, value);
    	             break;
    	 case "get": String variable = kbd.next();
    	             Integer val = d.get(variable);
    	             if(val != Integer.MAX_VALUE && val != Integer.MIN_VALUE)
    	            	 System.out.println(val);
    	             else System.out.println("NULL");
    	             break;
    	 case "commit":d.commit();
    	               break;
    	 case "numequalto":value = kbd.nextInt();
    		               d.numequalto(value); 
    		               break;
    	 case "unset": String var = kbd.next();
    	               d.unset(var);
    	               break;
    	 case "rollback":d.rollback();
    	                 break;
    	 }
    	 
    		 
      }
      
      kbd.close();
      
      
    
  }

	
	
}
