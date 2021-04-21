import lombok.Data;

public class BinaryTreeAlg {

    private BNode root;

    @Data
    class BNode{

        private int value;
        private BNode left;
        private BNode right;
        private BNode father;

    }

    public BNode addBNode(int value){
        return null;
    }

    public BNode searchBNode(int value){
        return null;
    }

    public boolean existBNode(int value){
       return false;
    }

    public void removeBNote(int value){

    }
}
