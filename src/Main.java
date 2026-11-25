
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Task 1: Replace Negative Numbers with Zero ===");
        task1();

        System.out.println("\n=== Task 2: Second Largest Distinct Number ===");
        task2();

        System.out.println("\n=== Task 3: Remove an Element by Index ===");
        task3(scanner);

        System.out.println("\n=== Task 4: Find Duplicate Numbers ===");
        task4();

        scanner.close();
    }


    // хелпер
    static void printArray(int[] a, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // Task 1
    static void task1() {
        int[] a = {2, -5, 3, -7, 0, 1, -9, 8, 7, -2};

        System.out.print("Original: ");
        printArray(a, a.length);

        int replacements = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                a[i] = 0;
                replacements++;
            }
        }

        System.out.print("Modified: ");
        printArray(a, a.length);
        System.out.println("Replacements: " + replacements);
    }

    // Task 2
    static void task2() {
        int[][] tests = {
                {10, 25, 8, 30, 15, 30},
                {5, 5, 5, 5, 5, 5}
        };

        for (int t = 0; t < tests.length; t++) {
            int[] a = tests[t];

            System.out.print("Array: ");
            printArray(a, a.length);

            int largest = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > largest) {
                    largest = a[i];
                }
            }

            boolean found = false;
            int second = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != largest && (!found || a[i] > second)) {
                    second = a[i];
                    found = true;
                }
            }

            if (found) {
                System.out.println("Largest: " + largest);
                System.out.println("Second largest: " + second);
            } else {
                System.out.println("No second largest distinct number.");
            }
            System.out.println();
        }
    }

    // Task 3
    static void task3(Scanner scanner) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.print("Original: ");
        printArray(numbers, numbers.length);

        System.out.print("Enter index to remove: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= numbers.length) {
            System.out.println("Invalid index. Valid range: 0 to " + (numbers.length - 1));
            return;
        }

        for (int i = index; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }

        System.out.print("Updated: ");
        printArray(numbers, numbers.length - 1);
    }

    // Task 4
    static void task4() {
        int[] a = {5, 4, 2, 4, 1, 7, 1, 6, 8, 3};

        System.out.print("Array: ");
        printArray(a, a.length);

        boolean hasDuplicates = false;
        System.out.print("Duplicate numbers: ");

        for (int i = 0; i < a.length; i++) {
            boolean alreadyChecked = false;
            for (int j = 0; j < i; j++) {
                if (a[j] == a[i]) {
                    alreadyChecked = true;
                    break;
                }
            }
            if (alreadyChecked) {
                continue;
            }

            int count = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == a[i]) {
                    count++;
                }
            }

            if (count > 1) {
                System.out.print(a[i] + " ");
                hasDuplicates = true;
            }
        }

        if (!hasDuplicates) {
            System.out.print("No duplicates found.");
        }
        System.out.println();
    }
}
