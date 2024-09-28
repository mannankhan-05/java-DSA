
public class DS_binarySearchTreePractise {
    // Node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // function to create a BST
    public static Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }

       if(root.data > value){
           root.left = insert(root.left, value);
       }
       else{
           root.right = insert(root.right, value);
       }

       return root;
    }

    public static void printBST(Node root){
        if(root == null){
            return;
        }

        printBST(root.left);
        System.out.print(root.data + " ");
        printBST(root.right);
    }

    public static boolean searchBST(Node root, int key){
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

    // to delete a node from a BST
    public static Node delete(Node root, int key){
        if(root.data > key){
            root.left = delete(root.left, key);
        }
        else if(root.data < key){
            root.right = delete(root.right, key);
        }
        else{  // root.data == key
            // case 1 :
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2 :
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            // case 3 :
            // to find the inorder successor from the right
            Node inOrderSuccessor = inOrderSuccessorFinder(root.right);

            root.data = inOrderSuccessor.data;
            root.right = delete(root.right, inOrderSuccessor.data);
        }

        return root;
    }

    public static Node inOrderSuccessorFinder(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args){
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = insert(root, nodes[i]);
        }

        printBST(root);
        System.out.println();

//        searchBST(root, 7);
//        System.out.println();

        delete(root, 8);
        printBST(root);
    }
}
