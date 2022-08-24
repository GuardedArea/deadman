package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Uzer {
    static {
        ObjectAction.register(6373, 3492, 3090, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2721, 4886, 0, false, true, false);
        });
        ObjectAction.register(6372, 2721, 4884, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3491, 3090, 0, true, true, false);
        });
        ObjectAction.register(6310, 2720, 4912, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2720, 4884, 2);
        });
        ObjectAction.register(6282, 2719, 4883, 2, 1, (player, obj) -> {
            player.getMovement().teleport(2721, 4911, 0);
        });
    }
}
