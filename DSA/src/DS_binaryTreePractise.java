
public class DS_binaryTreePractise {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binaryTree{
        static int index = -1;

        // function to build binary Tree
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // pre-order traversal
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // in-order traversal
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // sum of all nodes of a binary tree
    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // helper function
    public static boolean isIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        return (root1.data == root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    // subtree of another tree
    public static boolean subTree(Node root, Node subTreeRoot){
        if(root == null){
            return false;
        }

        if(isIdentical(root, subTreeRoot)){
            return true;
        }

        return subTree(root.left, subTreeRoot) || subTree(root.right, subTreeRoot);
    }

    public static void main(String[] args){
        int nodes[] = {5, 1, 2, -1, -1, 4, -1, -1, 3, -1, 6, -1, -1};
        binaryTree.index = -1;
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);

        int subTreeNodes[] = {1, 2, -1, -1, 4, -1, -1};
        binaryTree.index = -1;
        binaryTree subtree = new binaryTree();
        Node subTreeRoot = subtree.buildTree(subTreeNodes);


        preOrderTraversal(root);
        System.out.println();

        inOrderTraversal(root);
        System.out.println();

        System.out.print("sum of nodes : " + sumOfNodes(root));
        System.out.println();

        System.out.println("is Subtree : " + subTree(root, subTreeRoot));
    }
}
