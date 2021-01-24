import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayLifeSpec {
    @Test(expected = IllegalArgumentException.class)
    public void failWhenXisBelow2() {
        var life = new ArrayLife(new boolean[][]{
                {false, false},
                {false, false},
                {false, false},
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void failWhenYisBelow2() {
        var life = new ArrayLife(new boolean[][]{
                {false, false, false},
                {false, false, false},
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void failWhenXisNotEqual() {
        var life = new ArrayLife(new boolean[][]{
                {false, false, false},
                {false, false, false, false},
                {false, false, false},
        });
    }

    @Test
    public void dieWhen0or1Neighbors() {
        var life = new ArrayLife(new boolean[][]{
                {true, false, false},
                {false, true, false},
                {false, false, false},
        });

        life.nextGeneration();
        var actual = life.toString();

        var expected =
                "[ ][ ][ ]\n" +
                "[ ][ ][ ]\n" +
                "[ ][ ][ ]\n" ;

        assertEquals(expected, actual);
    }

    @Test
    public void dieWhen4orMoreNeighbors() {
        var life = new ArrayLife(new boolean[][]{
                {true, false, true},
                {true, true, false},
                {false, true, true},
        });

        life.nextGeneration();
        var actual = life.toString();

        var expected =
                "[*][ ][ ]\n" +
                "[*][ ][ ]\n" +
                "[*][*][*]\n" ;

        assertEquals(expected, actual);
    }

    @Test
    public void surviveWhen2or3Neighbors() {
        var life = new ArrayLife(new boolean[][]{
                {true, false, false},
                {false, true, false},
                {false, true, false},
        });

        life.nextGeneration();
        var actual = life.toString();

        var expected =
                "[ ][ ][ ]\n" +
                "[*][*][ ]\n" +
                "[ ][ ][ ]\n" ;

        assertEquals(expected, actual);
    }

    @Test
    public void populateWhen3Neighbors() {
        var life = new ArrayLife(new boolean[][]{
                {true, false, false},
                {true, false, false},
                {false, true, false},
        });

        life.nextGeneration();
        var actual = life.toString();

        var expected =
                "[ ][ ][ ]\n" +
                "[*][*][ ]\n" +
                "[ ][ ][ ]\n" ;

        assertEquals(expected, actual);
    }

    @Test
    public void repeatingPattern() {
        var life = new ArrayLife(new boolean[][]{
                {false, false,   false, false, false, false, false,    false, false },
                {false, false,   false, false, false, false, false,    false, false },

                {false, false,   true, false, true, false, true,       false, false },
                {false, false,   false, true, false, true, false,      false, false },
                {false, false,   true, false, true, false, true,       false, false },
                {false, false,   false, true, false, true, false,      false, false },
                {false, false,   true, false, true, false, true,       false, false },

                {false, false,   false, false, false, false, false,    false, false },
                {false, false,   false, false, false, false, false,    false, false },
        });

        for(int i = 0; i < 50; i++) {
            life.nextGeneration();
        }
        var actual = life.toString();

        var expected =
                "[ ][ ][ ][ ][*][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][*][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][*][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][ ][ ][ ][ ][ ]\n" +
                "[*][*][*][ ][ ][ ][*][*][*]\n" +
                "[ ][ ][ ][ ][ ][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][*][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][*][ ][ ][ ][ ]\n" +
                "[ ][ ][ ][ ][*][ ][ ][ ][ ]\n" ;
        assertEquals(expected, actual);
    }
}
