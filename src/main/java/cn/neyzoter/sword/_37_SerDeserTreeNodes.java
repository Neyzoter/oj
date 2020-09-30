package cn.neyzoter.sword;

import java.util.LinkedList;
import java.util.Queue;

public class _37_SerDeserTreeNodes {
    public static void main(String[] args) {

    }
}

/**
 * 执行用时：
 * 16 ms
 * , 在所有 Java 提交中击败了
 * 87.23%
 * 的用户
 * 内存消耗：
 * 40.2 MB
 * , 在所有 Java 提交中击败了
 * 88.52%
 * 的用户
 */
class Codec2 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[null]";
        }
        Queue<TreeNode> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        que.add(root);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                if (tn == null) {
                    sb.append(",null");
                } else {
                    if (tn != root) {
                        sb.append(",");
                    }
                    sb.append(tn.val);
                    que.add(tn.left);
                    que.add(tn.right);
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] values = data.substring(1,data.length() - 1).split(",");
        if (values[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int nodeIdx = 1;
        while (nodeIdx < values.length) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                TreeNode ln = getTn(values[nodeIdx++]);
                tn.left = ln;
                TreeNode rn = getTn(values[nodeIdx++]);
                tn.right = rn;
                if (ln != null) {
                    que.add(ln);
                }
                if (rn != null) {
                    que.add(rn);
                }
            }
        }
        return root;
    }
    public TreeNode getTn(String val) {
        if (val.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(val));
        }
    }
}
/**
 * 部分有问题
 */
class Codec1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[null]";
        }
        Queue<TreeNode> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        que.add(root);
        int lastValIdx = 1;
        boolean allPrint = false;
        while(que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                que.add(tn);
                if (i < lastValIdx || allPrint) {
                    if (tn == null) {
                        sb.append(",null");
                    } else {
                        if (tn != root) {
                            sb.append(",");
                        }
                        sb.append(tn.val);
                    }
                }
            }
            int newLastValIdx = 0;
            allPrint = false;
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                if (i < lastValIdx) {
                    if (tn == null) {
                        que.add(null);que.add(null);
                    } else {
                        TreeNode left = tn.left;
                        TreeNode right = tn.right;
                        if (left != null) {
                            newLastValIdx = 2 * i + 1;
                            if (left.left != null || left.right != null) {
                                allPrint = true;
                            }
                        }
                        if (right != null) {
                            newLastValIdx = 2 * i + 2;
                            if (right.left != null || right.right != null) {
                                allPrint = true;
                            }
                        }
                        que.add(left);que.add(right);
                    }
                }
            }
            lastValIdx = newLastValIdx;
        }
        sb.append("]");
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        String[] values = data.substring(1,data.length() - 1).split(",");
        if (values[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int node = 1;
        while(node < values.length) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode rootTn = que.poll();
                if (node >= values.length) {
                    break;
                }
                String leftVal = values[node++];
                TreeNode ltn = getTn(leftVal);
                if (rootTn != null) {
                    rootTn.left = ltn;
                }
                que.add(ltn);
                if (node >= values.length) {
                    break;
                }
                String rightVal = values[node++];
                TreeNode rtn = getTn(rightVal);
                if (rootTn != null) {
                    rootTn.right = rtn;
                }
                que.add(rtn);
            }
        }
        return root;
    }

    public TreeNode getTn(String val) {
        if (val.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(val));
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));