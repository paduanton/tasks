#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k, d;
    cin >> n >> k >> d;

    vector<int> p(k);
    for (int i = 0; i < k; ++i) {
        cin >> p[i];
        --p[i];
    }

    vector<vector<pair<int, int>>> g(n);
    vector<pair<int, int>> e(n - 1);

    for (int i = 0; i < n - 1; ++i) {
        int a, b;
        cin >> a >> b;
        --a; --b;
        g[a].emplace_back(b, i);
        g[b].emplace_back(a, i);
        e[i] = {a, b};
    }

    vector<bool> vis(n, false), use(n - 1, false);
    queue<int> q;

    for (int x : p) {
        vis[x] = true;
        q.push(x);
    }

    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (auto [v, id] : g[u]) {
            if (!vis[v]) {
                vis[v] = true;
                use[id] = true;
                q.push(v);
            }
        }
    }

    vector<int> out;
    for (int i = 0; i < n - 1; ++i)
        if (!use[i])
            out.push_back(i + 1);

    cout << out.size() << '\n';
    for (int x : out)
        cout << x << ' ';
    cout << '\n';

    return 0;
}
