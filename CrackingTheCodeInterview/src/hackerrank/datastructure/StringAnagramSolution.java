package hackerrank.datastructure;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringAnagramSolution {

    public static int numberNeeded(String first, String second) {
    	int totalNumber = 0;
    	
    	List<Character> firstSet = toList(first);
    	List<Character> secondSet = toList(second);
    	
    	Set<Character> fSet = new HashSet<Character>(firstSet);
    	Set<Character> sSet = new HashSet<Character>(secondSet);
    	
    	firstSet.retainAll(secondSet);
    	int common = firstSet.size();
    	int firstLen = first.toCharArray().length;
    	int totalChar = firstLen + secondSet.size();
    	
    	totalNumber = totalChar - 2*common;
    	/*
    	if (firstLen != secondSet.size()){
    		totalNumber = totalChar - common;
    	} 
    	else{
    		totalNumber  = totalChar - (2*common);
    	}
		*/
    	
    	if ( firstLen != fSet.size()){
    		totalNumber = totalNumber - (firstSet.size() - fSet.size());
    	}
    	
    	if (secondSet.size() != sSet.size()){
    		totalNumber = totalNumber - (secondSet.size() - sSet.size());
    	}
    	
    
        return Math.abs(totalNumber);
    }
    
    public static List<Character> toList(String str){
    	List<Character> list = new ArrayList<Character>();
    	char[] arr = str.toCharArray();
    	for (int i = 0; i < arr.length; i++){
    		list.add(arr[i]);
    	}
    	return list;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}