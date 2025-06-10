#include <bits/stdc++.h>
using namespace std;

using ll = long long;
const ll inf = 1e18;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;
    vector<vector<pair<int, int>>> g(n + 1);
    for (int i = 0; i < m; ++i) {
        int u, v, w;
        cin >> u >> v >> w;
        g[u].emplace_back(v, w);
        g[v].emplace_back(u, w);
    }

    vector<ll> d(n + 1, inf);
    vector<int> p(n + 1, -1);
    d[1] = 0;
    priority_queue<pair<ll, int>, vector<pair<ll, int>>, greater<>> q;
    q.emplace(0, 1);

    while (!q.empty()) {
        auto [du, u] = q.top(); q.pop();
        if (du > d[u]) continue;
        for (auto &[v, w] : g[u]) {
            if (d[v] > d[u] + w) {
                d[v] = d[u] + w;
                p[v] = u;
                q.emplace(d[v], v);
            }
        }
    }

    if (d[n] == inf) {
        cout << -1 << '\n';
        return 0;
    }

    vector<int> path;
    for (int v = n; v != -1; v = p[v])
        path.push_back(v);
    reverse(path.begin(), path.end());
    for (int x : path) cout << x << ' ';
    cout << '\n';
}
