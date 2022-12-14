package io.ruin.network.incoming.handlers;

import io.ruin.api.buffer.InBuffer;
import io.ruin.cache.ObjectDef;
import io.ruin.model.World;
import io.ruin.model.entity.player.Player;
import io.ruin.model.map.Tile;
import io.ruin.model.map.object.GameObject;
import io.ruin.model.map.object.actions.ObjectAction;
import io.ruin.network.incoming.Incoming;
import io.ruin.utility.DebugMessage;
import io.ruin.utility.IdHolder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@IdHolder(ids={51, 6, 42, 95, 50, 36 })
public class ObjectActionHandler implements Incoming {


    @Override
    public void handle(Player player, InBuffer in, int opcode) {
        if(player.isLocked())
            return;
        player.resetActions(true, true, true);
        int option = OPTIONS[opcode];
        if(option == 1) {
            int ctrlRun = in.readByteC();
            int id = in.readUnsignedShort();
            int y = in.readShortA();
            int x = in.readLEShortA();
            handleAction(player, option, id, x, y, ctrlRun);
            return;
        }
        if(option == 2) {
            int id = in.readUnsignedLEShortA();
            int x = in.readShort();
            int ctrlRun = in.readByteS();
            int y = in.readShortA();
            handleAction(player, option, id, x, y, ctrlRun);
            return;
        }
        if(option == 3) {
            int id = in.readUnsignedShort();
            int x = in.readShortA();
            int y = in.readLEShortA();
            int ctrlRun = in.readByteA();
            handleAction(player, option, id, x, y, ctrlRun);
            return;
        }
        if(option == 4) {
            int x = in.readShort();
            int ctrlRun = in.readByteC();
            int id = in.readUnsignedShortA();
            int y = in.readShortA();
            handleAction(player, option, id, x, y, ctrlRun);
            return;
        }
        if(option == 5) {
            int y = in.readShort();
            int x = in.readShort();
            int id = in.readUnsignedShort();
            int ctrlRun = in.readByteA();
            handleAction(player, option, id, x, y, ctrlRun);
            return;
        }
        if(option == 6) {
            int id = in.readLEShort();
            ObjectDef def = ObjectDef.get(id);
            if(def != null) {
                if(player.debug) {
                    DebugMessage debug = new DebugMessage()
                            .add("id", id)
                            .add("name", def.name)
                            .add("options", Arrays.toString(def.options))
                            .add("varpbitId", def.varpBitId)
                            .add("varpId", def.varpId);
                    player.sendFilteredMessage("[ObjectAction] " + debug.toString());
                }
            }
            return;
        }
        player.sendFilteredMessage("Unhandled object action: option=" + option + " opcode=" + opcode);
    }

    public static void handleAction(Player player, int option, int objectId, int objectX, int objectY, int ctrlRun) {
        if(objectId == -1)
            return;
        GameObject gameObject = Tile.getObject(objectId, objectX, objectY, player.getPosition().getZ());
        if(gameObject == null)
            return;
        if(player.debug) {
            DebugMessage debug = new DebugMessage()
                    .add("option", option)
                    .add("id", gameObject.id)
                    .add("name", gameObject.getDef().name)
                    .add("x", gameObject.x)
                    .add("y", gameObject.y)
                    .add("z", gameObject.z)
                    .add("type", gameObject.type)
                    .add("direction", gameObject.direction)
                    .add("options", Arrays.toString(gameObject.getDef().options))
                    .add("varpbitId", gameObject.getDef().varpBitId)
                    .add("varpId", gameObject.getDef().varpId);
            player.sendFilteredMessage("[ObjectAction] " + debug.toString());
            suggestObjectHandlerCode(gameObject, player);
        }
        player.getMovement().setCtrlRun(ctrlRun == 1);
        player.getRouteFinder().routeObject(gameObject, () -> {
            player.getPacketSender().resetMapFlag();
            int i = option - 1;
            if(i < 0 || i >= 5)
                return;
            ObjectAction action = null;
            ObjectAction[] actions = gameObject.actions;
            if(actions != null)
                action = actions[i];
            if(action == null && (actions = gameObject.getDef().defaultActions) != null)
                action = actions[i];
            if(action != null) {
                action.handle(player, gameObject);
                return;
            }
            player.sendMessage("Nothing interesting happens.");
        });
    }

