package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;

public class CairnIsle {
    static {
        ObjectAction.register(2234, 2762, 2990, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2760, 9389, 0);
        });
    }
}
