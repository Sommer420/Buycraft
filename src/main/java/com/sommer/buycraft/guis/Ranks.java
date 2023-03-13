package com.sommer.buycraft.guis;

import com.sommer.buycraft.BuyCommand;
import com.sommer.buycraft.Main;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Ranks {

    public static void openRankGui(Player player){
        Gui gui = Gui.gui()
                .title(Component.text("§3§lBUTIK§8 • §f§lRANKS"))
                .rows(5) //Med .rows() er det en kiste,
                //.type(GuiType.DISPENSER) sådan er det en dispenser. Det kræver dog, at der ik er nogle rows.
                .create();
        gui.disableAllInteractions();

        gui.getFiller().fillTop(ItemBuilder.from(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9)).name(Component.text("§f")).asGuiItem());
        gui.getFiller().fillBottom(ItemBuilder.from(new ItemStack(Material.STAINED_GLASS_PANE)).name(Component.text("§f")).asGuiItem());

        gui.setItem(44, ItemBuilder.from(Main.HDBapi.getItemHead("3229")).name(Component.text("§cGå tilbage")).setLore("§7Tryk her for at gå tilbage.").asGuiItem(event -> {
            Player p = (Player) event.getWhoClicked();
            //p.closeInventory();
            BuyCommand.openBuyStart((Player) player);
        }));
        gui.open((Player) player);
    }
}
