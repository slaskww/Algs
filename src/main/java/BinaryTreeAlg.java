import lombok.Data;

public class BinaryTreeAlg {

    private  BNode root;

    @Data
    static
    class BNode{

        private int value;
        private BNode left;
        private BNode right;
        private BNode father;

        public BNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.father = null;
        }

    }

    public BNode addBNode(int value){
        if(this.root == null){
            this.root = new BNode( value);
            return root;
        }

        root = addRecursively( root, value );
        return root;

    }


    public  BNode searchBNode(BNode root, int value){

        if(root == null){
            return null;
        }
        if(root.value == value){
            return root;
        }
        if(root.value > value){
            return searchBNode( root.left, value );
        } else{
            return searchBNode(root.right, value);
        }
    }

    public  boolean existBNode(BNode root, int value){

        if(root == null) {
            return false;
        }

        if(root.value == value){
            return true;
        }
        if(root.value > value){
            return existBNode( root.left, value );
        } else{
            return existBNode( root.right, value );
        }
    }

    public  void removeBNote(BNode root, int value){

    }

    private BNode addRecursively(BNode curr, int value){

        if(curr == null){
            return new BNode( value );
        }

        if(curr.value > value){
          curr.left =  addRecursively( curr.left, value );
        } else {
            curr.right = addRecursively( curr.right, value );
        }

        return curr;
    }
}
