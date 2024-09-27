import java.util.ArrayList;

public class DS_binarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            // left subtree
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    // in-order traversal
    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // to search for a key in a BST
    public static boolean searchBST(Node root, int key){   // O(H)
        if(root == null){
            return false;
        }

        if(root.data > key){
            return searchBST(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return searchBST(root.right, key);
        }
    }

    // to delete a node
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{  // root.data == val
            // case 1 : leaf node
            if(root.left == null && root.right == null){
                return null;    // returning null to root's parent
            }

            // case 2 : if left is null
            if(root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }

            // case 3 :
            // to find inorder successor from right
            Node inorderSuccessor = inorderSuccessor(root.right);

            // updating the data of root by inorderSuccessor's data
            root.data = inorderSuccessor.data;

            // updating root's right subtree by deleting the inorderSuccessor
            root.right = delete(root.right, inorderSuccessor.data);
        }

        return root;
    }

    // to find the inorder Successor
    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    // question : print in range
    public static void printInRange(Node root, int x, int y){
        if(root == null){
            return;
        }

        if(root.data >= x && root.data <= y){
             printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if(root.data >= y){
            printInRange(root.left, x, y);
        }
        else{
            printInRange(root.right, x, y);
        }
    }

    // question : root to leaf path
    public static void printPathFromRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);    // adding the root to the arraylist

        // leaf
        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{  // non-leaf node
            printPathFromRootToLeaf(root.left, path);
            printPathFromRootToLeaf(root.right, path);
        }
       path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        delete(root, 5);
        inOrder(root);
        System.out.println();

        printInRange(root, 4, 11);
        System.out.println();

        System.out.println("Paths from root to leaf : ");
        printPathFromRootToLeaf(root, new ArrayList<>());
    }
}
