

package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;



public class TestClorus {

    /* Replace with the magic word given in lab.
     * If you are submitting early, just put in "early" */
    public static final String MAGIC_WORD = "";

    // @Test
    // public void testBasics() {
    //     Clorus c = new Clorus(2);
    //     assertEquals(2, c.energy(), 0.01);
    //     assertEquals(new Color(34, 231, 0), c.color());
    //     c.move();
    //     assertEquals(1.85, c.energy(), 0.01);
    //     c.move();
    //     assertEquals(1.70, c.energy(), 0.01);
    //     c.stay();
    //     assertEquals(1.90, c.energy(), 0.01);
    //     c.stay();
    //     assertEquals(2.00, c.energy(), 0.01);
    // }

    @Test
    public void testReplicate() {
        Clorus c1 = new Clorus(2);
        Clorus c2;
        c2 = c1.replicate();
        assertNotSame("Two Plips are same object.", c1, c2);
    }

    @Test
    public void testChoose() {
        Clorus c = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!  

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);
        // Action expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestClorus.class));
    }
} 
