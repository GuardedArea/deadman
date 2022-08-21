package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Ardougne {

    static {
        ObjectAction.register(17384, 1, (player, obj) -> {
            if(obj.x == 2562 && obj.y == 3356) {
                Ladder.climb(player, 2563, 9756, 0, false, true, false);
            }
        });
        ObjectAction.register(17385, 1, (player, obj) -> {
            if(obj.x == 3209 && obj.y == 9616) {
                Ladder.climb(player, 2563, 3356, 0, true, true, false);
            }
        });
    }
}
