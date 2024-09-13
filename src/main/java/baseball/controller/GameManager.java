package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GameManager {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void startGame() throws IOException {
        play();
        outputView.printSuccessMessage();
        endOrRestart();
    }

    private void play() throws IOException {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.generateRandomNumber();
        while (true) {
            inputView.enterPlayerNumber();

            Player player = new Player();
            player.inputPlayerNumber(br.readLine());

            Score score = new Score();
            score.checkScore(computerNumbers, player.getPlayer());

            String hint = getHint(score);
            outputView.printHintMessage(hint);

            if (score.getStrike() == 3) {
                break;
            }

        }
    }

    private void endOrRestart() throws IOException{
        inputView.enterRestartGame();
        String answer = br.readLine();

        if (answer.equals("1")) {
            startGame();
        }
    }

    private static String getHint(Score score) {
        String hint = "";
        if (score.getStrike() > 0 && score.getBall() > 0) {
            hint = score.getBall() + "볼 " + score.getStrike() + "스트라이크";
        } else if (score.getBall() == 0 && score.getStrike() > 0) {
            hint = score.getStrike() + "스트라이크";
        } else if (score.getStrike() == 0 && score.getBall() > 0) {
            hint = score.getBall() + "볼";
        } else if (score.getBall() == 0 && score.getStrike() == 0) {
            hint = "낫싱";
        }
        return hint;
    }
}
