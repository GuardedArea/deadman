package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;

public class DorgeshKaan {

    static {
        ObjectAction.register(22945, 1, (player, obj) -> {
            player.sendFilteredMessage("You go through the door.");//TODO: Compare to osrs
            player.getMovement().teleport(3317, 9601, 0);
        });
    }
}
