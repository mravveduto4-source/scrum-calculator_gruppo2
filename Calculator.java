import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lastResult = 0.0;
        boolean keepRunning = true;

        System.out.println("=== Calcolatrice CLI - SPRINT 1 ===");
        System.out.println("Digita 'esci' per uscire, 'ans' per usare l'ultimo risultato.");

        while (keepRunning) {
            System.out.print("\nInserisci primo operando (numero, 'ans' o 'esci'): ");
            String input1 = scanner.next();

            // Controllo per uscire dal programma
            if (input1.equalsIgnoreCase("esci")) {
                keepRunning = false;
                break;
            }

            // Gestione del primo operando
            double op1 = 0.0;
            if (input1.equalsIgnoreCase("ans")) {
                op1 = lastResult;
            } else {
                try {
                    op1 = Double.parseDouble(input1);
                } catch (NumberFormatException e) {
                    System.out.println("Errore: Inserisci un numero valido.");
                    continue; // Ricomincia il ciclo
                }
            }

            System.out.print("Inserisci operatore (+, -, *, /): ");
            String operator = scanner.next();

            System.out.print("Inserisci secondo operando (numero o 'ans'): ");
            String input2 = scanner.next();
            
            // Gestione del secondo operando
            double op2 = 0.0;
            if (input2.equalsIgnoreCase("ans")) {
                op2 = lastResult;
            } else {
                try {
                    op2 = Double.parseDouble(input2);
                } catch (NumberFormatException e) {
                    System.out.println("Errore: Inserisci un numero valido.");
                    continue; // Ricomincia il ciclo
                }
            }

            // Calcolo del risultato
            double result = 0.0;
            boolean validOperation = true;

            switch (operator) {
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    if (op2 == 0) {
                        System.out.println("Errore: Divisione per zero non consentita.");
                        validOperation = false;
                    } else {
                        result = op1 / op2;
                    }
                    break;
                default:
                    System.out.println("Errore: Operatore non valido.");
                    validOperation = false;
            }

            // Se l'operazione è andata a buon fine, stampa e salva il risultato
            if (validOperation) {
                System.out.println("Risultato: " + result);
                lastResult = result;
            }
        }
        
        scanner.close();
        System.out.println("Calcolatrice terminata.");
    }
}