import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test Calcolatrice Scrum ===");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Inserisci il primo numero: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Inserisci il secondo numero: ");
        double num2 = scanner.nextDouble();
        
        double somma = num1 + num2;
        System.out.println("Risultato somma: " + somma);
        System.out.println("Ambiente Java configurato correttamente!");
        
        scanner.close();
    }
}