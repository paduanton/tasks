#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    vector<pair<int, int>> v(n);
    for (int i = 0; i < n; ++i) cin >> v[i].first >> v[i].second;
    sort(v.begin(), v.end());

    map<int, int> dp;
    int res = 0;

    for (int i = 0; i < n; ++i) {
        int x = v[i].first;
        int r = x - v[i].second - 1;
        auto it = dp.upper_bound(r);
        if (it != dp.begin()) --it;
        int d = (it == dp.end() || it->first > r ? 0 : it->second) + 1;
        dp[x] = d;
        res = max(res, d);
    }

    cout << n - res << '\n';
}
