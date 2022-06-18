package baseball.view;

import baseball.domain.Score;
import java.util.List;

public interface OutputView {

    void selectNumberRequest();

    void selectNumberResponse(List<Score> scores); // TODO: domain

    void perfectScore();
}
