import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
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
        BinaryTreeAlg.BNode root = btree.addBNode( 14 );
        btree.addBNode( 8 );
        btree.addBNode( 20 );
        btree.addBNode( 5 );
        btree.addBNode( 11 );
        btree.addBNode( 17 );
        btree.addBNode( 23 );
        btree.addBNode( 4 );
        btree.addBNode( 6);
        btree.addBNode( 10 );
        btree.addBNode( 12 );
        btree.addBNode( 3 );
        btree.addBNode( 9 );
        btree.addBNode( 13 );
        btree.addBNode( 16 );
        btree.addBNode( 18 );
        btree.addBNode( 15 );
        btree.addBNode( 19 );
        btree.addBNode( 22 );
        btree.addBNode( 24 );
        btree.addBNode( 21 );
        btree.addBNode( 25 );

        log.info(btree.print( root));
    }
}
