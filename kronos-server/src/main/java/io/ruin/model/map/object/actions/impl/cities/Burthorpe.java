package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Burthorpe {

    static {
        /*
        Games room
         */
        ObjectAction.register(4626, 2897, 3566, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2897, 3569, 1, true, false, false);
        });
        ObjectAction.register(4625, 2897, 3567, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2897, 3565, 0, false, false, false);
        });
        ObjectAction.register(4624, 2899, 3566, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2205, 4934, 1, false, false, false);
        });
        ObjectAction.register(4627, 2205, 4935, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2899, 3565, 0, true, false, false);
        });
        ObjectAction.register(4620, 2207, 4935, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2207, 4938, 0, false, false, false);
        });
        ObjectAction.register(4622, 2207, 4935, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2207, 4934, 1, true, false, false);
        });
        ObjectAction.register(4622, 2212, 4941, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2212, 4944, 1, true, false, false);
        });
        ObjectAction.register(4620, 2212, 4942, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2212, 4940, 0, false, false, false);
        });

    }
}
