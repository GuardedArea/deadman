package io.ruin.model.skills.thieving;

import io.ruin.api.utils.Random;
import io.ruin.model.World;
import io.ruin.model.combat.Hit;
import io.ruin.model.entity.player.Player;
import io.ruin.model.entity.player.PlayerCounter;
import io.ruin.model.inter.dialogue.MessageDialogue;
import io.ruin.model.item.Item;
import io.ruin.model.item.actions.impl.Pet;
import io.ruin.model.item.loot.LootItem;
import io.ruin.model.item.loot.LootTable;
import io.ruin.model.map.Bounds;
import io.ruin.model.map.object.GameObject;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.model.skills.BotPrevention;
import io.ruin.model.stat.StatType;

public enum Chest {

    CHEST_10_COINS(13, 7, 7.8, 52000, "Chest (10 coins)",
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {11735, 11743}
            },
            false,
            null,
            new LootTable().addTable(1,
                    new LootItem(995, 10, 1)//COINS
            )),
    CHEST_NATURE_RUNES(28, 8, 25.0, 18000, "Chest (nature runes)",
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {11736, 11743}
            },
            false,
            new Item(995, 3),
            new LootTable().addTable(1,
                    new LootItem(561, 1, 1)//COINS
            )),
    CHEST_50_COINS(43, 50, 125.0, 10000, "Chest (50 coins)",
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {11737, 11743}
            },
            false,
            null,
            new LootTable().addTable(1,
                    new LootItem(995, 50, 1)//COINS
            )),
    CHEST_ISLE_OF_SOULS_DUNGEON(43, 50, 125.0, 10000, "Chest (Isle of Souls Dungeon)",//Isn't in the current revision but figured I'd add it in advance
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {0, 11743}
            },
            false,
            null,
            new LootTable().addTable(1,
                    new LootItem(995, 50, 1)//COINS
            )),
    CHEST_STEEL_ARROWTIPS(47, 90, 150.0, 9000, "Chest (steel arrowtips)",
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {11742, 11743}
            },
            false,
            new Item(995, 20),
            new LootTable().addTable(1,
                    new LootItem(41, 5, 1)//COINS
            )),
    CHEST_DORGESH_KAAN_AVERAGE(52, 90, 200.0, 8000, "Chest (steel arrowtips)",//TODO: Add the zanik and oldak version of this chest (has the same id, so we would need to add something new to tell the difference)
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {22697, 22699}
            },
            true,
            null,
            new LootTable().addTable(1,
                    new LootItem(995, Random.get(1, 250), 3),//COINS
                    new LootItem(4537, 1, 1),//Oil lantern
                    new LootItem(4548, 1, 1),//Bullseye lantern
                    new LootItem(5014, 1, 1),//Mining helmet
                    new LootItem(10981, 1, 1)//Cave goblin wire
            )),
    CHEST_BLOOD_RUNES(59, 135, 250.0, 5000, "Chest (blood runes)",
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {11738, 11743}
            },
            true,
            new Item(995, 500),
            new LootTable().addTable(1,
                    new LootItem(565,2, 1)//BLOOD RUNES
            )),
    KING_LATHAS_CHEST(72, 500, 500.0, 3000, "Chest (ardougne castle)",
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {11739, 11743}
            },
            true,
            new Item(995, 1000),
            new LootTable().addTable(1,
                    new LootItem(383, 1, 1)//BLOOD RUNES
            )),
    STONE_CHEST(59, 2, 280.0, 10000, "Stone chest",
            PlayerCounter.CHEST_THIEVES,
            new int[][]{
                    {34429, 34430}
            },
            false,
            null,
            new LootTable().addTable(1,
                    new LootItem(995, Random.get(20, 260), 1)//COINS, TODO: Add entire loottable from https://oldschool.runescape.wiki/w/Stone_chest
            ).addTable(1,
                    new LootItem(360, 1, 1)));

    public final int levelReq, respawnTime, petOdds;
    public final int[][] objIDs;
    public final double experience;
    public final String name;
    public final LootTable lootTable;
    public final PlayerCounter counter;
    public final boolean lockpick;
    public final Item bloodMoneyReward;

    Chest(int levelReq, int respawnTime, double experience, int petOdds, String name, PlayerCounter counter, int[][] objIDs, boolean lockpick, Item bloodMoneyReward, LootTable lootTable) {
        this.levelReq = levelReq;
        this.respawnTime = respawnTime * 1000 / 600;
        this.experience = experience;
        this.petOdds = petOdds;
        this.name = name;
        this.counter = counter;
        this.objIDs = objIDs;
        this.lockpick = lockpick;
        this.bloodMoneyReward = bloodMoneyReward;
        this.lootTable = lootTable;
    }

    private static void open(Player player, Chest chest, GameObject object, int replacementID) {
        if (!player.getStats().check(StatType.Thieving, chest.levelReq, "open this chest."))
            return;
        if (player.getInventory().isFull()) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("Your inventory is too full to hold any more."));
            return;
        }

