public class ChristmasTree {
    public static void main(String[] args) {
        int rows = 7;
        int trunkheight = 4;

        for (int i = 1; i <= rows; i++) {
            for (int j = rows - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < trunkheight; i++){
            for (int j = 0; j < rows - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("***");
        }
    }
}