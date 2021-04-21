import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeAlgTest {

    @Test
    public void shouldAddNewBNode(){

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root =  btree.addBNode( 23 );
        btree.addBNode(17 );

        assertTrue(btree.existBNode( root,17 ));
    }

    @Test
    void shouldRemoveNewBNode(){

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode(17 );
        btree.addBNode(18 );
        btree.addBNode(19 );

        assertTrue( btree.existBNode( root,17 ) );
        assertTrue( btree.existBNode( root,18 ) );
        assertTrue( btree.existBNode( root,19 ) );

        btree.removeBNote( root, 17 );
        btree.removeBNote( root, 18 );
        btree.removeBNote( root, 19 );

        assertFalse(btree.existBNode( root,17 ) );
        assertFalse(btree.existBNode( root,18 ) );
        assertFalse(btree.existBNode( root,19 ) );
    }

    @Test
    public void shouldTellIfBNodeExists(){

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 17 );

        assertTrue( btree.existBNode( root,17 ) );
        assertFalse( btree.existBNode( root,77 ) );
    }

    @Test
    public void shouldSearchBNote(){

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 17 );
        BinaryTreeAlg.BNode addedBNode = btree.searchBNode( root, 17 );

        assertEquals( 17, addedBNode.getValue() );
    }


}
