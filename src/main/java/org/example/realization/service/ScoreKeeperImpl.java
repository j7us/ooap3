package org.example.realization.service;

import org.example.atd.ScoreKeeper;
import org.springframework.stereotype.Service;

@Service
public class ScoreKeeperImpl extends ScoreKeeper<Integer> {
    private Integer sumScore = 0;
    private Integer lastMoveScore = 0;

    @Override
    public void calculateScore(int cellDeletedByPlayerTurn) {
        lastMoveScore = cellDeletedByPlayerTurn;
        sumScore += cellDeletedByPlayerTurn;
    }

    @Override
    public void clearScore() {
        sumScore = 0;
        lastMoveScore = 0;
    }

    @Override
    public Integer getScore() {
        return sumScore;
    }

    @Override
    public Integer getLastMoveScore() {
        return lastMoveScore;
    }
}
