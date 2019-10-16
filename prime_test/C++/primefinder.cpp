#include <math.h>
#include "primefinder.h"



PrimeFinder::PrimeFinder(int max_prime) {
    _max_prime = max_prime;
}

bool PrimeFinder::is_prime(int n) {
    int max_divisor = (int) sqrt(n);
    for (int i = 2; i <= max_divisor; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}


int PrimeFinder::find_primes() {
    int num_primes_found = 0;
    int n;
    for (n = 2; n <= _max_prime; n++) {
        if (is_prime(n)) {
            num_primes_found++;
        }
    }
    return num_primes_found;
}