    private static void suggestObjectHandlerCode(GameObject object, Player player) {
        JSONParser parser = new JSONParser();
        JSONArray a = null;
        try {
            a = (JSONArray) parser.parse(new FileReader("C:/transports.json"));
        } catch (IOException e) {
            System.out.println("IOEXCEPTION");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            System.out.println("ParseException");
            throw new RuntimeException(e);
        }

        if(a != null) {
            for (Object o : a) {
                JSONObject transport = (JSONObject) o;
                String type = (String) transport.get("type");
                Boolean fromInstance = (Boolean) transport.get("fromInstance");
                Boolean toInstance = (Boolean) transport.get("toInstance");
                String Category = (String) transport.get("Category");
                String SubCategory = (String) transport.get("GAME_OBJECT_FIRST_OPTION");
                JSONObject start = (JSONObject) transport.get("start");
                long startX = (long) start.get("x");
                long startY = (long) start.get("y");
                long startZ = (long) start.get("p");
                JSONArray destinations = (JSONArray) transport.get("destinations");
                long destXmin = -1;
                long destYmin = -1;
                long destXmax = -1;
                long destYmax = -1;
                long destZ = -1;
                for (Object d : destinations) {
                    JSONObject dest = (JSONObject) d;
                    if (destXmin == -1) {
                        destXmin = (long) dest.get("x");
                        destYmin = (long) dest.get("y");
                        destXmax = (long) dest.get("x");
                        destYmax = (long) dest.get("y");
                        destZ = (long) dest.get("p");
                    }
                    if (destXmin > (long) dest.get("x")) {
                        destXmin = (long) dest.get("x");
                    }
                    if (destYmin > (long) dest.get("y")) {
                        destYmin = (long) dest.get("y");
                    }
                    if (destXmax < (long) dest.get("x")) {
                        destXmax = (long) dest.get("x");
                    }
                    if (destYmax < (long) dest.get("y")) {
                        destYmax = (long) dest.get("y");
                    }
                }
                long id = (long) transport.get("id");
                String menuAction = (String) transport.get("menuAction");
                String menuOption = (String) transport.get("menuOption");
                String menuTarget = (String) transport.get("menuTarget");
                if (id == object.id && player.getPosition().getX() == startX && player.getPosition().getY() == startY && player.getPosition().getZ() == startZ) {
                    //System.out.println(menuTarget + " has been found!");
                    //System.out.println("menuOption: " + menuOption);
                    //System.out.println("menuAction: " + menuAction);
                    //System.out.println("id: " + id);
                    //System.out.println("destXmin: " + destXmin);
                    //System.out.println("destYmin: " + destYmin);
                    //System.out.println("destXmax: " + destXmax);
                    //System.out.println("destYmax: " + destYmax);
                    //System.out.println("destZ: " + destZ);
                    //System.out.println("startX: " + startX);
                    //System.out.println("startY: " + startY);
                    //System.out.println("startZ: " + startZ);
                    //System.out.println("type: " + type);
                    //System.out.println("Category: " + Category);
                    //System.out.println("SubCategory: " + SubCategory);
                    //System.out.println("============================");
                    //System.out.println("============================");
                    if(player.getInventory().contains(6555)) {
                        int playerX = player.getPosition().getX();
                        int playerY = player.getPosition().getY();
                        int objectX = object.getPosition().getX();
                        int objectY = object.getPosition().getY();
                        int destinationX = (int) destXmin;
                        int destinationY = (int) destYmin;
                        if(World.multiDebugCount == 0) {
                            System.out.println("Suggested code for unhandled object:");
                            System.out.println("");
                            System.out.println("ObjectAction.register(" + id + ", " + object.getPosition().getX() + ", " + object.getPosition().getY() + ", " + object.getPosition().getZ() + ", " + fetchMenuAction(menuAction) + ", (player, obj) -> {");
                            if((destinationX - playerX) != 0) {
                                System.out.println("if (player.getPosition().getX() > obj.getPosition().getX()) {");
                            } else {
                                System.out.println("if (player.getPosition().getY() > obj.getPosition().getY()) {");
                            }
                        } else {
                            System.out.println("} else {");
                        }
                    } else {
                        System.out.println("Suggested code for unhandled object:");
                        System.out.println("");
                        System.out.println("ObjectAction.register(" + id + ", " + object.getPosition().getX() + ", " + object.getPosition().getY() + ", " + object.getPosition().getZ() + ", " + fetchMenuAction(menuAction) + ", (player, obj) -> {");
                    }
                    switch (menuOption.toLowerCase()) {
                        default:
                            player.sendMessage("Interacting: " + menuOption.toLowerCase());
                            System.out.println("    player.getMovement().teleport(" + destXmin + ", " + destYmin + ", " + destZ + ");");
                            break;
                        case "climb-down":
                            player.sendMessage("Interacting: " + menuOption.toLowerCase());
                            System.out.println("    Ladder.climb(player, " + destXmin + ", " + destYmin + ", " + destZ + ", false, true, false);");
                            break;
                        case "climb-up":
                            player.sendMessage("Interacting: " + menuOption.toLowerCase());
                            System.out.println("    Ladder.climb(player, " + destXmin + ", " + destYmin + ", " + destZ + ", true, true, false);");
                            break;
                    }
                    if(player.getInventory().contains(6555)) {
                        if (World.multiDebugCount == 1) {
                            System.out.println("}});");
                            System.out.println("//TODO: Autogenerated action needs animations and graphics");
                            World.multiDebugCount = 0;
                        } else {
                            World.multiDebugCount = 1;
                        }
                    } else {
                        System.out.println("});");
                        System.out.println("//TODO: Autogenerated action needs animations and graphics");
                        System.out.println("");
                    }
                    player.sendMessage("Testing automatically generated target location!");
                    player.sendMessage("::tele " + (int) destXmin + ", " + (int) destYmin + ", " + (int) destZ);
                    player.getMovement().teleport((int) destXmin, (int) destYmin, (int) destZ);
                }
            }
        } else {
            player.sendMessage("Add locations.json under C:/ to get auto generated object interactions");
        }
    }

    public static int fetchMenuAction(String menuAction) {
        switch (menuAction) {
            default:
                System.out.println("Unknown menuAction: " + menuAction + " !");
                System.out.println("Returned 1");
                return 1;
            case "GAME_OBJECT_FIRST_OPTION":
                return 1;
            case "GAME_OBJECT_SECOND_OPTION":
                return 2;
        }
    }

}