/*        if(player.getInventory().count(stall.bloodMoneyReward.getId()) >= BloodMoneyPouch.MAX_ALLOWED) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("You need to open the bloody pouches you have before attempting this."));
            return;
        }*/

        if(player.edgevilleStallCooldown.isDelayed())
            return;

        if(BotPrevention.isBlocked(player)) {
            player.sendMessage("You can't steal from a chest while a guard is watching you.");
            return;
        }

        player.startEvent(event -> {
            player.sendFilteredMessage("You have activated a trap on the chest");
            player.lock();
            player.animate(832);
            event.delay(1);
            int damage = (player.getHp() / 10) + 2;//I think all chests do the same damage... didn't test them all tho
            player.hit(new Hit().fixedDamage(damage).delay(0));
            player.unlock();
        });
    }
    private static void attempt(Player player, Chest chest, GameObject object, int replacementID) {
        if (!player.getStats().check(StatType.Thieving, chest.levelReq, "steal from the " + chest.name))
            return;
        if (player.getInventory().isFull()) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("Your inventory is too full to hold any more."));
            return;
        }

/*        if(player.getInventory().count(stall.bloodMoneyReward.getId()) >= BloodMoneyPouch.MAX_ALLOWED) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("You need to open the bloody pouches you have before attempting this."));
            return;
        }*/

        if(player.edgevilleStallCooldown.isDelayed())
            return;

        if(BotPrevention.isBlocked(player)) {
            player.sendMessage("You can't steal from a chest while a guard is watching you.");
            return;
        }

        player.startEvent(event -> {
            player.sendFilteredMessage("You search the chest for traps.");
            player.lock();
            player.animate(832);
            event.delay(1);
            player.sendFilteredMessage("You find a trap on the chest...");
            event.delay(1);
            player.sendFilteredMessage("You disable the trap.");
            event.delay(1);
            player.sendFilteredMessage("You open the chest");
            player.animate(832);
            event.delay(1);
            player.sendFilteredMessage("You find treasure inside!");
            if(chest.name.equals("Chest (blood runes)")) {
                event.delay(1);
                player.sendFilteredMessage("Suddenly a second magical trap triggers.");
                event.delay(1);
                player.getMovement().teleport(2584, 3337, 0);
            }
            if(chest.name.equals("Chest (ardougne castle)")) {
                event.delay(1);
                player.sendFilteredMessage("Suddenly a second magical trap triggers.");
                event.delay(1);
                player.getMovement().teleport(2696, 3281, 0);
                player.getInventory().add(new Item(449, 1));
                player.getInventory().add(new Item(1623, 1));
            }
            replaceChest(chest, object, replacementID, player);
            Item loot = chest.lootTable.rollItem();
            player.getInventory().add(loot);
            Item coins = chest.bloodMoneyReward;
            if(coins != null) {
                player.getInventory().add(coins);
            }
            if(player.getPosition().inBounds(HOME))
                player.edgevilleStallCooldown.delay(3);
            if (Random.rollDie(chest.petOdds))
                Pet.ROCKY.unlock(player);
            chest.counter.increment(player, 1);
            player.getStats().addXp(StatType.Thieving, chest.experience, true);
            BotPrevention.attemptBlock(player);
            player.unlock();
        });
    }
    private static void picklock(Player player, Chest chest, GameObject object, int replacementID) {
        if (!player.getStats().check(StatType.Thieving, chest.levelReq, "steal from the " + chest.name))
            return;
        if (player.getInventory().isFull()) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("Your inventory is too full to hold any more."));
            return;
        }

/*        if(player.getInventory().count(stall.bloodMoneyReward.getId()) >= BloodMoneyPouch.MAX_ALLOWED) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("You need to open the bloody pouches you have before attempting this."));
            return;
        }*/

        if(player.edgevilleStallCooldown.isDelayed())
            return;

        if(BotPrevention.isBlocked(player)) {
            player.sendMessage("You can't steal from a chest while a guard is watching you.");
            return;
        }

        player.startEvent(event -> {
            player.sendFilteredMessage("You attempt to pick the lock.");
            if(!player.getInventory().contains(1523) && chest.lockpick) {
                player.sendFilteredMessage("You need a lockpick to open this chest.");//TODO: Check what the real message is
                return;
            }
            player.lock();
            player.sendFilteredMessage("You manage to pick the lock.");
            event.delay(1);
            player.sendFilteredMessage("You open the chest");
            event.delay(1);
            player.animate(832);
            player.sendFilteredMessage("You find treasure inside!");
            replaceChest(chest, object, replacementID, player);
            Item loot = chest.lootTable.rollItem();
            player.getInventory().add(loot);
            Item coins = chest.bloodMoneyReward;
            if(coins != null) {
                player.getInventory().add(coins);
            }
            if(player.getPosition().inBounds(HOME))
                player.edgevilleStallCooldown.delay(3);
            if (Random.rollDie(chest.petOdds))
                Pet.ROCKY.unlock(player);
            chest.counter.increment(player, 1);
            player.getStats().addXp(StatType.Thieving, chest.experience, true);
            BotPrevention.attemptBlock(player);
            player.unlock();
        });
    }
    private static void picklockStoneChest(Player player, Chest chest, GameObject object, int replacementID) {
        if (!player.getStats().check(StatType.Thieving, chest.levelReq, "steal from the " + chest.name))
            return;
        if (player.getInventory().isFull()) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("Your inventory is too full to hold any more."));
            return;
        }

