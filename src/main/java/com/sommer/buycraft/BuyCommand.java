package com.sommer.buycraft;

import com.sommer.buycraft.guis.Andet;
import com.sommer.buycraft.guis.Boostere;
import com.sommer.buycraft.guis.Ranks;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static com.sommer.buycraft.Main.guiConfig;
import static com.sommer.buycraft.Main.guiConfigYML;

public class BuyCommand implements CommandExecutor {
    public BuyCommand(Main plugin){
        plugin.getCommand("buy").setExecutor(this);
    }

    public static void openBuyStart(Player player){
        String guiNavn = guiConfigYML.getString("guis.start.guinavn").toString();
        int guiRows = guiConfigYML.getInt("guis.start.guirows");
        Gui gui = Gui.gui()
                .title(Component.text(guiNavn))
                .rows(guiRows) //Med .rows() er det en kiste,
                //.type(GuiType.DISPENSER) sådan er det en dispenser. Det kræver dog, at der ik er nogle rows.
                .create();
        gui.disableAllInteractions();

        gui.getFiller().fillTop(ItemBuilder.from(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9)).name(Component.text("§f")).asGuiItem());
        gui.getFiller().fillBottom(ItemBuilder.from(new ItemStack(Material.STAINED_GLASS_PANE)).name(Component.text("§f")).asGuiItem());

        int lukId = guiConfigYML.getInt("guis.start.luk.id");
        int lukSlot = guiConfigYML.getInt("guis.start.luk.slot");
        String lukName = guiConfigYML.getString("guis.start.luk.name").replace("&", "§");
        List<String> lukLore = guiConfigYML.getStringList("guis.start.luk.lore");

        gui.setItem(lukSlot, ItemBuilder.from(Main.HDBapi.getItemHead(Integer.toString(lukId))).name(Component.text(lukName)).setLore(lukLore).asGuiItem(event -> {
            event.getWhoClicked().closeInventory();
        }));


        int head1Id = guiConfigYML.getInt("guis.start.head1.id");
        int head1Slot = guiConfigYML.getInt("guis.start.head1.slot");
        String head1Name = guiConfigYML.getString("guis.start.head1.name").replace("&", "§");
        List<String> head1Lore = guiConfigYML.getStringList("guis.start.head1.lore");

        int head2Id = guiConfigYML.getInt("guis.start.head2.id");
        int head2Slot = guiConfigYML.getInt("guis.start.head2.slot");
        String head2Name = guiConfigYML.getString("guis.start.head2.name").replace("&", "§");
        List<String> head2Lore = guiConfigYML.getStringList("guis.start.head2.lore");

        int head3Id = guiConfigYML.getInt("guis.start.head3.id");
        int head3Slot = guiConfigYML.getInt("guis.start.head3.slot");
        String head3Name = guiConfigYML.getString("guis.start.head3.name").replace("&", "§");
        List<String> head3Lore = guiConfigYML.getStringList("guis.start.head3.lore");


        gui.setItem(head1Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head1Id))).name(Component.text(head1Name.toString())).setLore(head1Lore).asGuiItem(event -> {
            Ranks.openRankGui((Player) event.getWhoClicked());
        }));

        gui.setItem(head2Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head2Id))).name(Component.text(head2Name.toString())).setLore(head2Lore).asGuiItem(event -> {
            Boostere.openBoostereGui((Player) event.getWhoClicked());
        }));

        gui.setItem(head3Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head3Id))).name(Component.text(head3Name.toString())).setLore(head3Lore).asGuiItem(event -> {
            Andet.openAndetGui((Player) event.getWhoClicked());
        }));


        gui.open((Player) player);
    }

    @Override
    public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
        if (player instanceof Player){
            if (args.length == 0) {
                BuyCommand.openBuyStart((Player) player);
                //Ranks.openRankGui((Player) player);
                //GuiManager.openGui((HumanEntity) player, Guis.START);
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")){
                    if (player.hasPermission("admin")){
                        boolean success;
                        player.sendMessage("§eReloader configen..");
                        try{
                            guiConfig.reloadConfig();
                            guiConfigYML = guiConfig.getConfig();
                            success = true;
                        } catch(Exception e){
                            e.printStackTrace();
                            success = false;
                        }
                        if(success) player.sendMessage("§aConfigen blev reloadet!");
                        if(!success) player.sendMessage("§cDer skete en fejl ved reload. Venligst tjek konsollen!");
                    }
                }
            }
        }
        return true;
    }

}
