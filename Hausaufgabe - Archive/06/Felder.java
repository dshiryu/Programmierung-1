public class Felder {
    
    public static String[] boomBang(int start, int end) {
    	int arraySize = end - start;
    	int compare = 0;
    	
    	if (arraySize < 2) {
    		arraySize = 2;
    	}
    	
    	String[] sequence = new String[arraySize];
    	
    	
	    	for (int i = 0; i < arraySize; i++) {
	    		if (start == end) {
	    			compare = start;
	    		} else {
	    		compare = start + i;
	    		}
	    		if (compare % 3 == 0 && compare % 5 == 0) {
	    			sequence [i] = String.valueOf("BoomBang");
				} else if (compare % 5 == 0) {
	    			sequence [i] = String.valueOf("Bang");
	    		} else if (compare % 3 == 0) {
	    			sequence [i] = String.valueOf("Boom");
	    		} else {
	    			sequence [i] = String.valueOf(compare);
	    		}
	    	}
    	
        return sequence;
    }

    public static void tausche(int[] arr, int i, int j) {
    	int temp = arr[i]; 
    	arr[i] = arr[j];
    	arr[j] = temp;
    	
    }

    public static void alleTauschen(int[] arr) {
    	int temp1 = 0;
    	for (int i = 0; i < arr.length - 1; i++) { // if I use -2 as the aufgabe says, the bubble sort doesn't work in VertauschN(), it felt wrong so I changed
    		if (arr[i] > arr[i+1]) {
    			temp1 = arr[i];
    			arr[i] = arr[i+1];
    			arr[i+1] = temp1;
    		}
    	}
    	
    }

    public static void vertauscheN(int[] arr) {
    	alleTauschen(arr);
    	int temp = 0;
    	
    		for (int j = 0; j < arr.length - 1; j++) {
    			alleTauschen(arr);
    			if (arr[j] > arr[j+1]) {
        			temp = arr[j];
        			arr[j] = arr[j+1];
        			arr[j+1] = temp;
    			}
    		}
		
    	
    	
    	
    	
    }

    public static int klumpen(int[] nums) {
    	int count = 0;

    	for(int i = 0; i < nums.length -1; i++) {
    		
	    	if (nums[i] == nums[i+1]) {	
		    		
	    		for(int j = 1; j < nums.length - 1; j++) {
	    			if (nums[j] == nums[j+1]) {
	    				i++;
	    			} else {
	    				j = nums.length;
	    			}
	    			i++;
	    		}
	    		
	    		count++;
    		} 
    	}
    	return count;
    }

    /////////////
    // VORGABE //
    /////////////
    
    private static void print(int[] arr) {
        for (int i=0; i<arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void print(String[] arr) {
        for (int i=0; i<arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        int[] c = {};
        int[] d = {8,9,10,11,-1};
        int[] f = {5,5,2,2,2,3};
        int[] g = {0, 0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2};

        System.out.println("\nAufgabe 1");
        print(boomBang(1,16));
        print(boomBang(15,15));
        print(boomBang(30,31));

        System.out.println("\nAufgabe 2");       
        tausche(d, 2, 3);
        print(d);
        alleTauschen(f);
        print(f);
        vertauscheN(g);
        print(g);

        System.out.println("\nAufgabe 3");       
        // Ergebnis: 5 2 0 0
        // the result changes to 3 1 0 0 after the changes made by the methods
        System.out.println(klumpen(g) + " " +klumpen(f) + " " +
                           klumpen(c) + " " + klumpen(d));

    }


}
