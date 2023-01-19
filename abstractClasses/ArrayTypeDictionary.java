package DictionaryTypes.abstractClasses;

public abstract class ArrayTypeDictionary extends Dictionary {

     /* ARRAY SPECIFIC METHODS handin2*/
     /**
      * @param arr
      *@param finalIndexForSort
      *
      */
     public void insertionSort(String[] arr, int finalIndexForSort) {
        //todo
        String Arr [] = new String[finalIndexForSort];
        System.arraycopy(arr, 0, Arr, 0, finalIndexForSort);
        insertionSort(Arr);
        for(int i = 0; i < Arr.length; i++){
            arr[i] = Arr[i];
        }
    }
	public void insertionSort(String [] list){
		for(int i = 1; i < list.length; i++){
			/** Innsert list[i] into a sorted sublist list[0...i-1]
			 * list[0...i] is sorted*/
			String currentElement = list[i];
			int k;
			for(k = i - 1; k>= 0 && list[k].compareTo(currentElement) > 0; k--){
				list[k + 1] = list[k];
			}
			list[k+1] = currentElement;
		}
	}

    public void mergeSort(String[] arr, int finalIndexForSort) {
        //todo
        String Arr [] = new String[finalIndexForSort];
        System.arraycopy(arr, 0, Arr, 0, finalIndexForSort);
        mergeSort(Arr);
        for(int i = 0; i < Arr.length; i++){
            arr[i] = Arr[i];
        }
    }
    public  void mergeSort(String[] list){

        if(list.length > 1){
            //merge sort the first half
            String [] firsthalf = new String[list.length/2];
            System.arraycopy(list, 0, firsthalf, 0, list.length/2);
            mergeSort(firsthalf);

            //merge sort the second half
            int secondhalflength = list.length - list.length/2;
            String [] secondhalf = new String[secondhalflength];
            System.arraycopy(list, list.length/2, secondhalf, 0, secondhalflength);
            mergeSort(secondhalf);

            //merge firsthalf with secondhalf into list
            merge(firsthalf, secondhalf, list);

        }
    }
    /**Merge two sorted lists */
    public  void merge(String [] list1, String[] list2, String temp []){
        int current1 = 0; // current index in list1
        int current2 = 0; // current index in list2
        int current3 = 0; // current index in temp

        while(current1 < list1.length && current2 < list2.length){
            if(list1[current1].compareTo(list2[current2]) < 0){
                temp[current3++] = list1[current1++];
            }else{
                temp[current3++] = list2[current2++];
            }
        }

        while(current1 < list1.length){
            temp[current3++] = list1[current1++];
        }

        while(current2 < list2.length){
            temp[current3++] = list2[current2++];
        }
    }

    public void hybridSort(String[] arr, int size, int finalIndexForSort) {
        //todo
    }
    
}
