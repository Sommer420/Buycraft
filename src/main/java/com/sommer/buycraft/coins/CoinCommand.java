package com.sommer.buycraft.coins;

import com.sommer.buycraft.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.sommer.buycraft.Main.*;

public class CoinCommand implements CommandExecutor {

    public CoinCommand(Main plugin){
        plugin.getCommand("Coins").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("coins")){
            if (player instanceof Player){

                if (args.length == 0) {
                    Integer coins = coinConfigYML.getInt("coins." + player.getUniqueId());
                    player.sendMessage(" §a");
                    player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                    player.sendMessage(" §eDu§f har §e" + coins + "§f coins.");
                    player.sendMessage(" §b");
                } else {
                    if (args[0].equalsIgnoreCase("indsæt")) {
                        if (args.length == 1) {
                            CoinGui.openCoinsGui(player);
                        } else if (args.length == 2) {
                            player.sendMessage(" §a");
                            player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                            player.sendMessage(" §eDu§f har anmodet om at købe §e" + args[1] + "§f coins.");
                            player.sendMessage(" §a");
                            Bukkit.getOnlinePlayers().stream().forEach(p-> {
                                if (p.isOp()){
                                    p.sendMessage(" §a");
                                    p.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                                    p.sendMessage(" §e" + player.getName() + "§f ønsker at købe §e" + args[1] + "§f coins");
                                    p.sendMessage(" §a");
                                }
                            });
                        }
                    } else if (args[0].equalsIgnoreCase("set")) {
                        if (player.hasPermission("admin")){
                            if (args.length == 3) {
                                coinConfigYML.set("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId(), Integer.valueOf(args[2]));
                                coinConfig.saveConfig();
                                player.sendMessage(" §a");
                                player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                                player.sendMessage(" §fDu satte §e" + args[1] + "§fs coins til §e" + args[2] + "§f.");
                                player.sendMessage(" §b");
                            } else {
                                player.sendMessage(" §a");
                                player.sendMessage("§8[§4§lCOIN §f§lSYSTEM§8]");
                                player.sendMessage(" §cDu skal skrive §4§n/Coins Set (Spiller) (Antal)");
                                player.sendMessage(" §b");
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("tjek")) {
                        if (args.length == 2) {
                            Integer coins = coinConfigYML.getInt("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId());
                            player.sendMessage(" §a");
                            player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                            player.sendMessage(" §e" + Bukkit.getOfflinePlayer(args[1]).getName() + "§f har §e" + coins + "§f coins.");
                            player.sendMessage(" §b");
                        } else {
                            player.sendMessage(" §a");
                            player.sendMessage("§8[§4§lCOIN §f§lSYSTEM§8]");
                            player.sendMessage(" §cDu skal skrive §4§n/Coins Tjek (Spiller)");
                            player.sendMessage(" §b");
                        }

                    } else if (args[0].equalsIgnoreCase("add")) {
                        if (player.hasPermission("admin")){
                            if (args.length == 3) {
                                int coins = coinConfigYML.getInt("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId());
                                Integer coinsNy = coins + Integer.parseInt(args[2]);
                                coinConfigYML.set("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId(), coinsNy);
                                coinConfig.saveConfig();
                                player.sendMessage(" §a");
                                player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                                player.sendMessage(" §fDu gav §e" + args[1] + "§f, §e"+ args[2] + "§f coins.");
                                player.sendMessage(" §b");
                            } else {
                                player.sendMessage(" §a");
                                player.sendMessage("§8[§4§lCOIN §f§lSYSTEM§8]");
                                player.sendMessage(" §cDu skal skrive &4&n/Coins Add (Spiller) (Antal)");
                                player.sendMessage(" §b");
                            }
                        }

                    } else if (args[0].equalsIgnoreCase("remove")) {
                        if (player.hasPermission("admin")){
                            if (args.length == 3) {
                                int coins = coinConfigYML.getInt("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId());
                                Integer coinsNy = coins - Integer.parseInt(args[2]);
                                coinConfigYML.set("coins." + Bukkit.getOfflinePlayer(args[1]).getUniqueId(), coinsNy);
                                coinConfig.saveConfig();
                                player.sendMessage(" §a");
                                player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                                player.sendMessage(" §fDu fjernede §e" + args[2] + "§f coins fra §e"+ args[1] + "§f.");
                                player.sendMessage(" §b");
                            } else {
                                player.sendMessage(" §a");
                                player.sendMessage("§8[§4§lCOIN §f§lSYSTEM§8]");
                                player.sendMessage(" §cDu skal skrive &4&n/Coins Remove (Spiller) (Antal)");
                                player.sendMessage(" §b");
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("reload")) {
                        if (player.hasPermission("admin")) {
                            coinConfig.reloadConfig();
                            coinConfigYML = coinConfig.getConfig();
                            player.sendMessage(" §a");
                            player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                            player.sendMessage(" §fDu reloadede config filen.");
                            player.sendMessage(" §b");
                        } else {
                            player.sendMessage(" §a");
                            player.sendMessage("§8[§4§lCOIN §f§lSYSTEM§8]");
                            player.sendMessage(" §cDu har ikke adgang til denne kommando!");
                            player.sendMessage(" §b");
                        }

                    } else if (args[0].equalsIgnoreCase("help")){
                        player.sendMessage(" §a");
                        player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                        player.sendMessage(" §cDu kan gøre brug af følgende kommandoer:");
                        player.sendMessage(" §c/coins ..");
                        player.sendMessage(" §8» §c.. tjek (spiller)");
                        if (player.hasPermission("admin")) {
                            player.sendMessage(" §6§nAdmin kommandoer:");
                            player.sendMessage(" §8» §c.. add (spiller) (antal)");
                            player.sendMessage(" §8» §c.. remove (spiller) (antal)");
                            player.sendMessage(" §8» §c.. set (spiller) (antal)");
                            player.sendMessage(" §8» §creload");
                        }
                        player.sendMessage(" §b");
                    } else {
                        player.sendMessage(" §a");
                        player.sendMessage("§8[§6§lCOIN §f§lSYSTEM§8]");
                        player.sendMessage(" §cDu kan gøre brug af følgende kommandoer:");
                        player.sendMessage(" §c/coins ..");
                        player.sendMessage(" §8» §c.. tjek (spiller)");
                        if (player.hasPermission("admin")) {
                            player.sendMessage(" §6§nAdmin kommandoer:");
                            player.sendMessage(" §8» §c.. add (spiller) (antal)");
                            player.sendMessage(" §8» §c.. remove (spiller) (antal)");
                            player.sendMessage(" §8» §c.. set (spiller) (antal)");
                            player.sendMessage(" §8» §creload");
                        }
                        player.sendMessage(" §b");
                    }
                }
            }
        }
        return false;
    }
}
