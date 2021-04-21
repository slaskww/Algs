import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeAlgTest {

    @Test
    public void shouldAddNewBNode(){


        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = new BinaryTreeAlg.BNode(23);
        btree.addBNode( root, 17 );

        assertTrue(btree.existBNode( root,17 ));

    }

    @Test
    void shouldRemoveNewBNode(){

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = new BinaryTreeAlg.BNode( 23 );
        btree.addBNode( root, 17 );

        assertTrue( btree.existBNode( root,17 ) );

        btree.removeBNote( root, 17 );

        assertFalse( btree.existBNode( root,17 ) );
    }
}
