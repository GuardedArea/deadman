package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class PortSarim {

    static {
        /*
        Ship to musa point
         */
        ObjectAction.register(2083, 3030, 3217, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3032, 3217, 1);
        });
        ObjectAction.register(2084, 3031, 3217, 1, 1, (player, obj) -> {
            player.getMovement().teleport(3029, 3217, 0);
        });
        ObjectAction.register(273, 3034, 3214, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3035, 3214, 0, false, true, false);
        });
        ObjectAction.register(272, 3034, 3214, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3035, 3214, 1, true, true, false);
        });
        ObjectAction.register(273, 3034, 3218, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3035, 3218, 0, false, true, false);
        });
        ObjectAction.register(272, 3034, 3218, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3035, 3218, 1, true, true, false);
        });
        ObjectAction.register(273, 3034, 3222, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3035, 3222, 0, false, true, false);
        });
        ObjectAction.register(272, 3034, 3222, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3035, 3222, 1, true, true, false);
        });
        ObjectAction.register(246, 3032, 3224, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3032, 3223, 1, false, true, false);
        });
        ObjectAction.register(246, 3036, 3224, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3036, 3223, 1, false, true, false);
        });
        ObjectAction.register(245, 3032, 3224, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3032, 3225, 2, false, true, false);
        });
        ObjectAction.register(245, 3036, 3224, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3036, 3225, 2, false, true, false);
        });

        /*
        Monk's ship
         */
        ObjectAction.register(2412, 3048, 3233, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3048, 3231, 1);
        });
        ObjectAction.register(2413, 3048, 3232, 1, 1, (player, obj) -> {
            player.getMovement().teleport(3048, 3234, 0);
        });

        /*
        Redbeard frank's ship
         */
        ObjectAction.register(34671, 3055, 3244, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3055, 3242, 1);
        });
        ObjectAction.register(34672, 3055, 3243, 1, 1, (player, obj) -> {
            player.getMovement().teleport(3055, 3245, 0);
        });

        /*
        Dragon Slayer ship
         */
        ObjectAction.register(2593, 3047, 3205, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3047, 3207, 1);
        });
        ObjectAction.register(2594, 3047, 3206, 1, 1, (player, obj) -> {
            player.getMovement().teleport(3047, 3204, 0);
        });
        ObjectAction.register(272, 3049, 3208, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3049, 3208, 1, false, true, false);
        });

        /*
        Void Knight ship
         */
        ObjectAction.register(14304, 3041, 3201, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3041, 3198, 0);
        });
        ObjectAction.register(14305, 3041, 3200, 1, 1, (player, obj) -> {
            player.getMovement().teleport(3041, 3202, 0);
        });
        ObjectAction.register(287, 3042, 3198, 1, 1, (player, obj) -> {
            player.sendMessage("You can't go down there!");
        });
        /*
        Trader stan's ship
         */
        ObjectAction.register(17404, 3038, 3191, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3038, 3189, 1);
        });
        ObjectAction.register(17405, 3038, 3190, 1, 1, (player, obj) -> {
            player.getMovement().teleport(3038, 3192, 0);
        });
    }
}
