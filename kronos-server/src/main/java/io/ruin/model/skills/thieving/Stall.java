package io.ruin.model.skills.thieving;

import io.ruin.api.utils.Random;
import io.ruin.model.World;
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

import static io.ruin.cache.ItemID.COINS_995;

public enum Stall {

    VEGETABLE_STALL(2, 2, 10.0, 52000, "vegetable stall",
            PlayerCounter.VEGETABLE_STALL_THIEVES,
            new int[][]{
                    {4706, 634},
                    {4708, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1942, 1, 3),                    //Potato
                    new LootItem(1957, 1, 2),                    //Onion
                    new LootItem(1965, 1, 2),                    //Cabbage
                    new LootItem(1982, 1, 2),                    //Tomato
                    new LootItem(1550, 1, 1)                    //Garlic
                    //new LootItem(COINS_995, 400, 500, 12) //Coins
            )),
    BAKERS_STALL(1, 2, 16.0, 49000, "baker's stall",
            PlayerCounter.BAKER_STALL_THIEVES,
            new int[][]{
                    {6163, 6984},
                    {11730, 634}
            },
            new Item(22521, 1),
            new LootTable().addTable(1,
                    new LootItem(1891, 1, 3),                    //Cake
                    new LootItem(2309, 1, 6),                    //Bread
                    new LootItem(1901, 1, 1)                    //Chocolate slice
                    //new LootItem(COINS_995, 3000, 4000, 3) //Coins
            )),
    CRAFTING_STALL(5, 7, 16.0, 49000, "crafting stall",
            PlayerCounter.CRAFTING_STALL_THIEVES,
            new int[][]{
                    {4874, 4797},
                    {6166, 6984},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1755, 1, 1),                    //Chisel
                    new LootItem(1592, 1, 1),                    //Ring mould
                    new LootItem(1597, 1, 1)                    //Necklace mould
            )),
    MONKEY_FOOD_STALL(5, 7, 16.0, 49000, "food stall",
            PlayerCounter.MONKEY_FOOD_STALL_THIEVES,
            new int[][]{
                    {4875, 4797},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1963, 1, 1)                    //Banana
            )),
    MONKEY_GENERAL_STALL(5, 7, 16.0, 49000, "general stall",
            PlayerCounter.MONKEY_GENERAL_STALL_THIEVES,
            new int[][]{
                    {4876, 4797},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1931, 1, 1),                    //Pot
                    new LootItem(2347, 1, 1),                    //Hammer
                    new LootItem(560, 1, 1)                     //Tinderbox
            )),
    TEA_STALL(5, 7, 16.0, 42000, "tea stall",
            PlayerCounter.TEA_STALL_THIEVES,
            new int[][]{
                    {635, 634},
                    {6574, 6573},
                    {20350, 20349}
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(712, 1, 1)                    //Cup of tea
            )),
    SILK_STALL(20, 5, 24.0, 42000, "silk stall",
            PlayerCounter.SILK_STALL_THIEVES,
            new int[][]{
                    {6165, 6984},
                    {11729, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(950, 1, 1)                     //Silk
            )),
    FRUIT_STALL(25, 2, 28.5, 42000, "fruit stall",
            PlayerCounter.FRUIT_STALL_THIEVES,
            new int[][]{
                    {28823, 27537}
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1955, 1, 40),//Cooking apple
                    new LootItem(1963, 1, 20),//Banana
                    new LootItem(5504, 1, 7),//Strawberry
                    new LootItem(247, 1, 5),//Jangerberries
                    new LootItem(2102, 1, 5),//Lemon
                    new LootItem(1951, 1, 5),//Redberries
                    new LootItem(2114, 1, 5),//Pineapple
                    new LootItem(2120, 1, 5),//Lime
                    new LootItem(464, 1, 5),//Strange Fruit
                    new LootItem(19653, 1, 2),//Golovanova fruit top
                    new LootItem(5972, 1, 1)//Papaya fruit
            )),
    WINE_STALL(22, 10, 27.0, 41000, "wine stall",
            PlayerCounter.WINE_STALL_THIEVES,
            new int[][]{
                    {14011, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(3732, 1, 25),                     //Empty jug
                    new LootItem(1937, 1, 13),                     //Jug of water
                    new LootItem(1988, 1, 11),                     //Grapes
                    new LootItem(1993, 1, 8),                     //Jug of wine
                    new LootItem(7919, 1, 7)                     //Bottle of wine
            )),
    SEED_STALL(27, 9, 10.0, 40000, "seed stall",
            PlayerCounter.SEED_STALL_THIEVES,
            new int[][]{
                    {7053, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(5318, 1, 15),//Potato seed
                    new LootItem(5096, 1, 15),//Marigold seed
                    new LootItem(5305, 1, 15),//Barley seed
                    new LootItem(5307, 1, 15),//Hammerstone seed
                    new LootItem(5319, 1, 12),//Onion seed
                    new LootItem(5308, 1, 10),//Asgarnian seed
                    new LootItem(5324, 1, 9),//Cabbage seed
                    new LootItem(5309, 1, 6),//Yanillian seed
                    new LootItem(5097, 1, 5),//Rosemary seed
                    new LootItem(5098, 1, 5),//Nasturtium seed
                    new LootItem(5322, 1, 5),//Tomato seed
                    new LootItem(5306, 1, 5),//Jute seed
                    new LootItem(5320, 1, 3),//Sweetcorn seed
                    new LootItem(5310, 1, 3),//Krandorian seed
                    new LootItem(5323, 1, 2),//Strawberry seed
                    new LootItem(5311, 1, 2),//Wildblood seed
                    new LootItem(5321, 1, 1)//Watermelon seed
            )),
    FUR_STALL(35, 10, 36.0, 22000, "fur stall",
            PlayerCounter.FUR_STALL_THIEVES,
            new int[][]{
                    {4278, 634},
                    {11732, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(958, 1, 1)                       //Grey wolf fur
            )),
    FISH_STALL(42, 10, 42.0, 21000, "fish stall",
            PlayerCounter.FISH_STALL_THIEVES,
            new int[][]{
                    {4277, 634},
                    {4705, 634},
                    {4707, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(332, 1,3, 14),                      //Raw salmon
                    new LootItem(360, 1,3, 5),                      //Raw tuna
                    new LootItem(378, 1, 2,1)                      //Raw lobster
            )),
    CROSSBOW_STALL(49, 9, 52.0, 20000, "crossbow stall",
            PlayerCounter.CROSSBOW_STALL_THIEVES,
            new int[][]{
                    {17031, 6984},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(877, 3, 2),                        //Bronze bolts
                    new LootItem(9420, 1, 2),                       //Bronze limbs
                    new LootItem(9440, 1, 2)                       //Wooden stock
            )),
    SILVER_STALL(50, 30, 54.0, 19000, "silver stall",
            PlayerCounter.SILVER_STALL_THIEVES,
            new int[][]{
                    {6164, 6984},
                    {11734, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(442, 1, 1)                       //Silver ore
            )),
    SPICE_STALL(65, 80, 81.0, 13000, "spice stall",
            PlayerCounter.SPICE_STALL_THIEVES,
            new int[][]{
                    {6572, 6573},
                    {11733, 634},
                    {20348, 20349},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(2007, 1, 2)                      //Spice
            )),
    MAGIC_STALL(65, 80, 100, 12000, "magic stall",
            PlayerCounter.MAGIC_STALL_THIEVES,
            new int[][]{
                    {4877, 4797},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(556, 1, 1),                      //Air rune
                    new LootItem(557, 1, 1),                      //Earth rune
                    new LootItem(554, 1, 1)                      //Fire rune
            )),
    SCIMITAR_STALL(65, 80, 100.0, 1000, "scimitar stall",
            PlayerCounter.SCIMITAR_STALL_THIEVES,
            new int[][]{
                    {4878, 4797},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1323, 1, 1),                      //Iron scimitar
                    new LootItem(1325, 1, 2)                      //Steel scimitar
            )),
    GEM_STALL(75, 180, 160.0, 8500, "gem stall",
            PlayerCounter.GEM_STALL_THIEVES,
            new int[][]{
                    {6162, 6984},
                    {11731, 634},
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1623, 1, 105),                      //Uncut sapphire
                    new LootItem(1621, 1, 17),                      //Uncut emerald
                    new LootItem(1619, 1, 5),                      //Uncut ruby
                    new LootItem(1617, 1, 1)                      //Uncut diamond
            )),
    MOR_GEM_STALL(75, 180, 160.0, 8500, "gem stall",
            PlayerCounter.MOR_GEM_STALL_THIEVES,
            new int[][]{
                    {30280, 30278}
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(1623, 1, 105),                      //Uncut sapphire
                    new LootItem(1621, 1, 17),                      //Uncut emerald
                    new LootItem(1619, 1, 5),                      //Uncut ruby
                    new LootItem(1617, 1, 1)                      //Uncut diamond
            )),
    ORE_STALL(82, 60, 210.0, 8500, "ore stall",
            PlayerCounter.ORE_STALL_THIEVES,
            new int[][]{
                    {30279, 30278}
            },
            null,
            new LootTable().addTable(1,
                    new LootItem(454, 2, 8),  //Coal
                    new LootItem(445, 1, 4),  //Gold ore
                    new LootItem(448, 1, 3),  //Mithril ore
                    new LootItem(450, 1, 2),  //Adamant ore
                    new LootItem(452, 1, 1)   //Runite ore
            ));

    public final int levelReq, respawnTime, petOdds;
    public final int[][] objIDs;
    public final double experience;
    public final String name;
    public final LootTable lootTable;
    public final PlayerCounter counter;
    public final Item bloodMoneyReward;

    Stall(int levelReq, int respawnTime, double experience, int petOdds, String name, PlayerCounter counter, int[][] objIDs, Item bloodMoneyReward, LootTable lootTable) {
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

    private static void attempt(Player player, Stall stall, GameObject object, int replacementID) {
        if (!player.getStats().check(StatType.Thieving, stall.levelReq, "steal from the " + stall.name))
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
            player.sendMessage("You can't steal from a stall while a guard is watching you.");
            return;
        }

        player.startEvent(event -> {
            player.sendFilteredMessage("You attempt to steal from the " + stall.name + "...");
            player.lock();
            player.animate(832);
            event.delay(1);
            replaceStall(stall, object, replacementID, player);
            Item loot = stall.lootTable.rollItem();
            player.getInventory().add(loot);
            if(player.getPosition().inBounds(HOME))
                player.edgevilleStallCooldown.delay(3);
            if (Random.rollDie(stall.petOdds))
                Pet.ROCKY.unlock(player);
            stall.counter.increment(player, 1);
            player.getStats().addXp(StatType.Thieving, stall.experience, true);
            BotPrevention.attemptBlock(player);
            player.unlock();
        });
    }

    private static final Bounds HOME = new Bounds(2002, 3558, 2017, 3573, -1);

    private static void replaceStall(Stall stall, GameObject object, int replacementID, Player player) {
        World.startEvent(e -> {
            if (!player.getPosition().inBounds(HOME)) {
                object.setId(replacementID);
                e.delay(stall.respawnTime);
                object.setId(object.originalId);
            }
        });
    }

    static {
        for (Stall stall : values()) {
            for (int[] ids : stall.objIDs) {
                ObjectAction.register(ids[0], "steal-from", (player, obj) -> attempt(player, stall, obj, ids[1]));
                ObjectAction.register(ids[0], "steal from", (player, obj) -> attempt(player, stall, obj, ids[1]));
            }
        }

    }
}
