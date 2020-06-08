package creatures;

import huglife.Creature;

import java.awt.*;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import static huglife.HugLifeUtils.randomEntry;


public class Clorus extends Creature {
    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    public Clorus() {
        this(1);
    }

    /**
     * If a Clorus attacks another creature, it should gain that creature’s energy.
     * @param
     */
    @Override
    public String name() {
        return super.name();
    }

    @Override
    public Color color() {
        return color(r, g, b);
    }

    @Override
    public void attack(Creature c) {
        energy = energy + c.energy();
    }

    @Override
    /**
     * Cloruses should lose 0.03 units of energy on a MOVE action.
     */
    public void move() {
        // TODO
        energy = energy -0.03;
        if (energy < 0) {
            energy = 0;
        }
    }

    /**
     * Cloruses should lose 0.01 units of energy on a STAY action.
     */
    @Override
    public void stay() {
        // TODO
        energy = energy - 0.01;
    }

    /**
     * when a Clorus replicates, it keeps 50% of its energy. The other 50% goes to its offspring
     * No energy is lost in the replication process.
     * @return
     */
    @Override
    public Clorus replicate() {
        Clorus babyC = new Clorus(energy * 0.5);
        return babyC;
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();
        // TODO
        for (Direction key : neighbors.keySet()) {
            if (neighbors.get(key).name().equals("empty")) {
                emptyNeighbors.add(key);
            } else if (neighbors.get(key).name().equals("plip")) {
                plipNeighbors.add(key);
            }
        }
        if (emptyNeighbors.size() == 0) { // FIXME
            // TODO
            return new Action(Action.ActionType.STAY);
        } else if (plipNeighbors.size() > 0) {
            // Rule 2
            // if any Plips are seen, the Clorus will ATTACK one of them randomly.
            return new Action(Action.ActionType.ATTACK, randomEntry(plipNeighbors));
        } else if (energy >= 1.0) {
            // Rule 3
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        }  else {
            // Rule 4
            return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        }
    }
}
