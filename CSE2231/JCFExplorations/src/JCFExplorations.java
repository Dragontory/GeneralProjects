import java.util.HashSet;
import java.util.Map.Entry;

import components.map.Map;
import components.naturalnumber.NaturalNumber;

/**
 * Simple class to experiment with the Java Collections Framework and how it
 * compares with the OSU CSE collection components.
 *
 * @author Put your name here
 *
 */
public final class JCFExplorations {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private JCFExplorations() {
    }

    /**
     * Raises the salary of all the employees in {@code map} whose name starts
     * with the given {@code initial} by the given {@code raisePercent}.
     *
     * @param map
     *            the name to salary map
     * @param initial
     *            the initial of names of employees to be given a raise
     * @param raisePercent
     *            the raise to be given as a percentage of the current salary
     * @updates map
     * @requires [the salaries in map are positive] and raisePercent > 0
     * @ensures <pre>
     * DOMAIN(map) = DOMAIN(#map)  and
     * [the salaries of the employees in map whose names start with the given
     *  initial have been increased by raisePercent percent (and truncated to
     *  the nearest integer); all other employees have the same salary]
     * </pre>
     */
    public static void giveRaise(components.map.Map<String, Integer> map,
            char initial, int raisePercent) {
        assert map != null : "Violation of: map is not null";
        assert raisePercent > 0 : "Violation of: raisePercent > 0";

        Map<String, Integer> temp = map.newInstance();
        final int hundo = 100;

        while (map.size() != 0) {

            components.map.Map.Pair<String, Integer> pair = map.removeAny();

            String name = pair.key();
            int sal = pair.value();

            if (name.charAt(0) == initial) {
                //raises salary if initial matches
                temp.add(name, sal * (raisePercent) / hundo + sal);

            } else {

                temp.add(name, sal);

            }
        }
        map.transferFrom(temp);

    }

    /**
     * Raises the salary of all the employees in {@code map} whose name starts
     * with the given {@code initial} by the given {@code raisePercent}.
     *
     * @param map
     *            the name to salary map
     * @param initial
     *            the initial of names of employees to be given a raise
     * @param raisePercent
     *            the raise to be given as a percentage of the current salary
     * @updates map
     * @requires <pre>
     * [the salaries in map are positive] and raisePercent > 0 and
     * [the dynamic types of map and of all objects reachable from map
     *  (including any objects returned by operations (such as
     *  entrySet() and, from there, iterator()), and so on,
     *  recursively) support all optional operations]
     * </pre>
     * @ensures <pre>
     * DOMAIN(map) = DOMAIN(#map)  and
     * [the salaries of the employees in map whose names start with the given
     *  initial have been increased by raisePercent percent (and truncated to
     *  the nearest integer); all other employees have the same salary]
     * </pre>
     */
    public static void giveRaise(java.util.Map<String, Integer> map,
            char initial, int raisePercent) {
        assert map != null : "Violation of: map is not null";
        assert raisePercent > 0 : "Violation of: raisePercent > 0";

//        final int hundo = 100;
//        for (java.util.Map.Entry<String, Integer> x : map.entrySet()) {
//            String name = x.getKey();
//            int sal = x.getValue();
//            if (name.charAt(0) == initial) {
//                x.setValue(sal * (initial) / hundo + sal);
//            }
//        }

        java.util.Set<Entry<String, Integer>> temp = map.entrySet();
        java.util.Iterator<Entry<String, Integer>> iter = temp.iterator();
        final int hundo = 100;

        while (iter.hasNext()) {
            Entry<String, Integer> pair = iter.next();

            String name = pair.getKey();
            int sal = pair.getValue();

            if (name.charAt(0) == initial) {
                //raises salary if initial matches
                pair.setValue(sal * (raisePercent) / hundo + sal);

            }
        }

    }

    /**
     * Increments by 1 every element in the given {@code Set}.
     *
     * @param set
     *            the set whose elements to increment
     * @updates set
     * @ensures <pre>
     * DOMAIN(map) = DOMAIN(#map)  and
     * [set is the set of integers that are elements of #set incremented by 1]
     * </pre>
     */
    public static void incrementAll(components.set.Set<NaturalNumber> set) {
        assert set != null : "Violation of: set is not null";

        // TODO - fill in body
        components.set.Set<NaturalNumber> temp = set.newInstance();

        while (set.size() != 0) {

            NaturalNumber num = set.removeAny();
            num.increment();
            temp.add(num);
        }
        set.transferFrom(temp);

    }

    /**
     * Increments by 1 every element in the given {@code Set}.
     *
     * @param set
     *            the set whose elements to increment
     * @updates set
     * @requires <pre>
     * [the dynamic types of set and of all objects reachable from set
     *  (including any objects returned by operations (such as iterator()), and
     *  so on, recursively) support all optional operations]
     * </pre>
     * @ensures <pre>
     * DOMAIN(map) = DOMAIN(#map)  and
     * [set is the set of integers that are elements of #set incremented by 1]
     * </pre>
     */
    public static void incrementAll(java.util.Set<NaturalNumber> set) {
        assert set != null : "Violation of: set is not null";

        // TODO - fill in body

        java.util.Iterator<NaturalNumber> iter = set.iterator();
        java.util.Set<NaturalNumber> temp = new HashSet<>();

        while (iter.hasNext()) {
            NaturalNumber num = iter.next();
            iter.remove();
            num.increment();
            temp.add(num);
        }

        set.addAll(temp);

    }

}
