import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        int y;
        Scanner scn1 = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
        Operation operation = new Operation();

        System.out.println("===== MULTIPLICATION (Positif) ======");
        System.out.print("Multiplicated (M) : ");
        x = scn1.nextInt();
        System.out.print("Multiplier   (Q)  : ");
        y = scn2.nextInt();

        System.out.println("\nRESULT = "+operation.multiplication(x,y));

    }
}
