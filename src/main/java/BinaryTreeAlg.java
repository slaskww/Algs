import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class BinaryTreeAlg {

    private BNode root;
    private int size;

    @Data
    static
    class BNode {

        private int value;
        private BNode left;
        private BNode right;
        private BNode father;
        private int level;

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
            this.root.level = 0;
            this.size = 1;
            return root;
        }

        root = addRecursively( root, value );
        return root;

    }

    public BNode searchBNode(int value){

      return  searchBNodeRecursively( this.root, value );
    }

    private BNode searchBNodeRecursively(BNode root, int value) {

        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        }
        if (root.value > value) {
            return searchBNodeRecursively( root.left, value );
        } else {
            return searchBNodeRecursively( root.right, value );
        }
    }

    public boolean existBNode(int value){
        return existBNodeRecursively(this.root, value );
    }

    private boolean existBNodeRecursively(BNode root, int value) {

        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }
        if (root.value > value) {
            return existBNodeRecursively( root.left, value );
        } else {
            return existBNodeRecursively( root.right, value );
        }
    }

    public BNode removeBNode(int value){

        return removeBNoteRecursively(this.root, value);
    }

    private BNode removeBNoteRecursively(BNode root, int value) {

        if (root == null) {
            return null;
        }

        if (root.value == value) {
            this.size--;

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
            root.left = removeBNoteRecursively( root.left, val );
            root.value = val;
            return root;
        }

        if (root.value > value) {
            root.left = removeBNoteRecursively( root.left, value );
        } else {
            root.right = removeBNoteRecursively( root.right, value );
        }
        return root;
    }

    private BNode addRecursively(BNode curr, int value) {

        if (curr == null) {
            this.size++;
            return new BNode( value );
        }

        if (curr.value == value) {
            return curr;
        }

        if (curr.value > value) {
            curr.left = addRecursively( curr.left, value );
            curr.left.level = curr.level + 1;
        } else {
            curr.right = addRecursively( curr.right, value );
            curr.right.level = curr.level + 1;
        }

        return curr;
    }

    private int findBiggestBNode(BNode root) {
        return root.right == null ? root.value : findBiggestBNode( root.right );
    }

    public String print(BNode root){

        StringBuilder printedBTree = new StringBuilder();
        StringBuilder padding = new StringBuilder().append( '\t' );


        if (root == null) throw new IllegalArgumentException("Binary Tree is empty");

        printedBTree
                .append( "\n  " )
                .append( root.value )
                .append( "\n" );
        return printRecursively( root, printedBTree, padding).toString() ;

    }

    private StringBuilder printRecursively(BNode root, StringBuilder printedBTree, StringBuilder padding) {

        String singleTwig = "└──";
        String doubleTwig = "├──";
        String linker = "│";
        String singleSpace = "\t";
        String newLine = "\n";

        if (root.right != null && root.left == null) {
            printedBTree
                    .append( padding)
                    .append(singleTwig )
                    .append( root.right.value )
                    .append( newLine);
            printedBTree = printRecursively( root.right, printedBTree, new StringBuilder().append(padding).append(singleSpace));
        } else if (root.right != null) {
            printedBTree
                    .append( padding)
                    .append(doubleTwig )
                    .append( root.right.value )
                    .append(newLine);
            printedBTree = printRecursively( root.right, printedBTree, new StringBuilder().append(padding).append( linker + singleSpace ));
        }
        if (root.left != null) {
            printedBTree
                    .append( padding)
                    .append(singleTwig)
                    .append( root.left.value )
                    .append(newLine);
            printedBTree = printRecursively( root.left, printedBTree, new StringBuilder().append(padding).append(singleSpace ));
        }

        return printedBTree;
    }

    public void balanceBTree(BNode root){

    }
}
