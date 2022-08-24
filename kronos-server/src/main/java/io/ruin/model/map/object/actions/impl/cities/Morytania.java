package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.entity.shared.LockType;
import io.ruin.model.entity.shared.StepType;
import io.ruin.model.inter.InterfaceType;
import io.ruin.model.map.Direction;
import io.ruin.model.map.object.GameObject;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Door;
import io.ruin.model.map.object.actions.impl.Ladder;

public class Morytania {
    static {
        ObjectAction.register(5003, 3502, 3426, 0, 2, (player, obj) -> {
            player.startEvent(e -> {
                player.lock(LockType.FULL_DELAY_DAMAGE);
                player.animate(828);
                e.delay(1);
                player.getMovement().teleport(3502, 3427, 0);
                e.delay(1);
                player.animate(824);
                player.getMovement().force(0, 3, 0, 0, 1, 60, Direction.NORTH);
                e.delay(3);
                player.animate(828);
                e.delay(1);
                player.getMovement().teleport(3502, 3432, 0);
                player.unlock();
            });
        });
        ObjectAction.register(5003, 3502, 3431, 0, 2, (player, obj) -> {
            player.startEvent(e -> {
                player.lock(LockType.FULL_DELAY_DAMAGE);
                player.animate(828);
                e.delay(1);
                player.getMovement().teleport(3502, 3430, 0);
                e.delay(1);
                player.animate(824);
                player.getMovement().force(0, -3, 0, 0, 1, 60, Direction.SOUTH);
                e.delay(3);
                player.animate(828);
                e.delay(1);
                player.getMovement().teleport(3502, 3425, 0);
                player.unlock();
            });
        });
        ObjectAction.register(5056, 3500, 9812, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3509, 3449, 0);
        });
        ObjectAction.register(5061, 3509, 3447, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3500, 9811, 0);
        });
        ObjectAction.register(5057, 3501, 9812, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3509, 3449, 0);
        });
        ObjectAction.register(5060, 3510, 3447, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3500, 9811, 0);
        });
        ObjectAction.register(5046, 3492, 9823, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3505, 9832, 0);
        });
        ObjectAction.register(5050, 3492, 9824, 0, 2, (player, obj) -> {
            player.getMovement().teleport(3505, 9832, 0);
        });
        ObjectAction.register(5046, 3505, 9831, 0, 1, (player, obj) -> {
            player.getMovement().teleport(3491, 9824, 0);
        });
        ObjectAction.register(5052, 3480, 9837, 0, 1, (player, obj) -> {
            player.startEvent(event -> {
                player.lock();
                if (player.getAbsX() != obj.x || player.getAbsY() != obj.y + (obj.y > player.getAbsY() ? -1 : 0)) {
                    player.stepAbs(obj.x, obj.y + (obj.y > player.getAbsY() ? -1 : 0), StepType.FORCE_WALK);
                    event.delay(1);
                }
                GameObject opened = GameObject.spawn(5052, 3480, 9836, 0, obj.type, 0);
                obj.skipClipping(true).remove();
                player.stepAbs(player.getAbsX(), obj.y + (obj.y > player.getAbsY() ? 0 : -1), StepType.FORCE_WALK);
                player.sendFilteredMessage("You unlock the door.");//TODO: Real message
                event.delay(2);
                obj.restore().skipClipping(false);
                opened.remove();
                GameObject.spawn(5052, 3480, 9837, 0, obj.type, obj.direction);

                player.unlock();
            });
        });
        ObjectAction.register(5054, 3477, 9846, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3495, 3465, 0, true, true, false);
        });
        ObjectAction.register(5055, 3495, 3464, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3477, 9845, 0, false, true, false);
        });
        ObjectAction.register(6970, 3498, 3377, 0, 1, (player, obj) -> {
            player.startEvent(event -> {
                player.openInterface(InterfaceType.MAIN, 321);
                event.delay(5);
                player.getMovement().teleport(3522, 3285, 0);
            });
        });
        ObjectAction.register(6969, 3523, 3284, 0, 1, (player, obj) -> {
            player.startEvent(event -> {
                player.openInterface(InterfaceType.MAIN, 321);
                event.delay(5);
                player.getMovement().teleport(3522, 3285, 0);
            });
            player.getMovement().teleport(3498, 3380, 0);
        });
    }
}
