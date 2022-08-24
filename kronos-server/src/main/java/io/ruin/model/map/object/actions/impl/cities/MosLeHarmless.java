package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class MosLeHarmless {
    static {
        ObjectAction.register(3650, 3748, 2973, 0, 2, (player, obj) -> {
            player.getMovement().teleport(3748, 9373, 0);
        });
        ObjectAction.register(5553, 3749, 9373, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3749, 2973, 0);
        });
        ObjectAction.register(22173, 3789, 2826, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3788, 9226, 0, false, true, false);
        });
        ObjectAction.register(22172, 3789, 9226, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3788, 2826, 0, true, true, false);
        });
        ObjectAction.register(22355, 3795, 2844, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3785, 9254, 0, false, true, false);
        });
        ObjectAction.register(22371, 3784, 9254, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3796, 2843, 0);
        });
        ObjectAction.register(22365, 3788, 9254, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3787, 9254, 1);
        });
        ObjectAction.register(22367, 3785, 9254, 1, 1, (player, obj) -> {
            player.getMovement().teleport(3787, 9254, 0);
        });
        ObjectAction.register(22365, 3788, 9254, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3787, 9254, 1);
        });
        ObjectAction.register(22370, 3829, 9254, 1, 2, (player, obj) -> {
            player.getMovement().teleport(3828, 9254, 0);
        });
        ObjectAction.register(22372, 3831, 9254, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3819, 2844, 0);
        });
        ObjectAction.register(22164, 3819, 2843, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3830, 9254, 0, false, true, false);
        });
        ObjectAction.register(22366, 3827, 9254, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3828, 9254, 1);
        });
        ObjectAction.register(22250, 3798, 2873, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3796, 2873, 2, true, true, false);
        });
        ObjectAction.register(22252, 3797, 2873, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3799, 2873, 1, false, true, false);
        });
        ObjectAction.register(22248, 3798, 2874, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3796, 2874, 2, true, true, false);
        });
        ObjectAction.register(22254, 3797, 2874, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3799, 2874, 1, false, true, false);
        });
        ObjectAction.register(22247, 3798, 2872, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3796, 2872, 2, true, true, false);
        });
        ObjectAction.register(22253, 3797, 2872, 2, 1, (player, obj) -> {
            Ladder.climb(player, 3799, 2872, 1, false, true, false);
        });
        ObjectAction.register(22274, 3802, 2873, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3802, 2872, 1, true, true, false);
        });
        ObjectAction.register(22275, 3802, 2873, 1, 1, (player, obj) -> {
            Ladder.climb(player, 3802, 2872, 0, false, true, false);
        });

    }
}
