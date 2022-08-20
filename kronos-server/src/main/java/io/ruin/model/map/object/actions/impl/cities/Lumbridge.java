package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;

public class Lumbridge {

    static {
        ObjectAction.register(14880, 1, (player, obj) -> {
            player.sendFilteredMessage("You climb down the stairs.");//TODO: Compare to osrs
            player.getMovement().teleport(3208, 9616, 0);
        });
        ObjectAction.register(17385, 1, (player, obj) -> {
            player.sendFilteredMessage("You climb up the stairs.");//TODO: Compare to osrs
            player.getMovement().teleport(3208, 3216, 0);
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
