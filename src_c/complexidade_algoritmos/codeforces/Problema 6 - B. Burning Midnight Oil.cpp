#include <bits/stdc++.h>
using namespace std;

bool ok(int x, int n, int k) {
    long long s = 0, p = 1, v = x;
    while (v > 0) {
        s += v;
        p *= k;
        v = x / p;
    }
    return s >= n;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    int l = 1, r = n, m;
    while (l < r) {
        m = (l + r) / 2;
        if (ok(m, n, k))
            r = m;
        else
            l = m + 1;
    }

    cout << l << '\n';
    return 0;
}
