package racingcar.service;

import racingcar.model.Car;

import java.util.List;
import java.util.Scanner;

/**
 * 프로그램의 UI로직을 담당하는 클래스입니다.
 * 사용자 input도 여기에서 담당합니다.
 */
public class IOService {
    private final Scanner sc;
    final static String COMMA = ",";
    final static String SPACE = " ";

    public IOService() {
        sc = new Scanner(System.in);
    }

    public List<String> carNamesUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();

        List<String> carNameList = SplitCarNames(carNames);
        return carNameList;
    }

    private List<String> SplitCarNames(String carNames) {
        return List.of(carNames.split(COMMA));
    }

    public int trialNumberUserInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int trialNumber = Integer.parseInt(sc.next());

        return trialNumber;
    }

    public void printInitialGameStatus(CarService carService) {
        System.out.println("실행 결과");
        printGameResult(carService);
    }

    public void printGameResult(CarService carService) {
        System.out.println(carService);
    }

    public void printWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            stringBuilder.append(winner.getName() + COMMA + SPACE);
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }
}