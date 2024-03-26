class SegTreeNode {
    int start;
    int end;
    int val;
    SegTreeNode left;
    SegTreeNode right;

    public SegTreeNode() {
        this.start = 0;
        this.end = 0;
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public SegTreeNode buildTree(int start, int end, int val) {
        this.start = start;
        this.end = end;
        if (start == end) {
            this.left = null;
            this.right = null;
            this.val = val;
            return this;
        } else {
            int mid = (start + end) / 2;
            this.left = new SegTreeNode();
            this.left.buildTree(start, mid, val);
            this.right = new SegTreeNode();
            this.right.buildTree(mid + 1, end, val);
            this.val = Math.max(this.left.val, this.right.val); // replace with your own logic
            return this;
        }
    }

    public SegTreeNode buildTree(int start, int end, int[] vals) {
        this.start = start;
        this.end = end;
        if (start == end) {
            this.val = vals[start];
            this.left = null;
            this.right = null;
            return this;
        } else {
            int mid = (start + end) / 2;
            this.left = new SegTreeNode();
            this.left.buildTree(start, mid, vals);
            this.right = new SegTreeNode();
            this.right.buildTree(mid + 1, end, vals);
            this.val = Math.max(this.left.val, this.right.val); // replace with your own logic
            return this;
        }
    }

    void updateIndex(int ind, int val) {
        if (this.start == this.end && this.end == ind) {
            this.val = val;
            return;
        }
        int mid = (this.start + this.end) / 2;
        if (ind <= mid) {
            this.left.updateIndex(ind, val);
        } else {
            this.right.updateIndex(ind, val);
        }
        this.val = Math.max(this.left.val, this.right.val); // replace with your own logic
        return;
    }

    int queryRange(int start, int end) {
        if (this.start == start && this.end == end) {
            return this.val;
        }
        if (this.start == this.end) {
            return this.val;
        }
        int mid = (this.start + this.end) / 2;
        if (end <= mid) {
            return this.left.queryRange(start, end);
        } else if (start > mid) {
            return this.right.queryRange(start, end);
        } else {
            return Math.max(this.left.queryRange(start, mid), this.right.queryRange(mid + 1, end)); // replace with your own logic
        }
    }

    void printTree () {
        System.out.format("range [%d, %d], val = %d\n", this.start, this.end, this.val);
        if (this.left != null) this.left.printTree();
        if (this.right != null) this.right.printTree();
    }
}

// replace with your own solution
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int max = 0;
        int ret = 0;
        for (int i : nums) max = Math.max(i, max);
        SegTreeNode root = new SegTreeNode();
        root.buildTree(0, max, 0);
        for (int n : nums) {
            int len = root.queryRange(Math.max(0, n - k), Math.max(0, n - 1));
            root.updateIndex(n, len + 1);
            ret = Math.max(ret, len + 1);
        }
        return ret;
    }
}
