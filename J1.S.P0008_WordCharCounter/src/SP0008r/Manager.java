/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0008r;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author HI
 */
public class Manager {
    public HashMap<String, Integer> wordCounter = new HashMap<>();
    public HashMap<Character, Integer> charCounter = new HashMap<>();
    
    //methods
    public void countString(String s){
        char[] cs = s.toCharArray();
        for (char ch : cs) {
            if(Character.isSpaceChar(ch)) 
                continue;
            if(!charCounter.containsKey(ch))
                charCounter.put(ch, 1);
            else
                charCounter.put(ch, ((int)charCounter.get(ch)) + 1);
        }
        
        StringTokenizer t = new StringTokenizer(s);
        while(t.hasMoreTokens()){
            String w = t.nextToken();
            if(!wordCounter.containsKey(w))
                wordCounter.put(w, 1);
            else
                wordCounter.put(w, ((int)wordCounter.get(w)) + 1);
        }
    }
    
    public void display(){
        System.out.println("Words:");
        System.out.println(wordCounter);
        System.out.println("Characters:");
        System.out.println(charCounter);
    }
}
