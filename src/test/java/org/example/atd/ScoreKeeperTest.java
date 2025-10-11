package org.example.atd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreKeeperTest {

    @Test
    void newScoreTest() {
        ScoreKeeper<Integer> scoreKeeper = new ScoreKeeper();

        int score = score.getScore();

        assertThat(score).isEqualTo(0);
    }

    @Test
    void addScoreTest() {
        ScoreKeeper<Integer> scoreKeeper = new ScoreKeeper();

        scoreKeeper.calculateScore(12);

        int updatedScore = scoreKeeper.getScore();

        assertThat(updatedScore).isNotEqualTo(scoreKeeper);
    }

    @Test
    void cleanScoreTest() {
        ScoreKeeper<Integer> scoreKeeper = new ScoreKeeper();

        scoreKeeper.calculateScore(12);

        int updatedScore = scoreKeeper.getScore();

        scoreKeeper.clearScore();

        int cleanedScore = scoreKeeper.getScore();

        assertThat(cleanedScore).isNotEqualTo(updatedScore);
    }
}
