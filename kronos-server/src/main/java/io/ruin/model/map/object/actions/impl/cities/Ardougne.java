package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.api.utils.Random;
import io.ruin.model.entity.player.Player;
import io.ruin.model.entity.player.PlayerCounter;
import io.ruin.model.entity.shared.StepType;
import io.ruin.model.map.Bounds;
import io.ruin.model.map.object.GameObject;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;
import io.ruin.model.stat.StatType;

public class Ardougne {

    private static final int LOCKPICK = 1523;
    private static final Bounds CHAOS_DRUID_TOWER = new Bounds(2560, 3354, 2564, 3358, 0);
    private static final Bounds SOUTH_ARDOUGNE_CASTLE = new Bounds(2570, 3284, 2573, 3287, 1);
    private static final Bounds NORTH_ARDOUGNE_CASTLE = new Bounds(2570, 3306, 2573, 3309, 1);

    private static void openDoor(Player player, GameObject door, int stepX, int stepY, int openX, int openY, int openDirection, int yDif) {
        if (!player.getPosition().inBounds(CHAOS_DRUID_TOWER) && !player.getPosition().inBounds(SOUTH_ARDOUGNE_CASTLE) && !player.getPosition().inBounds(NORTH_ARDOUGNE_CASTLE)) {
            player.sendMessage("The door is locked.");
            return;
        }
        player.startEvent(event -> {
            player.lock();

            if (player.getAbsX() != door.x || player.getAbsY() != door.y + yDif) {
                player.stepAbs(door.x, door.y, StepType.FORCE_WALK);
                event.delay(1);
            }
            GameObject opened = GameObject.spawn(door.id, openX, openY, door.z, door.type, openDirection);
            door.skipClipping(true).remove();
            event.delay(1);
            player.stepAbs(stepX, stepY, StepType.FORCE_WALK);
            player.sendMessage("You go through the door.");
            event.delay(2);
            door.restore().skipClipping(false);
            opened.remove();

            player.unlock();
        });
    }

    private static void picklockDoor(Player player, GameObject door, int stepX, int stepY, int openX, int openY, int openDirection, boolean lockpickRequired) {
        if (player.getPosition().inBounds(CHAOS_DRUID_TOWER) || player.getPosition().inBounds(SOUTH_ARDOUGNE_CASTLE) || player.getPosition().inBounds(NORTH_ARDOUGNE_CASTLE)) {
            player.sendMessage("The door is already unlocked.");
            return;
        }
        if (!player.getStats().check(StatType.Thieving, 39, "pick lock this door"))
            return;
        if (!player.getInventory().hasId(LOCKPICK) && lockpickRequired) {
            player.sendMessage("You need a lockpick for this.");
            return;
        }
        player.sendMessage("You attempt to pick the lock.");
        if (Random.rollDie(2, 1)) {
            player.sendMessage("You manage to pick the lock.");
            PlayerCounter.PICKED_LOCKS.increment(player, 1);

            player.startEvent(event -> {
                player.lock();

                if (player.getAbsX() != door.x || player.getAbsY() != door.y) {
                    player.stepAbs(door.x, door.y, StepType.FORCE_WALK);
                    event.delay(1);
                }
                GameObject opened = GameObject.spawn(door.id, openX, openY, door.z, door.type, openDirection);
                door.skipClipping(true).remove();
                player.stepAbs(stepX, stepY, StepType.FORCE_WALK);
                player.sendMessage("You go through the door.");
                player.getStats().addXp(StatType.Thieving, 22.0, false);
                event.delay(2);
                door.restore().skipClipping(false);
                opened.remove();

                player.unlock();
            });
            return;
        }
        player.sendMessage("You fail to the pick lock.");

    }

    static {
        ObjectAction.register(11723, 2565, 3356, 0, "open", (player, obj) -> openDoor(player, obj, 2565, 3356, 2564, 3356, 3, + 1));
        ObjectAction.register(11723, 2565, 3356, 0, "pick-lock", (player, obj) -> picklockDoor(player, obj, 2564, 3356, 2564, 3356, 3, true));//Chaos druid tower lockpick door

        ObjectAction.register(11724, 2572, 3305, 1, "open", (player, obj) -> openDoor(player, obj, 2572, 3305, 2572, 3306, 2, + 1));
        ObjectAction.register(11724, 2572, 3305, 1, "pick-lock", (player, obj) -> picklockDoor(player, obj, 2572, 3306, 2572, 3306, 2, false));//North ardougne castle picklock door

        ObjectAction.register(11724, 2572, 3288, 1, "open", (player, obj) -> openDoor(player, obj, 2572, 3288, 2572, 3287, 2, + 1));
        ObjectAction.register(11724, 2572, 3288, 1, "pick-lock", (player, obj) -> picklockDoor(player, obj, 2572, 3287, 2572, 3287, 2, false));//South ardougne castle picklock door

        ObjectAction.register(17384, 2562, 3356, 0, "climb-down", (player, obj) -> Ladder.climb(player, 2563, 9756, 0, false, true, false));
        ObjectAction.register(17385, 2562, 9756, 0, "climb-up", (player, obj) -> Ladder.climb(player, 2563, 3356, 0, false, true, false));
    }
}
