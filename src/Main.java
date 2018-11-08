import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        int y;
        Scanner scn1 = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
        Operation operation = new Operation();

        System.out.println("===== MULTIPLICATION (Positif) ======");
        System.out.print("Masukkan Nilai 1 : ");
        x = scn1.nextInt();
        System.out.print("Masukkan Nilai 2 : ");
        y = scn2.nextInt();

        System.out.println("\n\nC     A       Q       M      info   Count");
        System.out.println("-----------------------------------------");
        System.out.println("\nRESULT = "+operation.multiplication(x,y));

    }
}
