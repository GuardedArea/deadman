package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Jiggig {

    static {
        ObjectAction.register(6842, 2478, 9437, 2, 1, (player, obj) -> {
            Ladder.climb(player, 2485, 3045, 0, true, true, false);
        });
        //TODO: Autogenerated action needs animations and graphics
        ObjectAction.register(6841, 2485, 3042, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2477, 9437, 2, false, true, false);
        });
        //TODO: Autogenerated action needs animations and graphics
    }
}