package io.ruin.model.map.object.actions.impl.dungeons;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Experiments {
    static {
        ObjectAction.register(5167, 3505, 3571, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3504, 9969, 0, false, true, false);
        });
        ObjectAction.register(17387, 3504, 9970, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3504, 3569, 0, true, true, false);
        });
        ObjectAction.register(17387, 3578, 9927, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3578, 3526, 0, true, true, false);
        });
        ObjectAction.register(5167, 3578, 3527, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3577, 9927, 0);
        });
    }
}
