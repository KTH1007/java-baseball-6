package baseball;

import baseball.controller.GameManager;
import baseball.view.OutputView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        outputView.printStartMessage();
        GameManager gm = new GameManager();
        gm.startGame();
    }
}
