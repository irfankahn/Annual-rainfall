import java.util.Scanner;
/* Irfanullah Khan
  CSCI 111
  Programming Assignment 9
 */
public class AnnualRainFall {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);   // Import scanner to get user input
        System.out.print("Please enter the number of years : "); // Asking user for input
        int years = sc.nextInt();
        while (years <= 0) {                  // Boolean value calculation using while loop
            System.out.println("Invalid amount. Try again."); // out put for negative number or zero for number of years
            System.out.print("Please enter the number of years : "); // Asking the user to re-enter a positive value.
            years = sc.nextInt();
        }

        int rainfall[][] = new int[years][12]; // Using a two-dimensional array
        int yearlyRainFall[] = new int[years];
        for (int i = 0; i < years; i++) {      // Using a For loop
            for (int j = 0; j < 12; j++) {
                System.out.printf("Please enter the rainfall amount for month %d, year %d:", j + 1, i + 1);
                rainfall[i][j] = sc.nextInt();
                if (rainfall[i][j] < 0) {
                    System.out.println("Invalid amount. Try again.");
                    j--;
                }
            }
            System.out.println("");

        }
        int totalRainFall = 0, mostRainMonth = 0, leastRain = 100,  mostRain = 0,mostRainYear = 0, leastRainMonth = 0,
                leastRainYear = 0;
        for (int i = 0; i < years; i++) {
            yearlyRainFall[i] = 0;
            for (int j = 0; j < 12; j++) {
                yearlyRainFall[i] += rainfall[i][j];
                if (rainfall[i][j] > mostRain) {
                    mostRain = rainfall[i][j];
                    mostRainMonth = j + 1;
                    mostRainYear = i + 1;
                }
                if (rainfall[i][j] < leastRain) {
                    leastRain = rainfall[i][j];
                    leastRainMonth = j + 1;
                    leastRainYear = i + 1;
                }
            }
            System.out.printf("The total rainfall for year %d is %d inches.\n", i + 1, yearlyRainFall[i]);
            totalRainFall += yearlyRainFall[i];
        }
        System.out.println("The total rainfall is " + totalRainFall + " inches\n");
        for (int i = 0; i < years; i++) {
            System.out.printf("The average monthly rainfall for year %d is %.2f inches.\n", i + 1,
                    (yearlyRainFall[i] * 1.0) / 12.0);
        }
        System.out.printf("The average monthly rainfall is %.2f.\n", (totalRainFall * 1.0) / (12 * years * 1.0));
        System.out.printf("\nThe month with the most rain was month %d, year %d\n.", mostRainMonth, mostRainYear);
        System.out.printf("The month with the least rain was month %d, year %d\n.", leastRainMonth, leastRainYear);

    }
}