/*        if(player.getInventory().count(stall.bloodMoneyReward.getId()) >= BloodMoneyPouch.MAX_ALLOWED) {
            player.privateSound(2277);
            player.dialogue(new MessageDialogue("You need to open the bloody pouches you have before attempting this."));
            return;
        }*/

        if(player.edgevilleStallCooldown.isDelayed())
            return;

        if(BotPrevention.isBlocked(player)) {
            player.sendMessage("You can't steal from a chest while a guard is watching you.");
            return;
        }

        player.startEvent(event -> {
            player.animate(832);
            player.sendFilteredMessage("You attempt to picklock the chest.");
            player.lock();
            double succesChance = 0.3125;
            if(player.debug) {
                player.sendMessage("Succes chance: " + succesChance);
            }
            succesChance = succesChance + (0.008371 * (player.getStats().get(StatType.Thieving).currentLevel - 64));//Not the actual formula but a rough estimate on what it does
            if(player.debug) {
                player.sendMessage("Succes chance after initial multiplier based on lvl: " + succesChance);
            }
            if(player.getInventory().contains(1523)) {
                //Player has a lockpick so increase the multiplier
                succesChance += 0.1;
            }
            if(player.debug) {
                player.sendMessage("Succes chance after lockpick multiplier: " + succesChance);
            }
            succesChance = succesChance * 10000;
            int stoneChestRoll = Random.get(0, 10000);
            if(stoneChestRoll > succesChance) {
                if(player.debug) {
                    player.sendMessage("Failed at the stone chest roll (" + stoneChestRoll + ") with a : " + succesChance);
                }
                event.delay(1);
                player.sendFilteredMessage("You fail to picklock the chest.");
                if(Random.get(0, 8) != 8) {
                    player.sendFilteredMessage("TPING...?");
                    player.animate(3865);
                    player.graphics(1612);
                    event.delay(1);
                    player.sendMessage("You have activated a trap on the chest.");
                    event.delay(2);
                    player.getMovement().teleport(Random.get(1307, 1310), Random.get(3676, 3682), 0);
                }
            } else {
                if (player.debug) {
                    player.sendMessage("Succeeded at the stone chest roll (" + stoneChestRoll + ") with a : " + succesChance);
                }
                //TODO: add chance formula from wiki instead of 100% success
                event.delay(1);
                player.sendFilteredMessage("You manage to unlock the chest.");
                event.delay(1);
                player.sendFilteredMessage("You steal some loot from the chest.");
                player.animate(832);
                replaceChest(chest, object, replacementID, player);
                Item loot = chest.lootTable.rollItem();
                player.getInventory().add(loot);
                Item coins = chest.bloodMoneyReward;
                if (coins != null) {
                    player.getInventory().add(coins);
                }
                if (player.getPosition().inBounds(HOME))
                    player.edgevilleStallCooldown.delay(3);
                if (Random.rollDie(chest.petOdds))
                    Pet.ROCKY.unlock(player);
                chest.counter.increment(player, 1);
                player.getStats().addXp(StatType.Thieving, chest.experience, true);
            }
            BotPrevention.attemptBlock(player);
            player.unlock();
        });
    }

    private static final Bounds HOME = new Bounds(2002, 3558, 2017, 3573, -1);

    private static void replaceChest(Chest chest, GameObject object, int replacementID, Player player) {
        World.startEvent(e -> {
            if (!player.getPosition().inBounds(HOME)) {
                object.setId(replacementID);
                e.delay(chest.respawnTime);
                object.setId(object.originalId);
            }
        });
    }

    static {
        for (Chest chest : values()) {
            for (int[] ids : chest.objIDs) {
                ObjectAction.register(ids[0], "open", (player, obj) -> open(player, chest, obj, ids[1]));
                ObjectAction.register(ids[0], "search for traps", (player, obj) -> attempt(player, chest, obj, ids[1]));
                ObjectAction.register(ids[0], "picklock", (player, obj) -> picklockStoneChest(player, chest, obj, ids[1]));
                ObjectAction.register(ids[0], "pick-lock", (player, obj) -> picklock(player, chest, obj, ids[1]));
            }
        }

    }
}
