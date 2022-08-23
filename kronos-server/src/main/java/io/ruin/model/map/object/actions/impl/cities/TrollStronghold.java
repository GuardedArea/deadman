package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class TrollStronghold {
    static {
        /*
        Entrance
         */
        ObjectAction.register(3771, 2839, 3689, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2837, 10090, 2);
        });
        ObjectAction.register(3774, 2838, 10090, 2, 1, (player, obj) -> {
            player.getMovement().teleport(2840, 3690, 0);
        });
        /*
        Staircases
         */
        ObjectAction.register(3789, 2843, 10108, 2, 1, (player, obj) -> {
            Ladder.climb(player, 2841, 10108, 1, false, true, false);
        });
        ObjectAction.register(3788, 2842, 10108, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2845, 10108, 2, true, true, false);
        });
        ObjectAction.register(3789, 2852, 10107, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2852, 10105, 0, false, true, false);
        });
        ObjectAction.register(3788, 2852, 10106, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2852, 10109, 1, true, true, false);
        });
        ObjectAction.register(3789, 2852, 10061, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2852, 10064, 0, false, true, false);
        });
        ObjectAction.register(3788, 2852, 10061, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2852, 10060, 1, true, true, false);
        });
        ObjectAction.register(3788, 2842, 10051, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2845, 10051, 2, true, true, false);
        });
        ObjectAction.register(3789, 2843, 10051, 2, 1, (player, obj) -> {
            Ladder.climb(player, 2841, 10051, 1, false, true, false);
        });
        /*
        Farm patch
         */
        ObjectAction.register(18834, 2831, 10077, 2, 1, (player, obj) -> {
            Ladder.climb(player, 2831, 3676, 0, true, true, false);
        });
        ObjectAction.register(18833, 2831, 3677, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2831, 10076, 2, false, true, false);
        });
        /*
        Secret door
         */
        ObjectAction.register(3761, 2823, 10048, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2827, 3646, 0);
        });
        ObjectAction.register(3762, 2827, 3647, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2823, 10050, 0);
        });
        /*
        Trollweiss
         */
        ObjectAction.register(5007, 2820, 3743, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2803, 10187, 0);
        });
        ObjectAction.register(5011, 2802, 10185, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2822, 3744, 0);
        });
        ObjectAction.register(5012, 2795, 3717, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2799, 10134, 0);
        });
        ObjectAction.register(5013, 2798, 10135, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2797, 3719, 0);
        });
        ObjectAction.register(5025, 2772, 10233, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2778, 3869, 0);
        });
        ObjectAction.register(5009, 2779, 3868, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2772, 10231, 0);
        });
    }
}
