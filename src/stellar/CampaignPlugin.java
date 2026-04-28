package stellar;

import arc.Events;
import mindustry.game.EventType.PlayEvent;
import mindustry.Vars;
import mindustry.mod.*;

public class CampaignPlugin extends Plugin{
    @Override
    public void init(){
        Events.on(PlayEvent.class, event -> {
            if(Vars.state.rules.waveTeam.core() != null) Vars.state.rules.teams.get(Vars.state.rules.waveTeam).fillItems = true;
        });
    }
}
