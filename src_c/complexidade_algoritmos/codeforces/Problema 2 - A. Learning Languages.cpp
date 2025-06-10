#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

const int MAX = 205;
vector<int> g[MAX];
bool vis[MAX];

void bfs(int u) {
    queue<int> q;
    q.push(u);
    vis[u] = true;

    while (!q.empty()) {
        int v = q.front();
        q.pop();

        for (int w : g[v]) {
            if (!vis[w]) {
                vis[w] = true;
                q.push(w);
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    bool any = false;

    for (int i = 1; i <= n; ++i) {
        int k;
        cin >> k;
        if (k > 0) any = true;

        for (int j = 0; j < k; ++j) {
            int l;
            cin >> l;
            l += n; // desloca índice da linguagem
            g[i].push_back(l);
            g[l].push_back(i);
        }
    }

    int comp = 0;
    memset(vis, false, sizeof(vis));

    for (int i = 1; i <= n; ++i) {
        if (!vis[i]) {
            bfs(i);
            comp++;
        }
    }

    cout << (any ? comp - 1 : n) << endl;

    return 0;
}