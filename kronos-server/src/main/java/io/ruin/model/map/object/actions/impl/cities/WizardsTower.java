package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class WizardsTower {

    static {
        ObjectAction.register(2147, 3104, 3162, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3104, 9576, 0, false, false, false);
        });
        ObjectAction.register(2148, 3103, 9576, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3105, 3162, 0, true, false, false);
        });
    }
}
