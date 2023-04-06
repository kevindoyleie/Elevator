import java.util.LinkedList;

public class Elevator
{
    private int floor;
    private final LinkedList<Action> actions = new LinkedList<>();

    /* for unit tests */
    public int getFloor() {
        return this.floor;
    }
    /* for unit tests */
    public void setFloor(int floor)
    {
        this.floor = floor;
    }

    public int getActionsSize()
    {
        return this.actions.size();
    }

    protected enum Action {
        UP_ONE,
        DOWN_ONE,
        OPEN_CLOSE,
        NO_OP
    }

    public Elevator() {
        this.floor = 1;
    }

    public void requestFloor(int floorNumber) {
        actions.add(Action.OPEN_CLOSE);
        while (this.floor != floorNumber) {
            int i;
            if (floorNumber > this.floor) {
                for (i = this.floor; i <= floorNumber; i++) {
                    System.out.println("Going up..." + i);
                    this.actions.add(Action.UP_ONE);
                }
                i--;
            } else {
                for (i = this.floor; i >= floorNumber; i--) {
                    System.out.println("Going down..." + i);
                    this.actions.add(Action.DOWN_ONE);
                }
                i++;
            }
            this.floor = i;
            if (floorNumber == this.floor) {
                System.out.println("Hello, opening the door, we are on " + i);
                this.actions.add(Action.OPEN_CLOSE);
            }
        }
        this.actions.add(Action.NO_OP);
    }

    public Action getAction() {
        return actions.removeFirst();
    }
}

