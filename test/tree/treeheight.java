public class treeheight {
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

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    } 

    public static int diameter2(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter2(root.left);
        int rightDiameter = diameter2(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int rootDiameter = leftHeight + rightHeight + 1;
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                                leftInfo.height + rightInfo.height + 1);
        return new Info(diameter, height);
    }
    public static void main(String[] args) {
        /*
                  1
                 / \
                2   3
               / \  / \
              4   5 7  6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        System.out.println("Height of tree: " + height(root));
        System.out.println("Count of nodes: " + count(root));
        System.out.println("Sum of nodes: " + sum(root));
        System.out.println("Diameter of tree (O(n^2)): " + diameter2(root));
        System.out.println("Diameter of tree (O(n)): " + diameter(root).diameter);
    }
}
