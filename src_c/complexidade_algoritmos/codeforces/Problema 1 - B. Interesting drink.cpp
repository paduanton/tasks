#include <iostream>
#include <vector>
#include <algorithm>
 
using namespace std;
 
int main() {
    int n; // número de bebidas
    cin >> n;
 
    vector<int> v(n); // preços das bebidas
    for (int i = 0; i < n; ++i) {
        cin >> v[i];
    }
 
    sort(v.begin(), v.end()); // ordena os preços
 
    int q; // número de consultas (dias)
    cin >> q;
 
    while (q--) {
        int x; // dinheiro disponível no dia
        cin >> x;
 
        // upper_bound retorna o primeiro valor > x
        // a posição dele é o número de bebidas com preço ≤ x
        int res = upper_bound(v.begin(), v.end(), x) - v.begin();
        cout << res << endl;
    }
 
    return 0;
}