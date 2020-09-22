#include <stdio.h>
#include <stdbool.h>
#define ll long long int
#define ld long double

bool isInt(ll a, ll b) {
    ld p = (a * 1.0) / b;
    ll q = (ll) p;
    
    return p == q;
}
bool isInteger(ld a) {
    ll b = (ll) a;
    
    return b == a;
}
void solve(ll p, ll q, ll r, ll a, ll b, ll c) {
    ll x = 0, y = 0, z = 0;
    ld _x = 0, _y = 0, _z = 0;
    ld g, h, i, j, k, l;
    
    // calculating differences
    x = a - p;
    y = b - q;
    z = c - r;
    // calculating quotient
    if (p != 0) {   _x = a * 1.0 / p;   }
    if (q != 0) {   _y = b * 1.0 / q;   }
    if (r != 0) {   _z = c * 1.0 / r;   }
    
    // possibilities to reach target in 0 step
    if (p == a && q == b && r == c) {
        printf("0\n");
        return;
    }
    // possibilities to reach target in 1 step
    if (x == y == z || _x == _y == _z) {
        printf("1\n");
        return;
    }
    if ((x == y && z == 0) || (y == z && x == 0) || (x == z && y == 0)) {
        printf("1\n");
        return;
    }
    if ((x == 0 && y == 0) || (y == 0 && z == 0) || (x == 0 && z == 0)) {
        printf("1\n");
        return;
    }
    if ((_x == _y && _z == 1) || (_y == _z && _x == 1) || (_x == _z && _y == 1)) {
        printf("1\n");
        return;
    }
    if ((_x == 1 && _y == 1) || (_y == 1 && _z == 1) || (_x == 1 && _z == 1)) {
        printf("1\n");
        return;
    }
    // possibilities to reach target in 2 steps
    else {
        g = ((a - b) * 1.0) / (p - q);
        h = (((p * b) - (q * a)) * 1.0 / (a - b));
        
        i = ((b - c) * 1.0) / (q - r);
        j = (((q * c) - (r * b)) * 1.0 / (b - c));
        
        k = ((a - c) * 1.0) / (p - r);
        l = (((p * c) - (r * a)) * 1.0 / (a - c));
        
        // 1st add by d then multiply d’ to tuple
        if ((isInteger(g) && isInteger(h)) && (isInteger(i) && isInteger(j)) && (isInteger(k) && isInteger(l))) {
            printf("2\n");
            return;
        }
        // 1st multiply by d then add d’ to tuple
        if (isInteger(g) && isInteger(i) && isInteger(k)) {
            printf("2\n");
            return;
        }
        
        // 1st multiply by d to all of them, then add d’ to p’ & q’
        /////////////////////      OR      /////////////////////
        // 1st multiply by d to p & q, then add d’ to all of them
        if (isInteger(g)) {
            if (isInt(c, r) || ((r + (ll) g) == c)) {
                printf("2\n");
                return;
            }
        }
        // 1st multiply by d to all of them, then add d’ to q’ & r’
        /////////////////////      OR      /////////////////////
        // 1st multiply by d to q & r, then add d’ to all of them
        if (isInteger(i)) {
            if (isInt(a, p) || ((p + (ll) i) == a)) {
                printf("2\n");
                return;
            }
        }
        // 1st multiply by d to all of them, then add d’ to p’ & r’
        /////////////////////      OR      /////////////////////
        // 1st multiply by d to p & r, then add d’ to all of them
        if (isInteger(k)) {
            if (isInt(b, q) || ((q + (ll) k) == b)) {
                printf("2\n");
                return;
            }
        }
        
        // 1st add d to p & q, then multiply d’ to all of them
        /////////////////////      OR      /////////////////////
        // 1st add d to all of them, then multiply d’ to p’ & q’
        if (isInteger(g) && isInteger(h)) {
            if (isInt(c, r) || ((r + (ll) g) == c)) {
                printf("2\n");
                return;
            }
        }
        // 1st add d to q & r, then multiply d’ to all of them
        /////////////////////      OR      /////////////////////
        // 1st add d to all of them, then multiply d’ to q’ & r’
        if (isInteger(i) && isInteger(j)) {
            if (isInt(a, p) || ((p + (ll) i) == a)) {
                printf("2\n");
                return;
            }
        }
        // 1st add d to p & r, then multiply d’ to all of them
        /////////////////////      OR      /////////////////////
        // 1st add d to all of them, then multiply d’ to p’ & r’
        if (isInteger(k) && isInteger(l)) {
            if (isInt(b, q) || ((q + (ll) k) == b)) {
                printf("2\n");
                return;
            }
        }
        
        // 1st add d to p & q, then add d’ to q & r
        ///////////////      OR      ///////////////
        // 1st add d to q & r, then add d’ to p & q
        if (p + r - q == a + c - b) {
            printf("2\n");
            return;
        }
        // 1st add d to p & r, then add d’ to q & r
        ///////////////      OR      ///////////////
        // 1st add d to q & r, then add d’ to p & r
        if (p + q - r == a + b - c) {
            printf("2\n");
            return;
        }
        // 1st add d to p & q, then add d’ to p & r
        ///////////////      OR      ///////////////
        // 1st add d to p & r, then add d’ to p & q
        if (p - q - r == a - b - c) {
            printf("2\n");
            return;
        }
        
        // 1st add d to p & q, then multiply d’ to q’ & r
        g = - q + (b * r * 1.0) / c;
        if (isInteger(g) && ((p + g) == a)) {
            printf("2\n");
            return;
        }
        // 1st add d to q & r, then multiply d’ to p & q’
        g = - q + (b * p * 1.0) / a;
        if (isInteger(g) && ((r + g) == c)) {
            printf("2\n");
            return;
        }
        // 1st add d to p & r, then multiply d’ to q & r’
        g = - r + (c * q * 1.0) / b;
        if (isInteger(g) && ((p + g) == a)) {
            printf("2\n");
            return;
        }
        // 1st add d to q & r, then multiply d’ to p & r’
        g = - r + (c * p * 1.0) / a;
        if (isInteger(g) && ((q + g) == b)) {
            printf("2\n");
            return;
        }
        // 1st add d to p & q, then multiply d’ to p’ & r
        g = - p + (a * r * 1.0) / c;
        if (isInteger(g) && ((q + g) == b)) {
            printf("2\n");
            return;
        }
        // 1st add d to p & r, then multiply d’ to p’ & q
        g = - p + (a * q * 1.0) / b;
        if (isInteger(g) && ((r + g) == c)) {
            printf("2\n");
            return;
        }
        // add d to p, q or q, r or p, r and
        // either add or multiply d’ to r or p or q respectively
        if ((x == y) || (y == z) || (x == z)) {
        printf("2\n");
        return;
        }
        // multiply d to p, q or q, r or p, r and
        // either add or multiply d’ to r or p or q respectively
        if ((_x == _y) || (_y == _z) || (_x == _z)) {
            printf("2\n");
            return;
        }
        // otherwise answer is 3
        else {
            printf("3\n");
            return;
        }
    }
}
int main(void) {
    int t;
    scanf("%d", &t);
    while (t--) {
        ll p, q, r, a, b, c;
        scanf("%lld %lld %lld", &p, &q, &r);
        scanf("%lld %lld %lld", &a, &b, &c);
        
        solve(p, q, r, a, b, c);
    }
    return 0;
}