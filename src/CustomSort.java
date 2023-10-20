import java.util.Scanner;

public class CustomSort {

    public static void Selection(int sarr[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Okay, you selected Selection. Now;");
        System.out.println("Press 1 for ASC, Press 0 for DESC");
        Integer input1 = scanner.nextInt();
        //scanner.nextLine();

        if(input1 == 1){
            int n = sarr.length;		  
	        for (int i = 0; i < n; i++){	        	
	        	int min = i;	            
	        	for (int j = i+1; j < n; j++)
	                if (sarr[j] < sarr[min]) //alternate for less method
	                    min = j;
	            
	            int temp2 = sarr[min];
	            sarr[min] = sarr[i];
	            sarr[i] = temp2;
	        }
            System.out.println("Ascending Order:");
            for(int i=0; i<sarr.length; i++)
                System.out.print(sarr[i] + " ");
            System.out.println();
        }else{
            int n = sarr.length;		  
	        for (int i = 0; i < n; i++){	        	
	        	int min = i;	            
	        	for (int j = i+1; j < n; j++)
	                if (sarr[j] < sarr[min]) //alternate for less method
	                    min = j;
	            
	            int temp2 = sarr[min];
	            sarr[min] = sarr[i];
	            sarr[i] = temp2;
            }
            System.out.println("Descending Order:");
            for(int i=n-1; i>=0; i--)
                System.out.print(sarr[i] + " ");
            System.out.println();
        }
        //scanner.close();	  
    }
    
    // Custom Bubble Sort for ascending order

    public static void Bubble(int[] arr){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Okay, you selected Bubble. Now;");
        System.out.println("Press 1 for ASC, Press 0 for DESC");

        Integer input2 = scanner.nextInt();
        scanner.nextLine();

        if(input2 == 1){
            Ascending(arr);
            System.out.println("Ascending Order: ");
            printArray(arr);
        }else{
            Descending(arr);
            System.out.println("Descending Order: ");
            printArray(arr);
        }
        //scanner.close();
    }

    private static void Ascending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Custom Bubble Sort for descending order
    private static void Descending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // Utility method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=0;
        
        

        while (n>=0) {
            
            System.out.println("Enter integers seperated by space that you want to sort.");

            // we can write imputs how many as we want
            String sinput = scanner.nextLine();
            String[] numStrings = sinput.split(" ");
            int[] arr = new int[numStrings.length];
            try {
                for(int i=0; i<numStrings.length; i++)
                    arr[i] = Integer.parseInt(numStrings[i]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter valid integers seperated by one space.");
            }

            // after the inputs we must select our sort type
            System.out.println("Press 1 for Selection, Press 0 for Buble Sort");
            Integer input3 = scanner.nextInt();
            scanner.nextLine();
            if(input3==1)   Selection(arr);
            else            Bubble(arr);

            // when sorting is done, ask for again or not
            System.out.println("Would you like terminate? (y/n)");
            String input4 = scanner.next();
            if(input4.equalsIgnoreCase("y")){
                     n++; 
                     main(args);
            }
            else if(input4.equalsIgnoreCase("n"))   n=-1;
            //else System.err.println("Invalid input. Please enter 'y' or 'n' " ); //break;
        }
        scanner.close();
    }
}