package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;

public class KebosSwamp {

    static {
        ObjectAction.register(34402, 1292, 3657, 0, 1, (player, obj) -> {
            player.getMovement().teleport(1292, 10057, 0);
        });
    }
}
