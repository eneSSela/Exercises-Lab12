package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final int size;
    private final List<Integer> values = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            values.add(0);
        }
    }

    /**
     * Return the total number of buttons.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns a copy of the list of the current values of the buttons.
     */
    @Override
    public List<Integer> values() {
        return new ArrayList<>(values);
    }

    /**
     * Returns the list of the enabled states of the buttons.
     * A button is enabled if its value is less than the max (size).
     */
    @Override
    public List<Boolean> enabledStates() {
        return values.stream()
            .map(v -> v < size)
            .collect(Collectors.toList());
    }

    /**
     * Increment the value of the button at the index 'elem'.
     * 
     * @param elem index of the button to increment
     * @return the new value of the button
     */
    @Override
    public int hit(final int elem) {
        final int newValue = values.get(elem) + 1;
        values.set(elem, newValue);
        return newValue;
    }

    /**
     * Return the result using the pattern <<0|1|...|N>>.
     */
    @Override
    public String result() {
        return values.stream()
            .map(String::valueOf)
            .collect(Collectors.joining("|", "<<", ">>"));
    }

    /**
     * Returns true if all buttons have the same value.
     */
    @Override
    public boolean toQuit() {
        return values.stream().allMatch(v -> v.equals(values.get(0)));
    }
}
