#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n;
    vector<int> a(n);
    for (int &v : a) cin >> v;

    long long s = 0;
    int c = 0;
    priority_queue<int, vector<int>, greater<>> pq;

    for (int i = 0; i < n; ++i) {
        s += a[i];
        pq.push(a[i]);
        ++c;

        while (s < 0 && !pq.empty()) {
            s -= pq.top();
            pq.pop();
            --c;
        }
    }

    cout << c << '\n';
    return 0;
}
