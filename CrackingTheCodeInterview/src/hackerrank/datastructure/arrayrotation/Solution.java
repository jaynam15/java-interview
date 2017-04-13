package hackerrank.datastructure.arrayrotation;

/*
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform). 
The second line contains  space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:

Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Array Length:");
		int n = in.nextInt();
		System.out.println("Enter Left Shift:");
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		/*
		int[] b = simpleLeftRotation(a, n, k);
		System.out.println(Arrays.toString(b));
		*/
		
		int [] b = leftRotation(a, n, k);
		System.out.println(Arrays.toString(b));
	}

	private static int[] leftRotation(int[] a, int size, int start) {
		int [] b = new int[size];
		int mid = start;
		for (int i = 0; i < size; i++){
			if (i < mid){
				int iVal = a[i];
				int midVal = a[mid];
				a[i] = midVal;
				a[mid] = iVal;
			}
			
			if (mid < size-1){
				mid++;
			}
		}
		
		
		return a;
	}

	/**
	 * this is by using the Array Collection to split the array into multiple sub-range.
	 * @param a
	 * @param n
	 * @param k
	 * @return
	 */
	private static int[] simpleLeftRotation(int[] a, int n, int k) {

		int[] part1 = Arrays.copyOfRange(a, k, n);
		int[] part2 = Arrays.copyOfRange(a, 0, k);
		int[] b = new int[part1.length + part2.length];

		for (int i = 0; i < part1.length; i++) {
			b[i] = part1[i];
		}

		int part1Len = part1.length;
		for (int i = 0; i < part2.length; i++) {
			b[part1Len + i] = part2[i];
		}

		return b;
	}
}
