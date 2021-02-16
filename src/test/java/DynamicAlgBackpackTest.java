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

        DynamicAlgBackpack backpack = new DynamicAlgBackpack(artefacts, -4);

        assertThrows(IllegalArgumentException.class, () -> backpack.findOptimalContents());
    }

    @Test
    public void testBackpackWithZeroCapacityValue(){

        List<DynamicAlgBackpack.Artefact> artefacts = Arrays.asList(
                new DynamicAlgBackpack.Artefact("Water", 6, 3 ),
                new DynamicAlgBackpack.Artefact("Book", 2, 1 ),
                new DynamicAlgBackpack.Artefact("Food", 4, 2 )

        );

        DynamicAlgBackpack backpack = new DynamicAlgBackpack(artefacts, 0 );

        assertThrows(IllegalArgumentException.class, () -> backpack.findOptimalContents());
    }

    @Test
    public void testBackpackWithNoArtefacts(){

        List<DynamicAlgBackpack.Artefact> artefacts = new ArrayList<>();
        DynamicAlgBackpack backpack = new DynamicAlgBackpack( artefacts, 4);

        assertThrows( IllegalArgumentException.class, () -> backpack.findOptimalContents() );
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
    public void testBackpackWithArtefactsAndCapacityAndIntegerWeights(){

        List<DynamicAlgBackpack.Artefact> artefacts = Arrays.asList(
                new DynamicAlgBackpack.Artefact("Water", 3000, 4 ),
                new DynamicAlgBackpack.Artefact("Food", 1500, 1 ),
                new DynamicAlgBackpack.Artefact("Book", 2000, 3 ),
                new DynamicAlgBackpack.Artefact("IPod", 1000, 1 ),
                new DynamicAlgBackpack.Artefact("IPhone", 2000, 1 )

        );

        DynamicAlgBackpack backpack = new DynamicAlgBackpack(artefacts, 4, 0.5);


        assertArrayEquals( new HashSet<DynamicAlgBackpack.Artefact>(){{
            add( new DynamicAlgBackpack.Artefact("Food", 1500, 1 ));
            add( new DynamicAlgBackpack.Artefact("IPod", 1000, 1 ));
            add( new DynamicAlgBackpack.Artefact("IPhone", 2000, 1 ));
             }}.toArray(),
                backpack.findOptimalContents().toArray() );

    }

    @Test
    public void testBackpackWithArtefactsAndCapacityAndDecimalWeights(){

        List<DynamicAlgBackpack.Artefact> artefacts = Arrays.asList(
                new DynamicAlgBackpack.Artefact("Water", 700, 0.5 ),
                new DynamicAlgBackpack.Artefact("Food", 600, 0.5 ),
                new DynamicAlgBackpack.Artefact("Book", 900, 1 ),
                new DynamicAlgBackpack.Artefact("IPod", 900, 2 ),
                new DynamicAlgBackpack.Artefact("IPhone", 800, 0.5 )

        );

        DynamicAlgBackpack backpack = new DynamicAlgBackpack(artefacts, 2, 0.5);


        assertArrayEquals( new HashSet<DynamicAlgBackpack.Artefact>(){{
                    add( new DynamicAlgBackpack.Artefact("Water", 700, 0.5 ));
                    add( new DynamicAlgBackpack.Artefact("Book", 900, 1 ));
                    add( new DynamicAlgBackpack.Artefact("IPhone", 800, 0.5 ));
                }}.toArray(),
                backpack.findOptimalContents().toArray() );

    }

    @Test
    public void testBackpackWithArtefactsAndCapacityAndDecimalWeightsNotDivisibleByZeroPointFive(){

        List<DynamicAlgBackpack.Artefact> artefacts = Arrays.asList(
                new DynamicAlgBackpack.Artefact("Water", 700, 0.5 ),
                new DynamicAlgBackpack.Artefact("Food", 600, 0.5 ),
                new DynamicAlgBackpack.Artefact("Book", 900, 1.5 ),
                new DynamicAlgBackpack.Artefact("IPod", 900, 2 ),
                new DynamicAlgBackpack.Artefact("IPhone", 800, 0.7 )

        );

        DynamicAlgBackpack backpack = new DynamicAlgBackpack( artefacts, 4, 0.5 );

        assertThrows( IllegalArgumentException.class, () -> backpack.findOptimalContents() );
    }
}
