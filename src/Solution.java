import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		char[] c = {'a','a','b','b','c','c','c'};
		System.out.println(compress(c));
		System.out.println(c);
		
		
	}
	
	public static int compress(char[] chars) {
		HashMap<Character, Integer> s = new HashMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++){
            if (s.containsKey(chars[i])){
                int x = s.get(chars[i]);
                s.put(chars[i], x + 1);
            }
               
            else{  
                s.put(chars[i], 1);
            }  
        }
        ArrayList<Character> a = new ArrayList<Character>();
        int j = 0;
        for (int i = 0; i < chars.length; i++){
            if (s.containsKey(chars[i])){
                int x = s.get(chars[i]);
                a.add(chars[i]);
                chars[j] = chars[i];
                j++;
                if (x != 1){
                    String n = "" + x;
                    for (int o = 0; o < n.length(); o++){
                        
                        chars[j] = n.charAt(o);
                        j++;
                    }
                }
                s.remove(chars[i]);
            }
        }
        
        return a.size();
    }

}
