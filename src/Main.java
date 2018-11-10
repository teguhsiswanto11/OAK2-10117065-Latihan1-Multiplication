import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        int y;
        char lagi;
        Scanner scn1 = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
        Scanner scn3 = new Scanner(System.in);
        Operation operation = new Operation();


        do {

            System.out.println("===== MULTIPLICATION (Positif) ======");
            System.out.print("Multiplicated (M) : ");
            x = scn1.nextInt();
            System.out.print("Multiplier   (Q)  : ");
            y = scn2.nextInt();
            System.out.println("\nRESULT = " + operation.multiplication(x, y));

            System.out.print("\nMau mencoba lagi (y/n) ? : ");
            lagi = scn3.next().charAt(0);
            System.out.println();
        } while (lagi == 'y');

    }
}
