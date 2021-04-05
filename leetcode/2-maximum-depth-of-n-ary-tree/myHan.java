/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int walk(Node cur, int step) {
        if(cur == null) return step;
        int ret = step + 1;
        for(int i = 0; i < cur.children.size(); i++) {
            ret = Math.max(ret, walk(cur.children.get(i), step+1));
        }
        return ret;
    }
    public int maxDepth(Node root) {
        return walk(root, 0);
    }
}