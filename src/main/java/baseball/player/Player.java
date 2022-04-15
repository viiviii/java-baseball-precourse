package baseball.player;

import baseball.GameNumbers;

public interface Player {

    void viewResult(String message); // TODO: String으로 메세지 받나?

    GameNumbers think();

    GameNumbers guess();

}
