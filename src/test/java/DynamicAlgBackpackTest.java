import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicAlgBackpackTest {

    @Test
    public void testBackpackWithNegativeCapacityValue(){

        List<DynamicAlgBackpack.Artefact> artefacts = Arrays.asList(
                new DynamicAlgBackpack.Artefact("Water", 6, 3 ),
                new DynamicAlgBackpack.Artefact("Book", 2, 1 ),
                new DynamicAlgBackpack.Artefact("Food", 4, 2 )

        );

        DynamicAlgBackpack backpack = new DynamicAlgBackpack(artefacts, -4 );

        assertThrows(IllegalArgumentException.class, () -> backpack.findBest());
    }

    @Test
    public void testBackpackWithZeroCapacityValue(){

        List<DynamicAlgBackpack.Artefact> artefacts = Arrays.asList(
                new DynamicAlgBackpack.Artefact("Water", 6, 3 ),
                new DynamicAlgBackpack.Artefact("Book", 2, 1 ),
                new DynamicAlgBackpack.Artefact("Food", 4, 2 )

        );

        DynamicAlgBackpack backpack = new DynamicAlgBackpack(artefacts, 0 );

        assertThrows(IllegalArgumentException.class, () -> backpack.findBest());
    }

    @Test
    public void testBackpackWithNoArtefacts(){

        List<DynamicAlgBackpack.Artefact> artefacts = new ArrayList<>();
        DynamicAlgBackpack backpack = new DynamicAlgBackpack( artefacts, 4 );

        assertThrows( IllegalArgumentException.class, () -> backpack.findBest() );
    }

    @Test
    public void testBackpackWithZeroOrNegativeValueOfArtefacts(){

        DynamicAlgBackpack.Artefact artefactWithNegativeValue = new DynamicAlgBackpack.Artefact("Food", -4, 2 );
        DynamicAlgBackpack.Artefact artefactWithZeroValue = new DynamicAlgBackpack.Artefact("Food", 0, 2 );
        DynamicAlgBackpack.Artefact artefactWithPositiveValue = new DynamicAlgBackpack.Artefact("Food", 4, 2 );

        assertThrows( IllegalArgumentException.class, artefactWithNegativeValue::getValue );
        assertThrows( IllegalArgumentException.class, artefactWithZeroValue::getValue );
        assertDoesNotThrow(artefactWithPositiveValue::getValue);

    }

    @Test
    public void testBackpackWithZeroOrNegativeWeightOfArtefacts(){

        DynamicAlgBackpack.Artefact artefactWithNegativeWeight = new DynamicAlgBackpack.Artefact("Food", 4, -2 );
        DynamicAlgBackpack.Artefact artefactWithZeroWeight = new DynamicAlgBackpack.Artefact("Food", 4, 0 );
        DynamicAlgBackpack.Artefact artefactWithPositiveWeight = new DynamicAlgBackpack.Artefact("Food", 4, 2 );

        assertThrows( IllegalArgumentException.class, artefactWithNegativeWeight::getWeight );
        assertThrows( IllegalArgumentException.class, artefactWithZeroWeight::getWeight );
        assertDoesNotThrow(artefactWithPositiveWeight::getWeight );
    }

    @Test
    public void testBackpackWithArtefactsAndCapacity(){

        List<DynamicAlgBackpack.Artefact> artefacts = Arrays.asList(
                new DynamicAlgBackpack.Artefact("Water", 1, 5 ),
                new DynamicAlgBackpack.Artefact("Book", 2, 1 ),
                new DynamicAlgBackpack.Artefact("Food", 4, 2 )

        );

        DynamicAlgBackpack backpack = new DynamicAlgBackpack(artefacts, 6 );

        assertArrayEquals( new DynamicAlgBackpack.Artefact[]{
                        new DynamicAlgBackpack.Artefact("Food", 4, 2 ),
                        new DynamicAlgBackpack.Artefact("Book", 2, 1 )

                },
                backpack.findBest().toArray() );
    }
}
