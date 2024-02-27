package com.playerData.playerAction;

import com.playerData.Player;

public interface IplayerAction {
    void attack(Player opponent);
    void defend();
    void healing();
}
