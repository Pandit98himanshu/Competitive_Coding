#include <stdio.h>

int deleteAndCut(int n, int m, int uv[][2]) {
    int a = 0, b = 0, s = 0;
    int visited[n + 1];
    // we’ve not visited any node yet
    for(int i = 0; i <= n; i++) {
        visited[i] = 0;
    }
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < m; j++) {
            if(i == j) {
                continue;
            }
            else {
                // find whether all 
            }
        }
    }
}

int main () {
    //inputs
    int n, m;
    scanf("%d %d", &n, &m);
    int uv[m][2];
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < 2; j++) {
            scanf("%d", &uv[i][j]);
        }
    }
    deleteAndCut(n, m, uv);
    return 0;
}