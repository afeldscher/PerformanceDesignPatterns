package com.aff39;

// Adam Feldscher
// 10/9/2019
// I699
// Prime number test
// references: https://www.geeksforgeeks.org/c-program-to-check-whether-a-number-is-prime-or-not/
// Their algorithm actually is incorrect, because they do sqrt(n) and /2. Need to just do 1. Use 10 as example.

// The purpose of this program is to demonstrate run times using a prime finding algorithm.
// This is NOT an optimal implementation for finding primes, however we are trying to compare
// run times using the same algorithm so it will not matter.

// TODO:
// C!!!!

import java.io.IOException;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        int max_prime = 5000000; // Correct up through 1013
        int num_primes_found = 0;
        int max_iter = 20;

        System.out.println("iter, ns, sec, primes found");

        for (int iter = 0; iter < max_iter; iter++) {
//            try {
//                Thread.sleep(100);
//                System.in.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            long start_time = System.nanoTime();

            for (int n = 2; n <= max_prime; n++) {
                //This will get floored. Its ok, because if the integer above the sqrt is a divisor,
                // the other integer divisor would have had to have been below the sqrt
                int max_divisor = (int) sqrt(n);
                boolean is_prime = true;

                for (int i = 2; i <= max_divisor; i++) {
                    if (n % i == 0) {
                        is_prime = false;
                        break;
                    }
                }

                if (is_prime) {
                    // System.out.println(n);
                    num_primes_found++;
                }
            }
            long end_time = System.nanoTime();
            System.out.println(iter + ", " + (end_time - start_time) + ", " + (end_time - start_time) / 1e9 + ", " + num_primes_found);

            num_primes_found = 0;
        }

    }
}
