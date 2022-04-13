package baseball;

public class Application {
    public static void main(String[] args) {
        // 값 만들기 (출제자 게임 숫자 뽑음) → Randoms
        // TODO: 테스트 추가
        Host host = new AIHost();
        host.think();

        // 값 입력받기 (맞추는 사람이 값 입력) → Console
        // 값 비교하기 (양측 게임 숫자 비교함)
        // 모두 맞췄으면 게임 종료
    }
}
