#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m);
    for (int &x : a) cin >> x;
    for (int &x : b) cin >> x;
    sort(a.begin(), a.end());
    for (int x : b) {
        int r = upper_bound(a.begin(), a.end(), x) - a.begin();
        cout << r << ' ';
    }
    cout << '\n';
}
