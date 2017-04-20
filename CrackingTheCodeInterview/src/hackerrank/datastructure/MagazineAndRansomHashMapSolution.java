package hackerrank.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MagazineAndRansomHashMapSolution {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        System.out.println(isValidRansomNote(magazine, ransom));
    }

	private static String isValidRansomNote(String[] magazine, String[] ransom) {
		boolean isValid = true;
		
		Set <String> magazineMap = new HashSet<String>();
		magazineMap.addAll(Arrays.asList(magazine));
		
		for (String word: ransom){
			if (!magazineMap.contains(word)){
				isValid = false;
				break;
			}
		}
		
		if (isValid){
			return "Yes";
		}
		else{
			return "No";
		}
	}
}
