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

        /*
        Fishing guild goblin cave
         */
        ObjectAction.register(2, 2622, 3392, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2619, 9797, 0);
        });
        ObjectAction.register(13, 2621, 9796, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2623, 3391, 0);
        });
        /*
        Ship to brimhaven
         */
        ObjectAction.register(2085, 2683, 3270, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2683, 3268, 1);
        });
        ObjectAction.register(2086, 2683, 3269, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2683, 3271, 0);
        });
        ObjectAction.register(9745, 2682, 3267, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2683, 3267, 0, false, true, false);
        });
        ObjectAction.register(9744, 2682, 3267, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2683, 3267, 1, true, true, false);
        });
        /*
        Tower of life
         */
        ObjectAction.register(21944, 2648, 3212, 0, 1, (player, obj) -> {
            Ladder.climb(player, 3038, 4376, 0, false, true, false);
        });
        ObjectAction.register(17974, 3038, 4375, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2649, 3212, 0, true, true, false);
        });
        /*
        Clocktower
         */
        ObjectAction.register(17384, 2621, 3261, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2621, 9660, 0, false, true, false);
        });
        ObjectAction.register(17385, 2621, 9661, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2621, 3260, 0, true, true, false);
        });
        ObjectAction.register(17385, 2572, 9631, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2573, 3231, 0, true, true, false);
        });
        ObjectAction.register(17384, 2572, 3227, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2572, 9628, 0, false, true, false);
        });
        ObjectAction.register(17385, 2572, 9627, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2572, 3228, 0, true, true, false);
        });
        ObjectAction.register(17384, 2569, 3227, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2569, 9628, 0, false, true, false);
        });
        ObjectAction.register(17385, 2569, 9627, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2569, 3228, 0, true, true, false);
        });
        ObjectAction.register(17385, 2566, 9627, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2566, 3228, 0, true, true, false);
        });
        ObjectAction.register(17384, 2566, 3227, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2566, 9628, 0, false, true, false);
        });
        ObjectAction.register(17385, 2566, 9631, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2566, 3230, 0, true, true, false);
        });
        ObjectAction.register(17384, 2566, 3231, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2566, 9630, 0, false, true, false);
        });
        ObjectAction.register(17384, 2569, 3231, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2569, 9630, 0, false, true, false);
        });
        ObjectAction.register(17385, 2569, 9631, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2569, 3230, 0, true, true, false);
        });
        ObjectAction.register(17384, 2566, 3242, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2566, 9641, 0, false, true, false);
        });
        ObjectAction.register(17385, 2566, 9642, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2566, 3241, 0, true, true, false);
        });
        ObjectAction.register(17385, 2561, 9622, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2561, 3221, 0, true, true, false);
        });

        /*
        Hazeel cave
         */

        ObjectAction.register(2852, 2585, 3233, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2570, 9682, 0);
        });
        ObjectAction.register(2853, 2570, 9683, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2587, 3237, 0, true, true, false);
        });
        ObjectAction.register(2849, 2578, 9686, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2567, 9680, 0);
        });
        ObjectAction.register(2849, 2567, 9679, 0, 1, (player, obj) -> {
            //TODO: Idk if we want to keep this randomized... in the real game it is based on the water level set by the valves
            if(Random.get(0, 1) == 0) {
                player.getMovement().teleport(2578, 9687, 0);
            } else {
                player.getMovement().teleport(2606, 9691, 0);
            }
        });
        ObjectAction.register(2849, 2606, 9693, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2567, 9680, 0);
        });
        ObjectAction.register(17384, 2570, 3267, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2570, 9668, 0, false, true, false);
        });
        ObjectAction.register(17385, 2570, 9667, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2570, 3268, 0, true, true, false);
        });
        /*
        Observatory quest dungeon
         */

        ObjectAction.register(25432, 2458, 3186, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2355, 9394, 0, false, false, false);
        });
        ObjectAction.register(25429, 2355, 9395, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2458, 3185, 0);
        });
        ObjectAction.register(25429, 2335, 9351, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2438, 3163, 0);
        });
        ObjectAction.register(25434, 2438, 3164, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2335, 9350, 0, false, true, false);
        });
        ObjectAction.register(25431, 2444, 3159, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2442, 3159, 1, true, false, false);
        });
        ObjectAction.register(25437, 2443, 3159, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2444, 3162, 0, false, false, false);
        });
        /*
        Watchtower dungeon
         */
        ObjectAction.register(2804, 2504, 3037, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2588, 9410, 0);
        });
        ObjectAction.register(2813, 2598, 9468, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2540, 3054, 0);
        });
        /*
        Watchtower ogre island shortcut
         */
        ObjectAction.register(2811, 2499, 2989, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2576, 3029, 0);
        });
        ObjectAction.register(2812, 2575, 3029, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2500, 2988, 0, false, true, false);
        });

    }
}
