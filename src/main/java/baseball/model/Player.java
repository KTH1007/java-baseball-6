package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Player {

    List<Integer> player;

    public void inputPlayerNumber(String s) {
        player = new ArrayList<>();
        validation(s);
        for (int i = 0; i < s.length(); i++) {
            int number = s.charAt(i) - '0';
            player.add(number);
        }
    }

    private void validation(String s) {
        if (s == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        } else if (s.length() != 3) {
            throw new IllegalArgumentException("입력 받은 숫자의 크기가 다릅니다.");
        } else if (!s.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("1부터 9까지의 정수만 입력해주세요.");
        } else if (isDuplicate(s) != 3) {
            throw new IllegalArgumentException("중복된 값이 들어왔습니다.");
        }
    }

    private int isDuplicate(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }

    public List<Integer> getPlayer() {
        return player;
    }
}
