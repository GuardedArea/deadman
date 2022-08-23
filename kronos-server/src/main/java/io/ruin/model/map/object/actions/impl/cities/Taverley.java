package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Taverley {

    static {
        /*
        White wolf mountain underpass
         */
        ObjectAction.register(57, 2876, 3480, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2876, 9878, 0, false, false, false);
        });
        ObjectAction.register(56, 2876, 9880, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2877, 3482, 0, true, false, false);
        });
        ObjectAction.register(54, 2820, 9883, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2820, 3486, 0, true, true, false);
        });
        ObjectAction.register(55, 2820, 3484, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2820, 9882, 0, false, true, false);
        });

        /*
        Heroes guild
         */
        ObjectAction.register(17384, 2892, 3507, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2893, 9907, 0, false, true, false);
        });
        ObjectAction.register(17387, 2892, 9907, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2893, 3507, 0, true, true, false);
        });
    }
}
