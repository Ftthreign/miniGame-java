import com.playerData.Armor;
import com.playerData.Player;
import com.playerData.Weapon;

//import java.util.Random;
import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        enum Action {
            ATTACK, DEFEND, HEAL, GET_DETAILS, NOT_VALID
        }

        Scanner input = new Scanner(System.in);
//        Random rand = new Random();

        System.out.println("Input your Player's name : ");
        String player1 = input.next();

        Player playerOne = new Player(player1, 100, 25);
        Player botPlayer = new Player("com", 100, 25);

        playerOne.equipArmor(new Armor("Leather Jacket", 15));
        playerOne.equipWeap(new Weapon("Steel Sword", 20));

        botPlayer.equipArmor(new Armor("Steel Armor", 25));
        botPlayer.equipWeap(new Weapon("Scimitar", 18));

        System.out.println("Want to continue to play? ");
        String confirm = input.next();

        while(confirm.equalsIgnoreCase("y")) {
            System.out.println("Choose the action : ");
            System.out.println("1. Attack");
            System.out.println("2. Defence");
            System.out.println("3. Healing");

            int choice = input.nextInt();

            Action action = switch (choice) {
                case 1 -> Action.ATTACK;
                case 2 -> Action.DEFEND;
                case 3 -> Action.HEAL;
                case 4 -> Action.GET_DETAILS;
                default -> Action.NOT_VALID;
            };

            switch (action) {
                case ATTACK -> {
                    playerOne.attack(botPlayer);
                    botPlayer.attack(playerOne);
                }
                case DEFEND -> {
                    playerOne.defend();
                    botPlayer.defend();
                }
                case HEAL -> playerOne.healing();
                case GET_DETAILS -> {
                    System.out.println("1. Players stat");
                    System.out.println("2. Bot stat");
                    int detailsChoice = input.nextInt();
                    switch (detailsChoice) {
                        case 1 -> playerOne.showDetails();
                        case 2 -> botPlayer.showDetails();
                    }
                }
                case NOT_VALID -> System.out.println("Choice is not valid");
            }

            System.out.println("Want to continue ? ");
            confirm = input.next();
        }

    }
}