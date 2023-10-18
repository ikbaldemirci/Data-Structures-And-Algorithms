import java.util.Scanner;

public class CustomSort {
    
    // Custom Bubble Sort for ascending order
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
    
    public static void Selection(int sarr[]) {
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
        System.out.print("Enter integers separated by space that you want sort: ");
                
        String input = scanner.nextLine();
        String[] numStrings = input.split(" ");
        int[] arr = new int[numStrings.length];

        try {
            for (int i = 0; i < numStrings.length; i++) {
                arr[i] = Integer.parseInt(numStrings[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers separated by space.");
            //return;
        }
        
        
        
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Press 1 for selection, press 0 for ASC&DESC");
        
        Integer input2 = scanner2.nextInt();
        if (input2 == 1) {
        	Selection(arr);
        	System.out.println("Selection Sort:");
        	printArray(arr);
        }
        else if(input2==0) {
     // Sorting in ascending order
        Ascending(arr);
        System.out.println("Ascending Order:");
        printArray(arr);

        // Sorting in descending order
        Descending(arr);
        System.out.println("Descending Order:");
        printArray(arr);
        
        
    }
        scanner.close();
        scanner2.close();    
}
}
