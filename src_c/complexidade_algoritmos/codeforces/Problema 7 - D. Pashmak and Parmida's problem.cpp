#include <bits/stdc++.h>
using namespace std;

const int N = 1e6 + 5;
int a[N], l[N], r[N];

struct BIT {
    int n;
    vector<int> t;
    BIT(int sz) : n(sz), t(sz + 2, 0) {}
    void add(int i, int v) {
        while (i <= n) {
            t[i] += v;
            i += i & -i;
        }
    }
    int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += t[i];
            i -= i & -i;
        }
        return s;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    map<int, int> m;
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        m[a[i]];
    }

    int id = 1;
    for (auto &p : m) p.second = id++;

    for (int i = 0; i < n; ++i) a[i] = m[a[i]];

    unordered_map<int, int> f;
    for (int i = n - 1; i >= 0; --i) {
        r[i] = ++f[a[i]];
    }

    f.clear();
    BIT bit(n);
    long long ans = 0;
    for (int i = 0; i < n; ++i) {
        l[i] = ++f[a[i]];
    }

    for (int i = n - 1; i >= 0; --i) {
        ans += bit.sum(l[i] - 1);
        bit.add(r[i], 1);
    }

    cout << ans << '\n';
    return 0;
}
