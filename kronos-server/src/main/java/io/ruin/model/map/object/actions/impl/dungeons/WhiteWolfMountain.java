package io.ruin.model.map.object.actions.impl.dungeons;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class WhiteWolfMountain {
    static {
        /*
        Ice Queen Lair
         */
        ObjectAction.register(16680, 2827, 3510, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2827, 9908, 0, false, true, false);
        });
        ObjectAction.register(17385, 2827, 9910, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2827, 3509, 0, true, true, false);
        });
        ObjectAction.register(16680, 2824, 3507, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2824, 9908, 0, false, true, false);
        });
        ObjectAction.register(17385, 2824, 9907, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2824, 3508, 0, true, true, false);
        });
        ObjectAction.register(16680, 2823, 3513, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2822, 9913, 0, false, true, false);
        });
        ObjectAction.register(17385, 2823, 9913, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2822, 3513, 0, true, true, false);
        });
        ObjectAction.register(16680, 2845, 3516, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2846, 9915, 0, false, true, false);
        });
        ObjectAction.register(17385, 2845, 9916, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2846, 3516, 0, true, true, false);
        });
        ObjectAction.register(16680, 2848, 3513, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2847, 9913, 0, false, true, false);
        });
        ObjectAction.register(17385, 2848, 9913, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2847, 3513, 0, true, true, false);
        });
        ObjectAction.register(16680, 2848, 3519, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2847, 9919, 0, false, true, false);
        });
        ObjectAction.register(17385, 2848, 9919, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2847, 3519, 0, true, true, false);
        });
        ObjectAction.register(16680, 2857, 3517, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2858, 9917, 0, false, true, false);
        });
        ObjectAction.register(17385, 2857, 9917, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2858, 3517, 0, true, true, false);
        });
        ObjectAction.register(16680, 2859, 3519, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2858, 9919, 0, false, true, false);
        });
        ObjectAction.register(17385, 2859, 9919, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2858, 3519, 0, true, true, false);
        });
        ObjectAction.register(17385, 2823, 9930, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2823, 3529, 0, true, true, false);
        });
        ObjectAction.register(17385, 2837, 9927, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2837, 3526, 0, true, true, false);
        });
        ObjectAction.register(17385, 2845, 9925, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2845, 3526, 0, true, true, false);
        });
    }
}
