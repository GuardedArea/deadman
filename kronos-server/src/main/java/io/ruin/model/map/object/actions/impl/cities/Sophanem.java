package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Sophanem {
    static {
        /*
        Church
         */
        ObjectAction.register(20275, 3315, 2797, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2766, 5131, 0, false, true, false);
        });
        ObjectAction.register(20280, 2765, 5130, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3315, 2796, 0, true, true, false);
        });
        ObjectAction.register(20340, 2766, 5130, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3318, 9273, 2, false, true, false);
        });
        ObjectAction.register(20281, 3318, 9274, 2, 1, (player, obj) -> {
            Ladder.climb(player, 2766, 5131, 0, true, true, false);
        });
        ObjectAction.register(20285, 3286, 9274, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3286, 9273, 0, false, true, false);
        });
        ObjectAction.register(20284, 3286, 9274, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3286, 9275, 2, true, true, false);
        });
        ObjectAction.register(20284, 3271, 9274, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3270, 9274, 2, true, true, false);
        });
        ObjectAction.register(20285, 3271, 9274, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3272, 9274, 0, false, true, false);
        });
        ObjectAction.register(20285, 3280, 9255, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3280, 9254, 0, false, true, false);
        });
        ObjectAction.register(20284, 3280, 9255, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3280, 9256, 2, true, true, false);
        });
        ObjectAction.register(20285, 3317, 9250, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3317, 9251, 0, false, true, false);
        });
        ObjectAction.register(20284, 3317, 9250, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3317, 9249, 2, true, true, false);
        });
        ObjectAction.register(20285, 3323, 9241, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3323, 9240, 0, false, true, false);
        });
        ObjectAction.register(20284, 3323, 9241, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3323, 9242, 2, true, true, false);
        });
        ObjectAction.register(20285, 3317, 9224, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3317, 9223, 0, false, true, false);
        });
        ObjectAction.register(20284, 3317, 9224, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3317, 9225, 2, true, true, false);
        });
        ObjectAction.register(20285, 3271, 9235, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3270, 9235, 0, false, true, false);
        });
        ObjectAction.register(20284, 3271, 9235, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3272, 9235, 2, true, true, false);
        });
        ObjectAction.register(20286, 3257, 9225, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3268, 9228, 2, true, true, false);
        });
        ObjectAction.register(20287, 3268, 9229, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3257, 9226, 0, false, true, false);
        });
    }
}
