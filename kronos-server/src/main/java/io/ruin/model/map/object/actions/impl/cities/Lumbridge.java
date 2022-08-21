package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Lumbridge {

    static {
        ObjectAction.register(14880, 1, (player, obj) -> {
            Ladder.climb(player, 3208, 9616, 0, false, true, false);
        });
        ObjectAction.register(17385, 1, (player, obj) -> {
            if(obj.x == 3209 && obj.y == 9616) {
                Ladder.climb(player, 3208, 3216, 0, true, true, false);
            }
        });
        ObjectAction.register(6899, 1, (player, obj) -> {
            player.sendFilteredMessage("You go through the hole in the wall.");//TODO: Compare to osrs
            player.getMovement().force(-2, 0, 0, 0, 10, 60, Direction.WEST);
        });
        ObjectAction.register(6898, 1, (player, obj) -> {
            player.sendFilteredMessage("You go through the hole in the wall.");//TODO: Compare to osrs
            player.getMovement().force(2, 0, 0, 0, 10, 60, Direction.EAST);
        });
        ObjectAction.register(6919, 1, (player, obj) -> {
            player.sendFilteredMessage("You go through the door.");//TODO: Compare to osrs
            player.getMovement().teleport(2747, 5374, 0);
        });
        ObjectAction.register(6920, 1, (player, obj) -> {
            player.sendFilteredMessage("You go through the door.");//TODO: Compare to osrs
            player.getMovement().teleport(2748, 5374, 0);
        });
    }
}
