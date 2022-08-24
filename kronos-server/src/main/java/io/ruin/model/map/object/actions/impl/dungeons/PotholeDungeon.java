package io.ruin.model.map.object.actions.impl.dungeons;

import io.ruin.model.map.object.actions.ObjectAction;

public class PotholeDungeon {
    static {
        ObjectAction.register(2584, 2824, 3118, 0, 2, (player, obj) -> {
            player.getMovement().teleport(2830, 9520, 0);
        });
        ObjectAction.register(2585, 2830, 9522, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2823, 3120, 0);
        });
    }
}
