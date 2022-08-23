package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Rimmington {

    static {
        /*
        Rimmington dock
         */
        ObjectAction.register(34667, 2909, 3227, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2909, 3229, 1);
        });
        ObjectAction.register(34668, 2909, 3228, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2909, 3226, 0);
        });
        ObjectAction.register(34669, 2915, 3224, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2915, 3222, 1);
        });
        ObjectAction.register(34670, 2915, 3223, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2915, 3225, 0);
        });
        ObjectAction.register(9744, 2914, 3221, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2913, 3221, 1, true, true, false);
        });
        ObjectAction.register(9745, 2914, 3221, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2913, 3221, 0, false, true, false);
        });

        /*
        Melzar's maze
         */
        ObjectAction.register(2605, 2932, 3240, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2933, 9640, 0, false, true, false);
        });
        ObjectAction.register(17385, 2924, 9650, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2924, 3249, 0, true, true, false);
        });
        ObjectAction.register(25038, 2928, 9658, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2927, 3258, 0, true, true, false);
        });
        ObjectAction.register(17385, 2939, 9657, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2939, 3256, 0, true, true, false);
        });
    }
}
