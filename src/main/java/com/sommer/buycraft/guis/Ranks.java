package com.sommer.buycraft.guis;

import com.sommer.buycraft.BuyCommand;
import com.sommer.buycraft.Main;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static com.sommer.buycraft.Main.*;

public class Ranks {

    public static void openRankGui(Player player){
        String guiNavn = guiConfigYML.getString("guis.ranks.guinavn").toString();
        int guiRows = guiConfigYML.getInt("guis.ranks.guirows");
        Gui gui = Gui.gui()
                .title(Component.text(guiNavn))
                .rows(guiRows) //Med .rows() er det en kiste,
                //.type(GuiType.DISPENSER) sådan er det en dispenser. Det kræver dog, at der ik er nogle rows.
                .create();
        gui.disableAllInteractions();

        gui.getFiller().fillTop(ItemBuilder.from(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9)).name(Component.text("§f")).asGuiItem());
        gui.getFiller().fillBottom(ItemBuilder.from(new ItemStack(Material.STAINED_GLASS_PANE)).name(Component.text("§f")).asGuiItem());

        int lukId = guiConfigYML.getInt("guis.ranks.luk.id");
        int lukSlot = guiConfigYML.getInt("guis.ranks.luk.slot");
        String lukName = guiConfigYML.getString("guis.ranks.luk.name").replace("&", "§");
        List<String> lukLore = guiConfigYML.getStringList("guis.ranks.luk.lore");

        gui.setItem(lukSlot, ItemBuilder.from(Main.HDBapi.getItemHead(Integer.toString(lukId))).name(Component.text(lukName)).setLore(lukLore).asGuiItem(event -> {
            BuyCommand.openBuyStart(player);
        }));

        int head1Id = guiConfigYML.getInt("guis.ranks.head1.id");
        int head1Slot = guiConfigYML.getInt("guis.ranks.head1.slot");
        String head1Name = guiConfigYML.getString("guis.ranks.head1.name").replace("&", "§");
        List<String> head1Lore = guiConfigYML.getStringList("guis.ranks.head1.lore");
        int head1Price = guiConfigYML.getInt("guis.ranks.head1.price");

        int head2Id = guiConfigYML.getInt("guis.ranks.head2.id");
        int head2Slot = guiConfigYML.getInt("guis.ranks.head2.slot");
        String head2Name = guiConfigYML.getString("guis.ranks.head2.name").replace("&", "§");
        List<String> head2Lore = guiConfigYML.getStringList("guis.ranks.head2.lore");
        int head2Price = guiConfigYML.getInt("guis.ranks.head2.price");

        int head3Id = guiConfigYML.getInt("guis.ranks.head3.id");
        int head3Slot = guiConfigYML.getInt("guis.ranks.head3.slot");
        String head3Name = guiConfigYML.getString("guis.ranks.head3.name").replace("&", "§");
        List<String> head3Lore = guiConfigYML.getStringList("guis.ranks.head3.lore");
        int head3Price = guiConfigYML.getInt("guis.ranks.head3.price");

        int head4Id = guiConfigYML.getInt("guis.ranks.head4.id");
        int head4Slot = guiConfigYML.getInt("guis.ranks.head4.slot");
        String head4Name = guiConfigYML.getString("guis.ranks.head4.name").replace("&", "§");
        List<String> head4Lore = guiConfigYML.getStringList("guis.ranks.head4.lore");
        int head4Price = guiConfigYML.getInt("guis.ranks.head4.price");

