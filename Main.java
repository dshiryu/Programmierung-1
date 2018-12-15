import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//System.out.println(anagramm("Ampel", "Lampe"));
		spannbreite("spannbreite.txt");
		//ohne6Bis7("67.txt");	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean anagramm(String s1, String s2) {
		// converts to lower case AND to array
		char s1Array[] = s1.toLowerCase().toCharArray(); 
		char s2Array[] = s2.toLowerCase().toCharArray();
		// sort letters in alphabetical order 
		Arrays.sort(s1Array); 
		Arrays.sort(s2Array);
		// rebuilding a new empty string for each array
		// reason: doing s1.equal(s2) on the last step would return false with arrays
		String newS1 = "";
		String newS2 = "";
		// array s1 into string
		for (int i = 0; i < s1Array.length; i++) {
			newS1 += s1Array[i];
		}
		// array s2 into string
		for (int i = 0; i < s2Array.length; i++) {
			newS2 += s2Array[i];
		}
		if (newS1.equals(newS2)) return true;
		else return false;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void spannbreite(String datei) {
		int counter = 0;
		int arrayMaker = 0;
		int savedCounter = 0;
		int countOfSequenceOld = 0;
		int countOfSequenceNew = 0;
        int totalOfCountSequence = 0;
        
		//int[] numbers = new int[10000]; // int array
		String[] numbers = new String[10000]; // String array
		Scanner sc = null;
		File f = new File(datei);
		try {
			sc = new Scanner(f);
			// create an array of ints
			while (sc.hasNextLine()) {
				//numbers[arrayMaker] = Integer.parseInt(sc.nextLine()); // save to int array
				numbers[arrayMaker] = sc.nextLine(); // save to String array
			 	arrayMaker++;
			}
			
			
			
			
			for (int i = 0; i < numbers.length -1; i++) {
				int tamanho = String.valueOf(numbers[i]).length();
	            String checkCurrent = numbers[i]; // to show on Eclipse debugger
	            countOfSequenceOld = 0;
                for (int j = 0; j < tamanho-1; j++) {
                	for (int k = tamanho-1; k > 0; k--) {
			            if (numbers[i].charAt(j) == numbers[i].charAt(k)) {
			            	countOfSequenceNew = k-j+1;
			            	break;
			            } else {
			            	countOfSequenceNew = 1;
			            }
			        }
                	if (countOfSequenceNew > countOfSequenceOld) {
			            	countOfSequenceOld = countOfSequenceNew;
			            }
                }
                totalOfCountSequence += countOfSequenceOld; 
 			}
	                // olha aqui dentro do numero se se caracteriza por uma sequencia..
			 		// forma char array com o numero
			  	// checar a distancia dentro do numero atual
				 	// soma a largura ao total
				         // se a sequencia caracteriza uma largura.. 
		                // soma no final ao totalOfCountSequence
		            
		            
	        
			
			
			// turns the number of digits in each number into the array value itself 
			// e.g. 123456 becomes 5
			/*for (int i = 9999; i >= 0; i--) {
				numbers[i] = String.valueOf(numbers[i]).length();
			}*/
			
			
			
			// if the numbers are converted on their own distances, the result gives 8205, with them themselves become 9999 (!=) or 0 (==)
			/*for (int i = 0; i < 9999; i++) {
				if (numbers[i] == numbers[i+1]) {
					counter++;
				}
			}*/
			
			// takes the index number and compare it to the next, if != then counter ++ to show the distance
			// resets counter if the number is equal and store it
			/*for (int i = 0; i < 9999; i++) {
			//for (int i = 9999; i > 0; i--) { // alternative
				if (numbers[i] != numbers[i+1]) {
						for (int j = 1; j < 9999; j++) {
						counter++;
						if(numbers[i] != numbers[j] && counter > savedCounter) {
							savedCounter = counter;
							counter = 0;
						//}
					//}
				}
			}*/
			
			// trying to match 2 equals numbers and getting its sequence
			/*for (int i = 0; i < 9999; i++) {
				for (int j = 9999; j > 0; j--) {
					if (numbers[i] == numbers[j]) {
						counter = j - i;
					}
				}
			}*/
			
			// sum the digits -1 from all entries
			/*for (int i = 9999; i > 0; i--) {
				while(numbers[i] > 0) {
					numbers[i] = numbers[i]/10;
					digitCount++;
				}
				sum += digitCount - 1;
			}*/
			
			// finds the biggest number
			/*for (int i = 0; i < 9999; i++) {
				if(numbers[i] > numbers [i + 1] && i < 9998) {
					for (int j = 1; j < 9999; j++) {
						biggest = numbers[j];
					}
				}
			}*/
		System.out.println(totalOfCountSequence);
		} catch (FileNotFoundException e) {
			System.out.println(datei + " nicht vorhanden");
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void ohne6Bis7(String datei) {
		int counter = 0;
		int sum = 0;
		int[] numbers = new int[1000];
		Scanner sc = null;
		File f = new File(datei);
		try {
			sc = new Scanner(f);
			// creates int array from the list
			while (sc.hasNextLine()) {
				numbers[counter] = Integer.parseInt(sc.nextLine());
				counter++;
			}
			// sum all numbers, stop the sum when a 6 is found, resume after a 7 (not included)
			for (int i = 0; i < 1000; i++) {
				if (numbers[i] == 6) {
					for (int j = i; numbers[i] != 7; j++) {
						i++;
					}
				} else {
					sum += numbers[i];
				}
			}
		System.out.println(sum);
		} catch (FileNotFoundException e) {
			System.out.println(datei + " nicht vorhanden");
		}
	}
}
