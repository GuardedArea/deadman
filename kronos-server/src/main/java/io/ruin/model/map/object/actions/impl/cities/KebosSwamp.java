package io.ruin.model.map.object.actions.impl.cities;

import io.ruin.model.inter.dialogue.MessageDialogue;
import io.ruin.model.map.Direction;
import io.ruin.model.map.object.actions.ObjectAction;

public class KebosSwamp {

    static {
        ObjectAction.register(34402, 1292, 3657, 0, 1, (player, obj) -> {
            player.startEvent(event -> {
                player.lock();
                player.getPacketSender().fadeOut();
                player.dialogue(new MessageDialogue("You cautiously lower yourself into the Lizardman dwelling.").hideContinue());
                event.delay(2);
                player.getMovement().teleport(1292, 10057, 0);
                event.delay(2);
                player.getPacketSender().fadeIn();
                event.delay(1);
                player.closeDialogue();
                player.unlock();
            });
        });
        ObjectAction.register(34403, 1314, 3663, 0, 1, (player, obj) -> {
            player.startEvent(event -> {
                player.lock();
                player.getPacketSender().fadeOut();
                player.dialogue(new MessageDialogue("You cautiously lower yourself into the Lizardman dwelling.").hideContinue());
                event.delay(2);
                player.getMovement().teleport(1314, 10063, 0);
                event.delay(2);
                player.getPacketSender().fadeIn();
                event.delay(1);
                player.closeDialogue();
                player.unlock();
            });
        });
        ObjectAction.register(34404, 1330, 3669, 0, 1, (player, obj) -> {
            player.startEvent(event -> {
                player.lock();
                player.getPacketSender().fadeOut();
                player.dialogue(new MessageDialogue("You cautiously lower yourself into the Lizardman dwelling.").hideContinue());
                event.delay(2);
                player.getMovement().teleport(1330, 10069, 0);
                event.delay(2);
                player.getPacketSender().fadeIn();
                event.delay(1);
                player.closeDialogue();
                player.unlock();
            });
        });
        ObjectAction.register(34405, 1312, 3686, 0, 1, (player, obj) -> {
            player.startEvent(event -> {
                player.lock();
                player.getPacketSender().fadeOut();
                player.dialogue(new MessageDialogue("You cautiously lower yourself into the Lizardman dwelling.").hideContinue());
                event.delay(2);
                player.getMovement().teleport(1312, 10086, 0);
                event.delay(2);
                player.getPacketSender().fadeIn();
                event.delay(1);
                player.closeDialogue();
                player.unlock();
            });
        });

    }
}