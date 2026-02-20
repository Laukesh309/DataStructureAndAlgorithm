package GfGGraph.Medium;

public class DisjointSet {

    int find(int par[], int x) {

        if (par[x] == x) {
            return x;
        }
        return find(par, par[x]);
        // add code here.
    }

    void unionSet(int par[], int x, int z) {

        int xParent = find(par, x);
        int zParent = find(par, z);
        par[xParent] = xParent;
        // add code here.
    }

    public static void main(String[] args) {

    }

}
