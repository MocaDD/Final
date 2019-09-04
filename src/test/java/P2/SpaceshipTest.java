package P2;

import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SpaceshipTest {

    Spaceship mySpaceship = new Spaceship(50);

    @Test
    public void board() {
        mySpaceship.board("Nolan", 3);
        HashSet<String> crewMembers = mySpaceship.getCrewMembers();
        assertTrue(crewMembers.contains("Nolan"));
    }

    @Test
    public void unboard() {

        mySpaceship.board("Nolan", 3);
        mySpaceship.board("Nick", 4);

        mySpaceship.unboard("Nolan");
        HashSet<String> crewMembers = mySpaceship.getCrewMembers();
        assertFalse(crewMembers.contains("Nolan"));
        assertTrue(crewMembers.contains("Nick"));
    }

    @Test
    public void getPlanetsVisited() {
        mySpaceship.board("Nolan", 3);
        mySpaceship.board("Nick", 4);

        assertTrue(mySpaceship.flyTo("Venus", 7));
        assertEquals(mySpaceship.getPlanetsVisited(), "[Venus]");
    }

    @Test
    public void flyToVenus() {
        mySpaceship.board("Nolan", 3);
        mySpaceship.board("Nick", 4);

        assertTrue(mySpaceship.flyTo("Venus", 7));
    }

    @Test
    public void flyToMars() {
        mySpaceship.board("Nolan", 3);
        mySpaceship.board("Nick", 4);

        assertFalse(mySpaceship.flyTo("Mars", 10));
    }
}