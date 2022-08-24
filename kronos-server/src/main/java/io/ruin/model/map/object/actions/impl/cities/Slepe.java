package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Slepe {
    static {
        ObjectAction.register(32637, 3728, 3300, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3728, 9702, 1, false, true, false);
        });
        ObjectAction.register(32638, 3728, 9701, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3728, 3301, 1, true, true, false);
        });
        ObjectAction.register(32644, 3719, 9707, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3720, 3307, 1, true, true, false);
        });
        ObjectAction.register(32643, 3719, 3307, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3718, 9707, 0, false, true, false);
        });
        ObjectAction.register(32641, 3726, 3356, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3727, 9756, 0, false, true, false);
        });
        ObjectAction.register(32642, 3726, 9756, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3725, 3356, 0, false, true, false);
        });

    }
}
