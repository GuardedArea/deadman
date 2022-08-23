package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Witchaven {
    static {
        ObjectAction.register(18270, 2696, 3283, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2696, 9684, 0, false, true, false);
        });
        ObjectAction.register(18354, 2696, 9682, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2697, 3283, 0, true, true, false);
        });
        ObjectAction.register(18412, 2322, 5104, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2700, 9688, 0);
        });
        ObjectAction.register(19124, 2701, 9688, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2323, 5104, 0);
        });
        /*
        Witchaven dungeon shortcut
        TODO: Add animation / agility requirement
         */
        ObjectAction.register(18416, 2331, 5096, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2333, 5096, 0);
        });
        ObjectAction.register(18416, 2331, 5096, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2330, 5096, 0);
        });

    }
}
