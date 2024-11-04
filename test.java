import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number = 50; // Random number
        int guess = 0;
    
        while (guess != number) {
            guess = scanner.nextInt();
            if (guess < number) {
                System.out.println("Too low!");
            }else if(guess > number){
                System.out.println("Too high!");
            }else {
                System.out.println("Correct!");
            }
        }
        scanner.close();
    }
}







