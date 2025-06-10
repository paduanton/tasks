#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, a, b;
    cin >> n;
    vector<tuple<int, int, int>> g(n); // {pessoas, valor, índice}
    for (int i = 0; i < n; ++i) {
        cin >> a >> b;
        g[i] = {a, b, i + 1};
    }

    cin >> m;
    vector<pair<int, int>> t(m); // {capacidade, índice}
    for (int i = 0; i < m; ++i) {
        cin >> a;
        t[i] = {a, i + 1};
    }

    sort(g.begin(), g.end(), [](auto &x, auto &y) {
        return get<1>(x) > get<1>(y); // maior valor primeiro
    });

    sort(t.begin(), t.end()); // mesas por capacidade crescente
    vector<bool> used(m, false);
    vector<pair<int, int>> out;
    int tot = 0;

    for (auto &[p, v, idg] : g) {
        for (int i = 0; i < m; ++i) {
            if (!used[i] && t[i].first >= p) {
                used[i] = true;
                tot += v;
                out.emplace_back(idg, t[i].second);
                break;
            }
        }
    }

    cout << out.size() << ' ' << tot << '\n';
    for (auto &[x, y] : out)
        cout << x << ' ' << y << '\n';

    return 0;
}
