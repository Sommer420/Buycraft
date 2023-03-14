package com.sommer.buycraft.guis;//package com.sommer.buycraft.guis;

import com.sommer.buycraft.Main;
import com.sommer.buycraft.enums.Guis;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

import static com.sommer.buycraft.Main.guiConfigYML;

public class GuiManager {
    /*
    static HashMap<Guis, Gui> guis;

    public GuiManager(){
        guis = new HashMap<>();
        for (final String key : guiConfigYML.getConfigurationSection("guis").getKeys(true)) {
            String guiNavn = guiConfigYML.getString("guis." + key + ".guinavn").toString();
            int guiRows = guiConfigYML.getInt("guis." + key + ".guirows");
            Gui gui = Gui.gui()
                    .title(Component.text(guiNavn))
                    .rows(guiRows) //Med .rows() er det en kiste,
                    //.type(GuiType.DISPENSER) sådan er det en dispenser. Det kræver dog, at der ik er nogle rows.
                    .create();
            gui.disableAllInteractions();
            for (final String head : guiConfigYML.getConfigurationSection("guis." + key + ".heads").getKeys(true)) {
                int head1Id = guiConfigYML.getInt("guis." + key + ".heads." + head + ".id");
                int head1Slot = guiConfigYML.getInt("guis." + key + ".heads." + head + ".slot");
                String head1Name = guiConfigYML.getString("guis." + key + ".heads." + head + ".name").replace("&", "§");
                List<String> head1Lore = guiConfigYML.getStringList("guis." + key + ".heads." + head + ".lore");
                System.out.println(head1Id);
                System.out.println(head1Slot);
                System.out.println(head1Name);
                System.out.println(head1Lore);

                gui.setItem(head1Slot, ItemBuilder.from(Main.HDBapi.getItemHead(String.valueOf(head1Id))).name(Component.text(head1Name.toString())).setLore(head1Lore).asGuiItem(event -> {
                    findGui(Guis.valueOf(key), (Player) event.getWhoClicked());
                    }));
            }


            guis.put(Guis.valueOf(key), gui);
        }
    }

    public static void openGui(HumanEntity player, Guis type){
        guis.get(type).open(player);
    }

    public void findGui(Guis navn, Player player){
        switch (navn){
            case ANDET:
                Andet.openAndetGui(player);
            case RANKS:
                Ranks.openRankGui(player);
            case BOOSTERE:
                Boostere.openBoostereGui(player);
        }
    }
*/
}
