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

    public BNode addBNode(BNode root, int value){
        return null;
    }



    public  BNode searchBNode(BNode root, int value){
        return null;
    }

    public  boolean existBNode(BNode root, int value){
       return false;
    }

    public  void removeBNote(BNode root, int value){

    }
}
