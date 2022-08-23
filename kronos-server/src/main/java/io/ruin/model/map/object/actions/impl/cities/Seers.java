package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Seers {
    static {
        /*
        Elemental workshop entrance
         */
        ObjectAction.register(3415, 2710, 3497, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2716, 9888, 0, false, true, false);
        });
        ObjectAction.register(3416, 2714, 9887, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2709, 3497, 0, true, true, false);
        });
        /*
        Elemental workshop 2 entrance
         */
        ObjectAction.register(3413, 2719, 9890, 0, 1, (player, obj) -> {
            Ladder.climb(player, 1955, 5155, 2, false, true, false);
        });ObjectAction.register(18598, 1953, 5154, 2, 1, (player, obj) -> {
            Ladder.climb(player, 2720, 9892, 0, true, true, false);
        });
        /*
        Elemental workshop 2 plateau
         */
        ObjectAction.register(18610, 1958, 5159, 2, 1, (player, obj) -> {
            Ladder.climb(player, 1959, 5159, 3, true, false, false);
        });
        ObjectAction.register(18611, 1958, 5159, 3, 1, (player, obj) -> {
            Ladder.climb(player, 1957, 5159, 2, false, false, false);
        });
        ObjectAction.register(18611, 1949, 5149, 3, 1, (player, obj) -> {
            Ladder.climb(player, 1950, 5149, 2, false, true, false);
        });
        ObjectAction.register(18610, 1949, 5149, 2, 1, (player, obj) -> {
            Ladder.climb(player, 1948, 5149, 3, true, true, false);
        });
        /*
        Elemental workshop 3 entrance
         */
        ObjectAction.register(18597, 1948, 5158, 2, 1, (player, obj) -> {
            Ladder.climb(player, 1947, 5159, 0, false, true, false);
        });
        ObjectAction.register(18599, 1948, 5159, 0, 1, (player, obj) -> {
            Ladder.climb(player, 1950, 5158, 2, true, true, false);
        });
    }
}
