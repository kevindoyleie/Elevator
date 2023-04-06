import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ElevatorTest
{
    private Elevator elevator = null;

    @Before
    public void setUp() {
        elevator = new Elevator();
    }

    @Test
    public void createElevator() {
        assertNotNull(elevator);
        assertEquals(1, elevator.getFloor());
    }

    @Test
    public void whenGoFrom1to2() {
        elevator.requestFloor(2);

        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.NO_OP, elevator.getAction());
        assertEquals(2, elevator.getFloor());
    }

    @Test
    public void whenGoFrom2to1() {
        elevator.setFloor(2);
        elevator.requestFloor(1);

        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.NO_OP, elevator.getAction());
        assertEquals(1, elevator.getFloor());
    }

    @Test
    public void whenGoFrom1to10() {
        elevator.requestFloor(10);

        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.NO_OP, elevator.getAction());
        assertEquals(10, elevator.getFloor());
    }

    @Test
    public void whenGoUpAndTheBackDown()
    {
        elevator.setFloor(3);
        elevator.requestFloor(6);
        elevator.requestFloor(1);

        assertEquals(16, elevator.getActionsSize());
        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.UP_ONE, elevator.getAction());
        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.NO_OP, elevator.getAction());
        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.DOWN_ONE, elevator.getAction());
        assertEquals(Elevator.Action.OPEN_CLOSE, elevator.getAction());
        assertEquals(Elevator.Action.NO_OP, elevator.getAction());
    }
}