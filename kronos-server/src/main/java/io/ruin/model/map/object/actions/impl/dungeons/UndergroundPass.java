package io.ruin.model.map.object.actions.impl.dungeons;

import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.map.object.actions.impl.Ladder;

public class UndergroundPass {

    static {
        /*
        Underground pass
         */
        ObjectAction.register(4006, 2313, 3215, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2314, 9624, 0);
        });
        ObjectAction.register(4007, 2312, 9623, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2312, 3216, 0);
        });
        ObjectAction.register(4005, 2341, 9622, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2010, 4712, 1, false, true, false);
        });
        ObjectAction.register(4004, 2008, 4711, 1, 1, (player, obj) -> {
            Ladder.climb(player, 2343, 9622, 0, false, true, false);
        });
        ObjectAction.register(3333, 2015, 4712, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2145, 4647, 1);
        });
        ObjectAction.register(3333, 2143, 4648, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2014, 4712, 1);
        });
        ObjectAction.register(3334, 2015, 4711, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2145, 4647, 1);
        });
        ObjectAction.register(3334, 2143, 4647, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2014, 4711, 1);
        });
        /*
        Underground pass jumps... TODO: Animating
         */
        ObjectAction.register(3255, 2161, 4654, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2161, 4653, 1);
            } else {
                player.getMovement().teleport(2161, 4657, 1);
            }
        });
        ObjectAction.register(3254, 2162, 4663, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2162, 4666, 1);
            } else {
                player.getMovement().teleport(2162, 4662, 1);
            }
        });
        ObjectAction.register(3254, 2154, 4690, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2154, 4689, 1);
            } else {
                player.getMovement().teleport(2154, 4693, 1);
            }
        });
        ObjectAction.register(3255, 2164, 4686, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2163, 4686, 1);
            } else {
                player.getMovement().teleport(2167, 4686, 1);
            }
        });
        ObjectAction.register(3255, 2155, 4704, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2155, 4703, 1);
            } else {
                player.getMovement().teleport(2155, 4707, 1);
            }
        });
        ObjectAction.register(3254, 2155, 4718, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2155, 4717, 1);
            } else {
                player.getMovement().teleport(2155, 4721, 1);
            }
        });
        ObjectAction.register(3254, 2158, 4724, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2157, 4724, 1);
            } else {
                player.getMovement().teleport(2161, 4724, 1);
            }
        });
        ObjectAction.register(3254, 2145, 4717, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2145, 4716, 1);
            } else {
                player.getMovement().teleport(2145, 4720, 1);
            }
        });
        ObjectAction.register(3255, 2121, 4686, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2120, 4686, 1);
            } else {
                player.getMovement().teleport(2124, 4686, 1);
            }
        });
        ObjectAction.register(3254, 2161, 4637, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2161, 4636, 1);
            } else {
                player.getMovement().teleport(2161, 4640, 1);
            }
        });
        ObjectAction.register(3255, 2160, 4625, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2160, 4624, 1);
            } else {
                player.getMovement().teleport(2160, 4628, 1);
            }
        });
        ObjectAction.register(3254, 2148, 4614, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2147, 4614, 1);
            } else {
                player.getMovement().teleport(2151, 4614, 1);
            }
        });
        ObjectAction.register(3255, 2161, 4599, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2161, 4598, 1);
            } else {
                player.getMovement().teleport(2161, 4602, 1);
            }
        });
        ObjectAction.register(3254, 2127, 4610, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2126, 4610, 1);
            } else {
                player.getMovement().teleport(2130, 4610, 1);
            }
        });
        ObjectAction.register(3255, 2123, 4616, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2123, 4615, 1);
            } else {
                player.getMovement().teleport(2123, 4619, 1);
            }
        });
        ObjectAction.register(3255, 2143, 4604, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2142, 4604, 1);
            } else {
                player.getMovement().teleport(2146, 4604, 1);
            }
        });
        ObjectAction.register(3254, 2127, 4592, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2127, 4591, 1);
            } else {
                player.getMovement().teleport(2127, 4595, 1);
            }
        });
        ObjectAction.register(3255, 2123, 4582, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2123, 4581, 1);
            } else {
                player.getMovement().teleport(2123, 4585, 1);
            }
        });
        ObjectAction.register(3255, 2126, 4566, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2125, 4566, 1);
            } else {
                player.getMovement().teleport(2129, 4566, 1);
            }
        });
        ObjectAction.register(3254, 2142, 4562, 1, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2142, 4561, 1);
            } else {
                player.getMovement().teleport(2142, 4565, 1);
            }
        });
        ObjectAction.register(3254, 2136, 4584, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2135, 4584, 1);
            } else {
                player.getMovement().teleport(2139, 4584, 1);
            }
        });
        ObjectAction.register(3255, 2147, 4583, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2146, 4583, 1);
            } else {
                player.getMovement().teleport(2150, 4583, 1);
            }
        });
        ObjectAction.register(3255, 2156, 4582, 1, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2155, 4582, 1);
            } else {
                player.getMovement().teleport(2159, 4582, 1);
            }
        });
        ObjectAction.register(3223, 2336, 9793, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2150, 4546, 1);
        });
        ObjectAction.register(3222, 2150, 4545, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2336, 9794, 0);
        });
        ObjectAction.register(3223, 2304, 9915, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2113, 4729, 1);
        });
        ObjectAction.register(3222, 2112, 4729, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2305, 9915, 0);
        });
        ObjectAction.register(3221, 2174, 4724, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2370, 9719, 0);
        });
        ObjectAction.register(3220, 2368, 9717, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2173, 4725, 1);
        });
        ObjectAction.register(3220, 2174, 4726, 1, 1, (player, obj) -> {
            player.getMovement().teleport(2370, 9719, 0);
        });
        ObjectAction.register(3221, 2368, 9719, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2173, 4725, 1);
        });
        ObjectAction.register(3219, 2371, 9665, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2376, 9610, 0);
        });
        ObjectAction.register(3218, 2376, 9611, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2371, 9666, 0);
        });
        ObjectAction.register(3218, 2370, 9665, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2376, 9610, 0);
        });
        ObjectAction.register(3219, 2375, 9611, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2371, 9666, 0);
        });
        ObjectAction.register(3237, 2417, 9605, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2387, 9605, 0);
        });
        ObjectAction.register(3237, 2388, 9605, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2419, 9605, 0);
        });
        ObjectAction.register(3268, 2404, 9620, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() >= obj.getPosition().getX()) {
                player.getMovement().teleport(2403, 9620, 0);
            } else {
                player.getMovement().teleport(2404, 9620, 0);
            }
        });
        ObjectAction.register(3268, 2380, 9619, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() <= obj.getPosition().getX()) {
                player.getMovement().teleport(2381, 9619, 0);
            } else {
                player.getMovement().teleport(2380, 9619, 0);
            }
        });
        ObjectAction.register(3238, 2374, 9639, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2375, 9644, 0);
        });
        ObjectAction.register(3238, 2374, 9644, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2374, 9638, 0);
        });
        ObjectAction.register(3217, 2392, 9647, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2393, 9651, 0);
        });
        ObjectAction.register(3216, 2393, 9650, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2392, 9646, 0);
        });
        ObjectAction.register(3266, 2393, 9655, 0, 1, (player, obj) -> {
            if (player.getPosition().getY() >= obj.getPosition().getY()) {
                player.getMovement().teleport(2393, 9654, 0);
            } else {
                player.getMovement().teleport(2393, 9655, 0);
            }
        });
        ObjectAction.register(3307, 2423, 9661, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2418, 9674, 0);
        });
        ObjectAction.register(3264, 2416, 9674, 0, 1, (player, obj) -> {
            Ladder.climb(player, 2423, 9660, 0, false, true, false);
        });
        ObjectAction.register(3235, 2451, 9689, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2451, 9694, 0);
        });
        ObjectAction.register(3337, 2466, 9672, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2464, 9676, 0);
        });
        ObjectAction.register(3309, 2482, 9679, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2481, 9679, 0);
            } else {
                player.getMovement().teleport(2483, 9679, 0);
            }
        });
        ObjectAction.register(3309, 2491, 9691, 0, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2491, 9690, 0);
            } else {
                player.getMovement().teleport(2491, 9692, 0);
            }
        });
        ObjectAction.register(23123, 2461, 9692, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2460, 9692, 0);
        });
        ObjectAction.register(23124, 2462, 9700, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2466, 9699, 0);
        });
        ObjectAction.register(3241, 2436, 9716, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2447, 9716, 0);
        });
        ObjectAction.register(35938, 2452, 9715, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2442, 9716, 0);
        });
        ObjectAction.register(3309, 2458, 9712, 0, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2458, 9711, 0);
            } else {
                player.getMovement().teleport(2458, 9713, 0);
            }
        });
        ObjectAction.register(3309, 2460, 9720, 0, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2460, 9719, 0);
            } else {
                player.getMovement().teleport(2460, 9721, 0);
            }
        });
        ObjectAction.register(3309, 2467, 9723, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2466, 9723, 0);
            } else {
                player.getMovement().teleport(2468, 9723, 0);
            }
        });
        ObjectAction.register(3309, 2467, 9723, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2466, 9723, 0);
            } else {
                player.getMovement().teleport(2468, 9723, 0);
            }
        });
        ObjectAction.register(3309, 2478, 9721, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2477, 9721, 0);
            } else {
                player.getMovement().teleport(2479, 9721, 0);
            }
        });
        ObjectAction.register(3309, 2478, 9724, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2477, 9724, 0);
            } else {
                player.getMovement().teleport(2479, 9724, 0);
            }
        });
        ObjectAction.register(3309, 2485, 9721, 0, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2485, 9720, 0);
            } else {
                player.getMovement().teleport(2485, 9722, 0);
            }
        });
        ObjectAction.register(3309, 2480, 9713, 0, 1, (player, obj) -> {
            if (player.getPosition().getY() > obj.getPosition().getY()) {
                player.getMovement().teleport(2480, 9712, 0);
            } else {
                player.getMovement().teleport(2480, 9714, 0);
            }
        });
        ObjectAction.register(3309, 2471, 9706, 0, 1, (player, obj) -> {
            if (player.getPosition().getX() > obj.getPosition().getX()) {
                player.getMovement().teleport(2470, 9706, 0);
            } else {
                player.getMovement().teleport(2472, 9706, 0);
            }
        });
        ObjectAction.register(3214, 2496, 9713, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2436, 3315, 0);
        });
        ObjectAction.register(3213, 2433, 3313, 0, 1, (player, obj) -> {
            player.getMovement().teleport(2495, 9716, 0);
        });
    }
}
