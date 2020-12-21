package behavioralPatterns.stateExample;

import behavioralPatterns.stateExample.states.ReadyState;
import behavioralPatterns.stateExample.states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private boolean playing = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 1; i <= 15; i++) {
            playlist.add("Track " + i);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String startPlay() {
        return "Playing" + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;

        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return startPlay();
    }

    public String previousTrack() {
        currentTrack--;

        if (currentTrack < 0)
            currentTrack = playlist.size() - 1;
        return startPlay();
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
