package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Entrana {
    static {
        ObjectAction.register(2408, 2820, 3374, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2822, 9771, 0, false, true, false);
        });
        ObjectAction.register(2407, 2874, 9750, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3250, 3772, 0);
        });
    }
}
