package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class PaterdomusTemple {
    static {
        ObjectAction.register(1581, 3405, 3507, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3405, 9906, 0, false, true, false);
        });
        ObjectAction.register(17385, 3405, 9907, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3405, 3506, 0, true, true, false);
        });
        ObjectAction.register(3443, 3440, 9886, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3423, 3485, 0);
        });
    }
}