        gui.setItem(head1Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head1Id))).name(Component.text(head1Name)).setLore(head1Lore).asGuiItem(event -> {
            Player p = (Player) event.getWhoClicked();
            int coins = coinConfigYML.getInt("coins." + p.getUniqueId());
            if (coins >= head1Price){
                Integer coinsNy = coins - head1Price;
                coinConfigYML.set("coins." + p.getUniqueId(), coinsNy);
                coinConfig.saveConfig();
                Bukkit.broadcastMessage("§a");
                Bukkit.broadcastMessage("§8[§3§lBUY§f§lCRAFT§8]");
                Bukkit.broadcastMessage(" §b" + p.getName() + "§f har købt §b" + head1Name + "§f for §e" + head1Price + "§f coins!");
                Bukkit.broadcastMessage("§a");
            } else {
                gui.setItem(head1Slot, ItemBuilder.from(Main.HDBapi.getItemHead("3229")).name(Component.text("§4§nFEJL")).setLore("§cDu har ikke nok coins!").asGuiItem());
                gui.update();
            }
        }));

        gui.setItem(head2Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head2Id))).name(Component.text(head2Name)).setLore(head2Lore).asGuiItem(event -> {
            Player p = (Player) event.getWhoClicked();
            int coins = coinConfigYML.getInt("coins." + p.getUniqueId());
            if (coins >= head2Price){
                Integer coinsNy = coins - head2Price;
                coinConfigYML.set("coins." + p.getUniqueId(), coinsNy);
                coinConfig.saveConfig();
                Bukkit.broadcastMessage("§a");
                Bukkit.broadcastMessage("§8[§3§lBUY§f§lCRAFT§8]");
                Bukkit.broadcastMessage(" §b" + p.getName() + "§f har købt §b" + head2Name + "§f for §e" + head2Price + "§f coins!");
                Bukkit.broadcastMessage("§a");
            } else {
                gui.setItem(head2Slot, ItemBuilder.from(Main.HDBapi.getItemHead("3229")).name(Component.text("§4§nFEJL")).setLore("§cDu har ikke nok coins!").asGuiItem());
                gui.update();
            }
        }));

        gui.setItem(head3Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head3Id))).name(Component.text(head3Name)).setLore(head3Lore).asGuiItem(event -> {
            Player p = (Player) event.getWhoClicked();
            int coins = coinConfigYML.getInt("coins." + p.getUniqueId());
            if (coins >= head3Price){
                Integer coinsNy = coins - head3Price;
                coinConfigYML.set("coins." + p.getUniqueId(), coinsNy);
                coinConfig.saveConfig();
                Bukkit.broadcastMessage("§a");
                Bukkit.broadcastMessage("§8[§3§lBUY§f§lCRAFT§8]");
                Bukkit.broadcastMessage(" §b" + p.getName() + "§f har købt §b" + head3Name + "§f for §e" + head3Price + "§f coins!");
                Bukkit.broadcastMessage("§a");
            } else {
                gui.setItem(head3Slot, ItemBuilder.from(Main.HDBapi.getItemHead("3229")).name(Component.text("§4§nFEJL")).setLore("§cDu har ikke nok coins!").asGuiItem());
                gui.update();
            }
        }));

        gui.setItem(head4Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head4Id))).name(Component.text(head4Name)).setLore(head4Lore).asGuiItem(event -> {
            Player p = (Player) event.getWhoClicked();
            int coins = coinConfigYML.getInt("coins." + p.getUniqueId());
            if (coins >= head4Price){
                Integer coinsNy = coins - head4Price;
                coinConfigYML.set("coins." + p.getUniqueId(), coinsNy);
                coinConfig.saveConfig();
                Bukkit.broadcastMessage("§a");
                Bukkit.broadcastMessage("§8[§3§lBUY§f§lCRAFT§8]");
                Bukkit.broadcastMessage(" §b" + p.getName() + "§f har købt §b" + head4Name + "§f for §e" + head4Price + "§f coins!");
                Bukkit.broadcastMessage("§a");
                List<String> head4Cmds = guiConfigYML.getStringList("guis.ranks.head4.commands");
                head4Cmds.forEach(command ->{
                    String cmd = command.replace("<player>", p.getName());
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd);
                });
            } else {
                gui.setItem(head4Slot, ItemBuilder.from(Main.HDBapi.getItemHead("3229")).name(Component.text("§4§nFEJL")).setLore("§cDu har ikke nok coins!").asGuiItem());
                gui.update();
            }
        }));

        gui.open((Player) player);
    }
}
