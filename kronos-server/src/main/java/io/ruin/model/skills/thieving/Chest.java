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
            PlayerCounter.CHEST_10_COINS_THIEVES,
            new int[][]{
                    {11735, 11743}
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(995, 10, 1)//COINS
            ));

    public final int levelReq, respawnTime, petOdds;
    public final int[][] objIDs;
    public final double experience;
    public final String name;
    public final LootTable lootTable;
    public final PlayerCounter counter;
    public final Item bloodMoneyReward;

    Chest(int levelReq, int respawnTime, double experience, int petOdds, String name, PlayerCounter counter, int[][] objIDs, Item bloodMoneyReward, LootTable lootTable) {
        this.levelReq = levelReq;
        this.respawnTime = respawnTime * 1000 / 600;
        this.experience = experience;
        this.petOdds = petOdds;
        this.name = name;
        this.counter = counter;
        this.objIDs = objIDs;
        this.bloodMoneyReward = bloodMoneyReward;
        this.lootTable = lootTable;
    }

    private static void open(Player player, Chest chest, GameObject object, int replacementID) {
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
            player.sendFilteredMessage("You have activated a trap on the " + chest.name);
            player.lock();
            player.animate(832);
            event.delay(1);
            player.hit(new Hit().fixedDamage(9).delay(0));//Prob not the right amount of damage, seen one guy get hit a 9 in a vid so copied that lol
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
            replaceChest(chest, object, replacementID, player);
            Item loot = chest.lootTable.rollItem();
            player.getInventory().add(loot);
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
            }
        }

    }
}
