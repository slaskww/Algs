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


    @Test
    public void testPrintingBTree(){

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 15 );
        btree.addBNode( 14 );
        btree.addBNode( 16 );
        btree.addBNode( 17 );
        btree.addBNode( 18 );
        btree.addBNode( 19 );
        btree.addBNode( 31 );
        btree.addBNode( 33);
        btree.addBNode( 34 );
        btree.addBNode( 30 );
        btree.addBNode( 29 );
        btree.addBNode( 28 );
        btree.addBNode( 27 );
        btree.addBNode( 26 );


        String pr = btree.printBTree( root, new StringBuilder(), new StringBuilder().append( " " ), 0).toString();
        System.out.println("BTREE:\n" + pr);

    }
}
