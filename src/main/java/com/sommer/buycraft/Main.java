package com.sommer.buycraft;

import com.sommer.buycraft.coins.CoinCommand;
import com.sommer.buycraft.guis.GuiManager;
import com.sommer.buycraft.utils.Config;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

//TODO: Gøre så der er heads i alle menuer.
//TODO: Lave så man kan trykke fra buy > boostere > money & xp > køb
//TODO: Gøre så man kan købe ting i buy, med de coins man har.
//TODO: Implementere SuperPay/Superawesomes betalingssystem, når man kan det.

//TODO: Lave en autohealer til configen. Altså, hvis der mangler noget i den, nulstiller
//TODO: den automatisk det der mangler, så det bliver som om den lavede filen igen.

public final class Main extends JavaPlugin implements Listener {
    public static HeadDatabaseAPI HDBapi = new HeadDatabaseAPI();
    public static Config coinConfig, guiConfig, data, items, license;
    public static FileConfiguration coinConfigYML, guiConfigYML, itemsYML, dataYML, licenseYML;
    public static Main instance;
    @Override
    public void onEnable() {
        //Opretter configs:
        instance = this;
        //Playerdata filer til coins:
        if (!(new File(getDataFolder(), "playerdata.yml")).exists())saveResource("playerdata.yml", false);
        coinConfig = new Config(this, null, "playerdata.yml");
        coinConfigYML = coinConfig.getConfig();
        //Gui config:
        if (!(new File(getDataFolder(), "guiconfig.yml")).exists())saveResource("guiconfig.yml", false);
        guiConfig = new Config(this, null, "guiconfig.yml");
        guiConfigYML = guiConfig.getConfig();
        //new GuiManager();
        new BuyCommand(this);
        Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
        getCommand("buy").setExecutor(new BuyCommand(this));
        getCommand("coins").setExecutor(new CoinCommand(this));
        System.out.println(ChatColor.GREEN + "Pluginet starter..");
    }

    public static Main getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "Pluginet slået fra..");
    }





}
