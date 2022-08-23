package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;

public class Tirannwn {
    static {
        /*
        Iorwerth camp
         */
        ObjectAction.register(35846, 2200, 3262, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2201, 9673, 0);
        });
        ObjectAction.register(35845, 2200, 9671, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2201, 3261, 0);
        });
        /*
        Underground pass
         */
        ObjectAction.register(4006, 2313, 3215, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2314, 9624, 0);
        });
        ObjectAction.register(4007, 2312, 9623, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2312, 3216, 0);
        });
    }
}
