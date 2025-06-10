#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        int n, x;
        cin >> n;
        map<int, int> m;
        for (int i = 0; i < n; ++i) {
            cin >> x;
            m[x]++;
        }
        int d = m.size();
        if ((n - d) % 2 == 1) d--;
        cout << d << '\n';
    }

    return 0;
}
