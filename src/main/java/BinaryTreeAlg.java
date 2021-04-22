import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeAlg {

    private BNode root;

    @Data
    static
    class BNode {

        private int value;
        private BNode left;
        private BNode right;
        private BNode father;

        public BNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.father = null;
        }

    }

    public BNode addBNode(int value) {
        if (this.root == null) {
            this.root = new BNode( value );
            return root;
        }

        root = addRecursively( root, value );
        return root;

    }


    public BNode searchBNode(BNode root, int value) {

        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        }
        if (root.value > value) {
            return searchBNode( root.left, value );
        } else {
            return searchBNode( root.right, value );
        }
    }

    public boolean existBNode(BNode root, int value) {

        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }
        if (root.value > value) {
            return existBNode( root.left, value );
        } else {
            return existBNode( root.right, value );
        }
    }

    public BNode removeBNote(BNode root, int value) {

        if (root == null) {
            return null;
        }

        if (root.value == value) {

            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            int val = findBiggestBNode( root.left );
            root.left = removeBNote( root.left, val );
            root.value = val;
            return root;
        }

        if (root.value > value) {
            root.left = removeBNote( root.left, value );
        } else {
            root.right = removeBNote( root.right, value );
        }
        return root;
    }

    private BNode addRecursively(BNode curr, int value) {

        if (curr == null) {
            return new BNode( value );
        }

        if (curr.value == value) {
            return curr;
        }

        if (curr.value > value) {
            curr.left = addRecursively( curr.left, value );
        } else {
            curr.right = addRecursively( curr.right, value );
        }

        return curr;
    }

    private int findBiggestBNode(BNode root) {
        return root.right == null ? root.value : findBiggestBNode( root.right );
    }

    public String print(BNode root){

        StringBuilder print = new StringBuilder();
        StringBuilder space = new StringBuilder().append( '\t' );


        if (root == null) return "Binary Tree is empty";

        print.append("\n\t" + root.value + "\n" );
        return printRecursively( root, print, space).toString() ;

    }

    private StringBuilder printRecursively(BNode root, StringBuilder print, StringBuilder space) {

        StringBuilder sp = new StringBuilder();
        sp.append( space.toString() );

        if (root.right != null) {
            print.append( space.toString() + "|-" + root.right.value +  "\n" );
            print = printRecursively( root.right, print, space.append(  "|" + '\t'  ));
        }
        if (root.left != null) {
            print.append( sp.toString() + "|-" + root.left.value + "\n" );
            print = printRecursively( root.left, print, sp.append( '\t'  ));
        }

        return print;
    }
}
