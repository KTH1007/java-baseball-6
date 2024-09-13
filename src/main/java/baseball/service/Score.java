package baseball.service;

import java.util.List;

public class Score {
    int strike = 0;
    int ball = 0;

    public void checkScore(List<Integer> computerNumber, List<Integer> playerNumber) {
        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.contains(playerNumber.get(i))) {
                if (computerNumber.get(i) == playerNumber.get(i)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
