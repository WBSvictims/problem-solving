#include <queue>
#include <set>
#include <cstdio>
using namespace std;

struct Building {
    int l, r, h;
    bool operator < (const Building &o) const {
        return h < o.h;
    }
    Building(int l, int r, int h){
        this->l = l;
        this->r = r;
        this->h = h;
    }
};

class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        vector<vector<int>> ret;
        
        priority_queue<Building> pq;
        set<int> locs;
        for(const vector<int> &b: buildings) locs.insert(b[0]), locs.insert(b[1]);
        int cur = 0;
        
        for(const int &loc: locs) {
            for(;cur < buildings.size() && buildings[cur][0] <= loc; cur++)
                pq.emplace(buildings[cur][0], buildings[cur][1], buildings[cur][2]);

            while(!pq.empty() && pq.top().r <= loc) pq.pop();
            
            vector<int> skyline = {loc, 0};
            if(!pq.empty()) skyline[1] = pq.top().h;
            if(ret.empty() || ret.back()[1] != skyline[1]) {
                ret.push_back(skyline);
            }
        }
        
        return ret;
    }
};