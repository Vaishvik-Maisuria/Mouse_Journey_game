
import java.util.Scanner;
public class Mouse_journey {
	public static void main (String[] arg) {
		
		Scanner input = new Scanner(System.in);											
		int[][] Cage;																	
		int rows, colume, cats, temprows, tempcolume;
		
		//rows and columns
		System.out.println("Enter number of rows:");										
		rows = input.nextInt();
		System.out.println("Enter number of columns:");
		colume = input.nextInt();
		
		//arrays (grid)
		if ((rows == 1 && colume == 1) || (rows == 0) || (colume == 0)) {
			System.out.println("Invalid input!");
		}
		else {
			Cage = new int[rows][colume];														
		
			for (int x = 0; x < rows; x ++) {
				for (int y = 0; y < colume; y++) {
					Cage[x][y] = 1;
				}
			}
			
			//number of cages of cats
			System.out.println("Enter number of cat cages:");							
			cats = input.nextInt();
			System.out.println("Enter location of every cat cage:");
			
			//row of cat cage
			for (int x = 1; x <= cats; x++){
				System.out.println("Row:");												
				temprows = input.nextInt();
				while ((temprows == 0) || (temprows > rows)) {
					System.out.println("Invalid input! Please try again.");
					System.out.println("Row:");
					temprows = input.nextInt();
				}
				
				//column of cat cage
				System.out.println("Column:");											
				tempcolume = input.nextInt();
				while ((tempcolume == 0) || (tempcolume > colume)) {
					System.out.println("Invalid input! Please try again.");
					System.out.println("Column:");
					tempcolume = input.nextInt();
				}
				//cat cages = 0
				Cage[temprows-1][tempcolume-1] = 0;												
				
				//cat cage in column 1 or row 1 cannot be 0
				if (temprows == 1) {														
					for (int y = tempcolume; y < colume; y ++) {
						Cage[temprows-1][y] = 0;
					}
				}
				if (tempcolume == 1) {
					for (int y = temprows; y < rows; y ++) {
						Cage[y][tempcolume-1] = 0;
					}
				} 
			
			}
			//Calculations 
			for (int x = 1; x < rows; x ++) {												
				for (int y = 1; y < colume; y++) {
					if (Cage[x][y] != 0) {
						Cage[x][y] = Cage[x-1][y] + Cage[x][y-1];
					}
				}
			}
		
			//printing																	
			for (int print = 0; print < rows; print ++) {
				for (int print2 = 0; print2 < colume; print2 ++) {
					System.out.print(Cage[print][print2] + "\t");
				}
				System.out.println("");
			}
			
			
			System.out.print("Possible routes:" + Cage[rows-1][colume-1]);
		
			input.close();
		}
	}
}
