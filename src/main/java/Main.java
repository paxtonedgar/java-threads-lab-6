import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            PrimeLogger prime = new PrimeLogger(num);
            executor.execute(prime);
            // submit tasks to your executor
        }
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    public void isPrime(int num){
        IntStream.rangeClosed(2, num/2).filter(i -> num%i!=0).findAny().ifPresentOrElse((i)-> System.out.println(num), () -> System.out.println("Not Prime"));
    }
    @Override
    public void run() {
        isPrime(num);
    }
}