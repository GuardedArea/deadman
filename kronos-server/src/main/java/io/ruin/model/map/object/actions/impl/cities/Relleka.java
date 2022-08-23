package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;

public class Relleka {
    static {
        /*
        Mountain daughter camp
         */
        ObjectAction.register(5857, 2809, 3703, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2807, 10104, 0);
        });
        ObjectAction.register(5858, 2805, 10104, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2808, 3703, 0);
        });
    }
}
