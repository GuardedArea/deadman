package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Nardah {
    static {
        ObjectAction.register(10434, 3373, 9305, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3375, 2904, 0);
        });
        ObjectAction.register(10416, 3373, 2905, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3374, 9305, 0, false, true, false);
        });
    }
}
