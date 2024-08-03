package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String[] getPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = sc.nextLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름은 null이 될 수 없습니다.");
        }
        return input.split(",");
    }

    public static List<Integer> getBetAmounts(String[] playerNames) {
        List<Integer> betAmounts = new ArrayList<>();
        for (String name : playerNames) {
            System.out.println("\n" + name + "의 배팅 금액은?");
            int betAmount = Integer.parseInt(sc.nextLine().trim());
            if (betAmount < 0)
                throw new IllegalArgumentException("배팅 금액은 양수이어야 합니다.");
            betAmounts.add(betAmount);
        }
        return betAmounts;
    }

    public static boolean wantsCard(String playerName) {
        System.out.println(playerName + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
        String response = sc.nextLine().trim();
        if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            throw new IllegalArgumentException("'y' 또는 'n'을 입력하세요.");
        }
        return response.equalsIgnoreCase("y");
    }
}
