package me.monst.survivalhaven.command.breadcrumbs;

import me.monst.pluginutil.command.CommandExecutionException;
import me.monst.pluginutil.command.PlayerExecutable;
import me.monst.survivalhaven.particle.ParticleColors;
import me.monst.survivalhaven.particle.ParticleService;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

class BreadcrumbsStart implements PlayerExecutable {
    
    private final ParticleService particleService;
    
    BreadcrumbsStart(ParticleService particleService) {
        this.particleService = particleService;
    }
    
    @Override
    public String getName() {
        return "start";
    }
    
    @Override
    public String getDescription() {
        return "Leave a trail of particles behind you to guide you back.";
    }
    
    @Override
    public String getUsage() {
        return "/breadcrumbs start";
    }
    
    @Override
    public void execute(Player player, List<String> args) throws CommandExecutionException {
        player.sendMessage(ChatColor.YELLOW + "Starting breadcrumbs...");
        if (args.isEmpty())
            particleService.addBreadcrumbs(player);
        else
            particleService.addBreadcrumbs(player, ParticleColors.get(args.get(0)));
    }
    
    @Override
    public List<String> getTabCompletions(Player player, List<String> args) {
        return ParticleColors.search(args.get(0));
    }
    
}
