package Data_Structure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // 插入节点
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        tree.insert(100);
        tree.insert(110);
        tree.insert(120);
        tree.insert(130);

        // 中序遍历并打印树的节点
        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.print('\n');
        // 前序遍历并打印树的节点
        System.out.println("Preorder traversal:");
        tree.preorder();
        System.out.print('\n');
        // 后序遍历并打印树的节点
        System.out.println("Postorder traversal:");
        tree.postorder();
        System.out.print('\n');
        // 宽度优先遍历并打印树的节点
        System.out.println("Width first traversal:");
        tree.WidthFirstTraversal();
        System.out.print('\n');
        // 打印最大宽度
        System.out.print("Max Width: ");
        System.out.println(tree.MaxWidth());
    }

    //树节点
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //搜索二叉树
    public static class BinaryTree {
        TreeNode root;

        public BinaryTree() {
            root = null;
        }

        // 插入节点
        public void insert(int data) {
            root = insertRec(root, data);
        }

        private TreeNode insertRec(TreeNode root, int data) {
            if (root == null) {
                root = new TreeNode(data);
                return root;
            }

            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        // 中序遍历（Inorder Traversal）
        public void inorder() {
            inorderRec(root);
        }

        private void inorderRec(TreeNode root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.data + " ");
                inorderRec(root.right);
            }
        }

        // 前序遍历（Preorder Traversal）深度优先遍历
        public void preorder() {
            preorderRec(root);
        }

        private void preorderRec(TreeNode root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }

        // 后序遍历（Postorder Traversal）
        public void postorder() {
            postorderRec(root);
        }

        private void postorderRec(TreeNode root) {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.data + " ");
            }
        }

        //宽度优先遍历
        public void WidthFirstTraversal() {
            if (root == null) {
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                System.out.print(cur.data + " ");
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        // 求二叉树最大宽度
        public int MaxWidth() {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            HashMap<TreeNode, Integer> levelMap = new HashMap<>(); //用于存储每个节点所在层数
            levelMap.put(root, 1);
            int curLevel = 1; //当前层数
            int curLevelNodes = 0; //当前层所含节点数
            int max = Integer.MIN_VALUE; //当前最大宽度
            while (!queue.isEmpty()) {

                TreeNode cur = queue.poll();

                int curNodeLevel = levelMap.get(cur); //当前节点所在层数

                if (curNodeLevel == curLevel) {
                    curLevelNodes++;
                } else {
                    max = Math.max(max, curLevelNodes);
                    curLevel++;
                    curLevelNodes = 1;
                }

                if (cur.left != null) {
                    levelMap.put(cur.left, curNodeLevel + 1);
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    levelMap.put(cur.right, curNodeLevel + 1);
                    queue.add(cur.right);
                }
            }
            return max;
        }
    }
}

