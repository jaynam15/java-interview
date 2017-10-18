public class Algorithm{
	

	/**
	* Worst Case: O(n^2) is efficiency because the number of swap we perform
	* Best Case: O(n)
	* Avenrate Case: O(n^2)
	* Comparing element with only element next to it.. and continue the process until there is nothing to swap
	*/
	public static T[] bubbleSort(T[] array){
		boolean isSwapped = true;
		if (array.length <= 1){
			return array;
		}

		for (int i = 0; i < array.length && isSwapped; i++){
			// isSwapped -- > this is to short circuit the loop.
			isSwapped = false;

			for (int j = i; j < i; j++){
				if ( array[i] > array[j]){
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					isSwapped = true;
				}
			}
		}

	}


	/**
	* Insertion Sort
	* Worst Case: O(n^2)
	* Almost sorted : O(n)
	* Avenrate Case: O(n^2)
	* Praticle use: 8 - 12 elements 
	* If Swap used O(nlon(n)), if Shifting used : O(n^2)
	* Assume the first element is already sorted. and rest of the array is not.
	* Take each new element and in-place that element by comparing to entire array.
	*
	**/
	public static T[] insertionSort(T[] arr) {
      int i, j;
      T newValue;
      for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > newValue) {
                  arr[j] = arr[j - 1];
                  j--;
            }
            arr[j] = newValue;
      	}
	}

	/**
	* MergeSort
	* Worst Case: O(n long n)
	* Best Case: O (n log n)
	* Average Case: O( n log n)
	* Worst Case Space Complexity: O( n )
	* It always runs in O(nlog(n)), time, but requires O(n), space.
	* 
	**/
	public int[] mergeSort(int array[]){
		// if the array has more than 1 element, we need to split it and merge the sorted halves
		if(array.length > 1){
			// number of elements in sub-array 1
			// if odd, sub-array 1 has the smaller half of the elements
			// e.g. if 7 elements total, sub-array 1 will have 3, and sub-array 2 will have 4
			int elementsInA1 = array.length / 2;
			// we initialize the length of sub-array 2 to
			// equal the total length minus the length of sub-array 1
			int elementsInA2 = array.length - elementsInA1;
					// declare and initialize the two arrays once we've determined their sizes
			int arr1[] = new int[elementsInA1];
			int arr2[] = new int[elementsInA2];
			// copy the first part of 'array' into 'arr1', causing arr1 to become full
			for(int i = 0; i < elementsInA1; i++)
				arr1[i] = array[i];
			// copy the remaining elements of 'array' into 'arr2', causing arr2 to become full
			for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
				arr2[i - elementsInA1] = array[i];
			// recursively call mergeSort on each of the two sub-arrays that we've just created
			// note: when mergeSort returns, arr1 and arr2 will both be sorted!
			// it's not magic, the merging is done below, that's how mergesort works :)
			arr1 = mergeSort(arr1);
			arr2 = mergeSort(arr2);
			
			// the three variables below are indexes that we'll need for merging
			// [i] stores the index of the main array. it will be used to let us
			// know where to place the smallest element from the two sub-arrays.
			// [j] stores the index of which element from arr1 is currently being compared
			// [k] stores the index of which element from arr2 is currently being compared
			int i = 0, j = 0, k = 0;
			// the below loop will run until one of the sub-arrays becomes empty
			// in my implementation, it means until the index equals the length of the sub-array
			while(arr1.length != j && arr2.length != k){
				// if the current element of arr1 is less than current element of arr2
				if(arr1[j] < arr2[k]){
					// copy the current element of arr1 into the final array
					array[i] = arr1[j];
					// increase the index of the final array to avoid replacing the element
					// which we've just added
					i++;
					// increase the index of arr1 to avoid comparing the element
					// which we've just added
					j++;
				}
				// if the current element of arr2 is less than current element of arr1
				else{
					// copy the current element of arr2 into the final array
					array[i] = arr2[k];
					// increase the index of the final array to avoid replacing the element
					// which we've just added
					i++;
					// increase the index of arr2 to avoid comparing the element
					// which we've just added
					k++;
				}
			}
			// at this point, one of the sub-arrays has been exhausted and there are no more
			// elements in it to compare. this means that all the elements in the remaining
			// array are the highest (and sorted), so it's safe to copy them all into the
			// final array.
			while(arr1.length != j){
				array[i] = arr1[j];
				i++;
				j++;
			}
			while(arr2.length != k){
				array[i] = arr2[k];
				i++;
				k++;
			}
		}
		// return the sorted array to the caller of the function
		return array;
	}
	
	
	public static T[] mergeSort(T[] arr){
		int size = arr.length;		
		
		if (size > 1){
			int midPoint = size/2;
			T[] partOne = arr.split(0, midPoint);
			T[] partTwo = arr.split(midPoint, size);
			
			mergeSort(partOne);
			mergeSort(partTwo);
			
			T[] newArr = new T[size];
			int index = 0, i = 0, j = 0;
			for (i = 0, j = 0; i < partOne.length && j < partTwo.length && index < size; ){
				if (partOne[i]  < partTwo[j]){
					newArr[index] = partOne[i];
					i++;
				}else{
					newArr[index] = partTwo[j];
					j++;
				}
				index++;
			}
			
			
			while (partOne.length != i){
				newArr[index] = partOne[i];
				i++;
				index++;
			}
			
			while(partTwo.length != j){
				newArr[index] = partTwo[j];
				j++;
				index++;
			}
			return newArr;
		}
		return arr;
	}
	

	int partition(int arr[], int left, int right){
		  int i = left, j = right;
		  int tmp;
		  int pivot = arr[(left + right) / 2];
		 
		  while (i <= j) {
				while (arr[i] < pivot)
					  i++;
				while (arr[j] > pivot)
					  j--;
				if (i <= j) {
					  tmp = arr[i];
					  arr[i] = arr[j];
					  arr[j] = tmp;
					  i++;
					  j--;
				}
		  };
		 
		  return i;
	}
	 
	/**
	* Quicksort
	* Its the most suitable sorting algorithem
	* It use the piviot method. select the piviot and compare the elements with the piviot and swap the 
	* elements.
	* Best case:  O(n log n)
	* Worst Case: O(n^2)
	*
	**/ 
	void quickSort(int arr[], int left, int right) {
		  int index = partition(arr, left, right);
		  if (left < index - 1)
				quickSort(arr, left, index - 1);
		  if (index < right)
				quickSort(arr, index, right);
	}
	
	
	/**
	* Linear Search
	* Worst Case: n
	* Best Case: 1
	* Average Case: (n+1)/2
	* Loop on the array and compare each element.
	*
	**/
	public static int lenearSearch(T[] arr, T val){
		for (int i = 0; i < arr.length; i++){
			if ( val == arr[i]){
				return i;
			}			
		}
		return -1;
	}
	
	/**
	* Binary Search
	* Worst Case: O ( log n)
	* Best Case: O(1)
	* Average Case: O( long n)
	* Log2(n) + 1 --> Log n base 2 plus 1
	* binary search require the array to be sorted. 
	* We compare the value with the mid point of the array, and check if its the greater / less than the 
	* value. and this way it will elminate half of the array. By continueing the process, we will find the 
	* searched value.
	**/
	public static int binarySearch(T[] array, T value){
		
		int midPoint = array.length / 2;
		
		if (array[midPoint] == value){
			return midPoint;
		}
		if (array[midPoint] > value){
			T[] subPart = array.split(0, midPoint);
			binarySearch(subPart, value);
		}
		if ( array[midPoint] < value){
			T[] subPart = array.split(midPoint, array.length);
			binarySearch(subPart, value);
		}
		return -1;
	}

	
	/**
	* selection sort
	* Selection sort keep the index of the smallest element by comparing it with each entry.
	* It will swap the value with the first/second and so on.. 
	* Worst Case: O(n^2)
	* Average: O(n ^2 )
	* Best Case: O( n ^ 2)
	**/
	 public static void selectionSort(int arr[]) {
        int N=arr.length;
        for(int i=0;i<N;i++) {
            int small=arr[i];
            int pos=i;
            for(int j= i + 1; j < N ; j++) {
                if(arr[j] < small) {
                    small = arr[j];
                    pos = j;
                }
            }
            int temp=arr[pos];
            arr[pos]=arr[i];
            arr[i]=temp;
            System.out.println("After pass "+(i+1));
            //Printing array after pass
            System.out.println(Arrays.toString(arr));
        }
    }
	
	
	

}