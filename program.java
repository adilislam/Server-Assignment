import java.util.*;

public class program {  
   public static void main(String[] args) {
      Map<String, Integer> servers = new TreeMap<String, Integer>();
      for (String arg: args) {
         try {
            String server = arg.substring(0, arg.indexOf(":"));
            int value = Integer.parseInt(arg.substring(arg.indexOf(":") + 1));
            servers.put(server, value);
         } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input: " + arg);
         }  
      }
      System.out.print(chooseServer(servers));      
   }
   
   // Takes in a map of server names to size values and returns an int representing
   // the sum of the size values
   public static int getSum(Map<String, Integer> servers) {
      int sum = 0;
      for (String server: servers.keySet()) {
         sum += servers.get(server);  
      } 
      return sum;
   }
  
   // Takes in a map of server names to size values and returns a String representing
   // a randomly chosen server, based on the weighting of the size values  
   public static String chooseServer(Map<String, Integer> servers) {
      int n = (int)(Math.random() * getSum(servers) + 1);
      for (String server: servers.keySet()) {
         int size = servers.get(server);
         if (size >= n) {
            return server;
         } else {
            n -= size;
         }
      }
      return null;
   }   
}