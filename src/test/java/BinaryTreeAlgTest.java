import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class BinaryTreeAlgTest {

    @Test
    public void shouldAddNewBNode() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 17 );

        assertTrue( btree.existBNode( 17 ) );
    }

    @Test
    void shouldRemoveNewBNode() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 17 );
        btree.addBNode( 18 );
        btree.addBNode( 19 );

        assertTrue( btree.existBNode( 17 ) );
        assertTrue( btree.existBNode( 18 ) );
        assertTrue( btree.existBNode( 19 ) );

        btree.removeBNode( 17 );
        btree.removeBNode( 18 );
        btree.removeBNode( 19 );

        assertFalse( btree.existBNode( 17 ) );
        assertFalse( btree.existBNode( 18 ) );
        assertFalse( btree.existBNode( 19 ) );
    }

    @Test
    public void shouldTellIfBNodeExists() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 17 );

        assertTrue( btree.existBNode( 17 ) );
        assertFalse( btree.existBNode( 77 ) );
    }

    @Test
    public void shouldSearchBNote() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 17 );
        BinaryTreeAlg.BNode addedBNode = btree.searchBNode( 17 );

        assertEquals( 17, addedBNode.getValue() );
    }


    @Test
    public void testPrintingBTree() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 14 );
        btree.addBNode( 8 );
        btree.addBNode( 20 );
        btree.addBNode( 5 );
        btree.addBNode( 11 );
        btree.addBNode( 17 );
        btree.addBNode( 23 );
        btree.addBNode( 4 );
        btree.addBNode( 6 );
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

        log.info( btree.print( root ) );
    }

    @Test
    public void testPrintingOfEmptyBTree() {

        BinaryTreeAlg btree = new BinaryTreeAlg();

        assertThrows( IllegalArgumentException.class, () -> btree.print( null ) );
    }

    @Test
    public void testBTreeSizeAfterAddingTheSameNode() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 24 );
        btree.addBNode( 25 );
        btree.addBNode( 26 );
        btree.addBNode( 27 );
        btree.addBNode( 28 );
        btree.addBNode( 29 );
        btree.addBNode( 30 );


        assertEquals( 8, btree.getSize() );

        btree.addBNode( 30 );

        assertEquals( 8, btree.getSize() );

        btree.balanceBTree( root );
    }

    @Test
    public void testBalanceBTree() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 62 );
        btree.addBNode( 49 );
        btree.addBNode( 17 );
        btree.addBNode( 72 );
        btree.addBNode( 73 );
        btree.addBNode( 74 );
        btree.addBNode( 85 );
        btree.addBNode( 97 );
        btree.addBNode( 27 );
        btree.addBNode( 22 );
        btree.addBNode( 35 );
        btree.addBNode( 58 );
        btree.addBNode( 100 );
        btree.addBNode( 70 );
        btree.addBNode( 48 );
        btree.addBNode( 99 );
        btree.addBNode( 67 );
        btree.addBNode( 6 );
        btree.addBNode( 29 );
        btree.addBNode( 51 );

        //Binary Tree depth before balancing:
        int leftBranchDepth = btree.countBranchDepth( root.getLeft() );
        int rightBranchDepth = btree.countBranchDepth( root.getRight() );
        int bTreeSize = btree.getSize();

        //Value of imbalance between two root branches, accepted value <= 1;
        int bTreeImbalance = Math.abs( leftBranchDepth - rightBranchDepth );

        //Optimal complexity for basic operations on Binary Tree (add, remove, search); its value is O(logN), where N = size
        //Real complexity equals the depth of the deeper branch
        double optComplexity = Math.log10( bTreeSize ) / Math.log10( 2 );
        double realComplexity = Math.max( leftBranchDepth, rightBranchDepth );

        assertFalse( bTreeImbalance <= 1 );
        assertFalse( optComplexity >= realComplexity );

        btree.balanceBTree( root );

        //Binary Tree depth values, real complexity and imbalance value after balancing
        leftBranchDepth = btree.countBranchDepth( root.getLeft() );
        rightBranchDepth = btree.countBranchDepth( root.getRight() );
        realComplexity = Math.max( leftBranchDepth, rightBranchDepth );
        bTreeImbalance = Math.abs( leftBranchDepth - rightBranchDepth );

        assertTrue( bTreeImbalance <= 1 );
        assertTrue( optComplexity >= realComplexity);


    }

    @Test
    public void testBTreeSizeAfterRemovingNodes() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );
        btree.addBNode( 24 );
        btree.addBNode( 25 );
        btree.addBNode( 26 );
        btree.addBNode( 27 );
        btree.addBNode( 28 );
        btree.addBNode( 29 );
        btree.addBNode( 30 );
        btree.removeBNode( 25 );
        btree.removeBNode( 26 );
        btree.removeBNode( 27 );

        assertEquals( 5, btree.getSize() );

        btree.removeBNode( 25 );
        btree.removeBNode( 26 );
        btree.removeBNode( 27 );

        assertEquals( 5, btree.getSize() );
    }

    @Test
    public void testLevelAttribute() {

        BinaryTreeAlg btree = new BinaryTreeAlg();
        BinaryTreeAlg.BNode root = btree.addBNode( 23 );

        assertEquals( 0, root.getLevel() );

        btree.addBNode( 22 );
        BinaryTreeAlg.BNode addedNode = btree.searchBNode( 22 );

        assertEquals( 1, addedNode.getLevel() );

        btree.addBNode( 20 );
        addedNode = btree.searchBNode( 20 );

        assertEquals( 2, addedNode.getLevel() );

        btree.addBNode( 21 );
        addedNode = btree.searchBNode( 21 );

        assertEquals( 3, addedNode.getLevel() );

        btree.addBNode( 24 );
        addedNode = btree.searchBNode( 24 );

        assertEquals( 1, addedNode.getLevel() );

    }
}
