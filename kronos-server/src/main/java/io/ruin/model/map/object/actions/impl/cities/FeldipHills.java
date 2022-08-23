package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class FeldipHills {
    static {
        /*
        Diary hunter area
         */
        ObjectAction.register(19039, 2525, 2893, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2532, 9294, 0);
        });
        ObjectAction.register(19037, 2533, 9293, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2527, 2894, 0);
        });
        /*
        Corsair cove
         */
        ObjectAction.register(31766, 2482, 2890, 0, 1, (player, obj) -> {
            player.getMovement().teleport(1971, 9035, 1);
        });
        ObjectAction.register(31806, 1970, 9033, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2483, 2889, 0);
        });
        ObjectAction.register(32205, 1937, 9009, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2457, 2849, 0, true, true, false);
        });
        ObjectAction.register(31626, 2456, 2846, 0, 1, (player, obj) -> {
            player.getMovement().teleport(1936, 9009, 1);
        });
        ObjectAction.register(31790, 2012, 9005, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2523, 2860, 0);
            Ladder.climb(player, 2523, 2860, 0, true, true, false);
        });
        ObjectAction.register(31791, 2523, 2861, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2012, 9004, 1);
            Ladder.climb(player, 2012, 9004, 1, false, true, false);
        });
        /*
        Wrath altar
         */
        ObjectAction.register(31606, 2444, 2819, 0, 1, (player, obj) -> {
            player.getMovement().teleport(1939, 8968, 1);
        });
        ObjectAction.register(31807, 1938, 8966, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2444, 2818, 0);
        });
    }
}
