#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, W, k;
    cin >> n >> W >> k;
    vector<pair<int, int>> a(n);
    for (int i = 0; i < n; ++i) cin >> a[i].first >> a[i].second;

    int ans = 0;
    vector<int> idx(n);
    iota(idx.begin(), idx.end(), 0);

    function<int(vector<bool>&)> solve = [&](vector<bool>& free) {
        vector<int> dp(W + 1, 0);
        for (int i = 0; i < n; ++i) {
            if (free[i]) continue;
            int wi = a[i].first, vi = a[i].second;
            for (int j = W; j >= wi; --j)
                dp[j] = max(dp[j], dp[j - wi] + vi);
        }
        int fsum = 0;
        for (int i = 0; i < n; ++i)
            if (free[i]) fsum += a[i].second;
        return dp[W] + fsum;
    };

    if (k == 0) {
        vector<bool> none(n, false);
        ans = solve(none);
    } else {
        vector<int> c(n);
        iota(c.begin(), c.end(), 0);
        vector<bool> used(n, false);
        function<void(int, int)> dfs = [&](int i, int cnt) {
            if (cnt == k) {
                ans = max(ans, solve(used));
                return;
            }
            if (i == n) return;
            used[i] = true;
            dfs(i + 1, cnt + 1);
            used[i] = false;
            dfs(i + 1, cnt);
        };
        dfs(0, 0);
    }

    cout << ans << '\n';
}
