package stellar;

import arc.*;
import mindustry.game.EventType;
import mindustry.Vars;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.core.GameState;
import mindustry.game.Rules;
import mindustry.game.Team;
import mindustry.gen.Call;
import mindustry.mod.*;

public class CampaignPlugin extends Plugin{

    @Override
    public void init(){
        Events.run(EventType.Trigger.update, () -> {
            if(Vars.state.is(GameState.State.menu)) return;
            Rules rules = Vars.state.rules;
            if (rules.planet == Planets.serpulo && Team.crux.core() != null) {
                rules.teams.get(Team.crux).infiniteResources = true;
                Items.serpuloItems.each(i -> {
                    Call.setItem(Team.crux.core().tile.build, i, Team.crux.core().tile.block().itemCapacity);
                });
            } else if (rules.planet == Planets.erekir && Team.malis.core() != null) {
                rules.teams.get(Team.malis).infiniteResources = true;
                Items.erekirItems.each(i -> {
                    Call.setItem(Team.malis.core().tile.build, i, Team.malis.core().tile.block().itemCapacity);
                });
            }
        });
    }
}
