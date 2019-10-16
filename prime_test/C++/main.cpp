// Adam Feldscher
// 10/9/2019
// I699
// Prime number test
// references: https://www.geeksforgeeks.org/c-program-to-check-whether-a-number-is-prime-or-not/
// Their algorithm actually is incorrect, because they do sqrt(n) and /2. Need to just do 1. Use 10 as example.

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <stdbool.h>
#include <math.h>


int main(int argc, char *argv[]) {
    int max_prime = 10000; // Correct up through 1013
        int num_primes_found = 0;
        int max_iter = 40;

        printf("iter, ns, sec, primes found\n");

        for (int iter = 0; iter < max_iter; iter++) {
            struct timespec tstart={0,0}, tend={0,0};
            clock_gettime(CLOCK_MONOTONIC, &tstart);

            int n;
            for (n = 2; n <= max_prime; n++) {
                //This will get floored. Its ok, because if the integer above the sqrt is a divisor,
                // the other integer divisor would have had to have been below the sqrt
                int max_divisor = (int) sqrt(n);
                bool is_prime = true;

                int i;
                for (i = 2; i <= max_divisor; i++) {
                    if (n % i == 0) {
                        is_prime = false;
                        break;
                    }
                }

                if (is_prime) {
                    num_primes_found++;
                }
            }
            clock_gettime(CLOCK_MONOTONIC, &tend);

            long nano_sec = (tend.tv_nsec + tend.tv_sec * 1e9) - (tstart.tv_nsec + tstart.tv_sec * 1e9);
            double sec = (tend.tv_nsec / 1e9 + tend.tv_sec) - (tstart.tv_nsec / 1e9 + tstart.tv_sec);

            printf("%i, %li, %f, %i\n", iter, nano_sec, sec, num_primes_found);

            num_primes_found = 0;
        }
    return 0;
}
