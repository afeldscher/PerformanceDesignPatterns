#include <math.h>
#include "primefinder.h"



PrimeFinder::PrimeFinder(int max_prime) {
    _max_prime = max_prime;
}

int PrimeFinder::find_primes() {
    int num_primes_found = 0;
    int n;
    for (n = 2; n <= _max_prime; n++) {
        // int max_divisor = (int) sqrt(n);
        bool is_prime = true;

        int i;
        for (i = 2; i <= (int) sqrt(n); i++) {
            if (n % i == 0) {
                is_prime = false;
                break;
            }
        }

        if (is_prime) {
            num_primes_found++;
        }
    }
    return num_primes_found;
}
