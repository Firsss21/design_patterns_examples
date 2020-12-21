package behavioralPatterns.stateExample.states;

import behavioralPatterns.stateExample.Player;

public class ReadyState extends State{

    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onPlay() {
        String action = player.startPlay();
        player.setState(new PlayingState(player));
        return action;
    }

    @Override
    public String onLock() {
        player.setState(new LockedState(player));
        return "Locked...";
    }
    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
