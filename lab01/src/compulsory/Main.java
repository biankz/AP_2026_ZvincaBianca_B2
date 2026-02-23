package compulsory;

public class Main {
    static void main(String[] args) {
        System.out.println("Hello World!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        int result = n * 3;
        result += 0b10101;
        result += 0xFF;
        result *= 6;
        System.out.println(result);
        while (result > 9) {
            int sum = 0;
            while (result != 0) {
                sum += result % 10;
                result /= 10;
            }
            result = sum;
        }
        System.out.println(result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] + ".");
    }
}