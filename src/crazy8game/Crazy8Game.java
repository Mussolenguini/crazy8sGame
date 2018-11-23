/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crazy8game;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author evrob0095
 */
public class Crazy8Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int menu = 0;
        int input;
        
        Scanner userInput = new Scanner(System.in);
        do {
            System.out.println("Enter a number to continue");
            System.out.println("1. Rules");
            System.out.println("2. Play game");
            System.out.println("3. Exit");
            input = userInput.nextInt();
            switch (input) {
                case 1:
                    menu = (rules());
                    break;
                case 2:
                    game();
                    break;
                default:
                    System.exit(0);
                    break;
            }
            
        }
        while(menu == 1);
    }
    
    /**
     * Outputs the rules
     * @return a value of 1 to return to the menu
     */
    public static int rules() {
        System.out.println("After hitting play, text will pop up telling you what"
                + " \n cards you have, each with their own corresponding number, you "
                + " \n will also be told what the top card is. You start the game by "
                + " \n typing in the corresponding number of the card you want to play. "
                + " \n If you can't make a move you will automatically be told so "
                + " \n and a card will be picked up. Next the computer will makes its"
                + " \n turn and will tell you what card is placed. Any 8's played will "
                + " \n prompt you to choose suite. Any 2's played will force you to pick up "
                + " \n 2 cards. 4's skip the oppenents turn. The winner is announced to whoever "
                + " \n runs out of cards first");
        return(1);
    }
    
    /**
     * game method calls several other methods to play the game and then returns
     * it all back to this method.
     */
    public static void game() {
       int topCard;
       
       
       //New array with every card in a playing cards deck
       String [ ] cardDeck = new String [52];
       cardDeck[0] = "♠ Ace of spades ♠";
       cardDeck[1] = "♠ 2 of spades ♠";
       cardDeck[2] = "♠ 3 of spades ♠";
       cardDeck[3] = "♠ 4 of spades ♠";
       cardDeck[4] = "♠ 5 of spades ♠";
       cardDeck[5] = "♠ 6 of spades ♠";
       cardDeck[6] = "♠ 7 of spades ♠";
       cardDeck[7] = "♠ 8 of spades ♠";
       cardDeck[8] = "♠ 9 of spades ♠";
       cardDeck[9] = "♠ 10 of spades ♠";
       cardDeck[10] = "♠ Jack of spades ♠";
       cardDeck[11] = "♠ Queen of spades ♠";
       cardDeck[12] = "♠ King of spades ♠";
       cardDeck[13] = "♣ Ace of Clubs ♣";
       cardDeck[14] = "♣ 2 of Clubs ♣";
       cardDeck[15] = "♣ 3 of Clubs ♣";
       cardDeck[16] = "♣ 4 of Clubs ♣";
       cardDeck[17] = "♣ 5 of Clubs ♣";
       cardDeck[18] = "♣ 6 of Clubs ♣";
       cardDeck[19] = "♣ 7 of Clubs ♣";
       cardDeck[20] = "♣ 8 of Clubs ♣";
       cardDeck[21] = "♣ 9 of Clubs ♣";
       cardDeck[22] = "♣ 10 of Clubs ♣";
       cardDeck[23] = "♣ Jack of Clubs ♣";
       cardDeck[24] = "♣ Queen of Clubs ♣";
       cardDeck[25] = "♣ King of Clubs ♣";
       cardDeck[26] = "♥ Ace of hearts ♥";
       cardDeck[27] = "♥ 2 of hearts ♥";
       cardDeck[28] = "♥ 3 of hearts ♥";
       cardDeck[29] = "♥ 4 of hearts ♥";
       cardDeck[30] = "♥ 5 of hearts ♥";
       cardDeck[31] = "♥ 6 of hearts ♥";
       cardDeck[32] = "♥ 7 of hearts ♥";
       cardDeck[33] = "♥ 8 of hearts ♥";
       cardDeck[34] = "♥ 9 of hearts ♥";
       cardDeck[35] = "♥ 10 of hearts ♥";
       cardDeck[36] = "♥ Jack of hearts ♥";
       cardDeck[37] = "♥ Queen of hearts ♥";
       cardDeck[38] = "♥ King of hearts ♥";
       cardDeck[39] = "◆ Ace of diamonds ◆";
       cardDeck[40] = "◆ 2 of diamonds ◆";
       cardDeck[41] = "◆ 3 of diamonds ◆";
       cardDeck[42] = "◆ 4 of diamonds ◆";
       cardDeck[43] = "◆ 5 of diamonds ◆";
       cardDeck[44] = "◆ 6 of diamonds ◆";
       cardDeck[45] = "◆ 7 of diamonds ◆";
       cardDeck[46] = "◆ 8 of diamonds ◆";
       cardDeck[47] = "◆ 9 of diamonds ◆";
       cardDeck[48] = "◆ 10 of diamonds ◆";
       cardDeck[49] = "◆ Jack of diamonds ◆";
       cardDeck[50] = "◆ Queen of diamonds ◆";
       cardDeck[51] = "◆ King of diamonds ◆"; 
       
       //Call cardMethod for 16 index array of all cards
       int [ ] cards = cardMethod();
       
       //Two new arrays for the player and computer
       int [ ] playerHand = new int[8];
       int [ ] computerHand = new int[8];
       //Give half of cards array's values to playerHand and the other half to computerHand
       for (int i = 0; i < 8; i++) {
            playerHand[i] = cards[i];
       }
       for (int i = 0; i < 8; i++) {
           computerHand[i] = cards[i+8];
       }
       
       //Convert intro string arrays
       String [ ] stringPlayerHand = new String[8];
       String [ ] stringComputerHand = new String[8];
       //Match everything to cardDeck array
       for (int i = 0; i < 8; i++) {
           stringPlayerHand[i] = cardDeck[playerHand[i]];
       }

       for (int i = 0; i < 8; i++) {
           stringComputerHand[i] = cardDeck[computerHand[i]];
       }
       
       //Print out cards
       for (int i = 0; i < 8; i++) {
            System.out.println(i + "..." + stringPlayerHand[i]);
       }
       
       for (int i = 0; i < 8; i++) {
            System.out.println(i + "..." + stringComputerHand[i]);
       }
       topCard = randomSuit()*randomCard();
       String firstCard = cardDeck[topCard];

           while (Arrays.stream(stringPlayerHand).anyMatch(firstCard::equals) || Arrays.stream(stringComputerHand).anyMatch(firstCard::equals)) {
               topCard = randomSuit()*randomCard();
               firstCard = cardDeck[topCard];
           }
        System.out.println("The top card is: " + firstCard);
        System.out.println("Type in card you want to play");
        System.out.println("Type pickup to pickup a card");
    }
    
    /**
     * Generate players card hand
     * @return playerHand
     */
    public static int[] cardMethod() {
        int [ ] cards = new int [16];
        
        for (int i = 0; i < 16; i++) {
            cards[i] = randomSuit()*randomCard();
        }
        //Rid of duplicates
        //Caution: extremly effiecent
        for (int j = 1; j < 16; j++) {
            if (j == 1) {
                while (cards[j] == cards[j-1]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 2) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 3) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 4) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 5) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 6) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 7) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 8) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 9) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8] || cards[j] == cards[j-9]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 10) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8] || cards[j] == cards[j-9] || cards[j] == cards[j-10]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 11) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8] || cards[j] == cards[j-9] || cards[j] == cards[j-10] || cards[j] == cards[j-11]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 12) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8] || cards[j] == cards[j-9] || cards[j] == cards[j-10] || cards[j] == cards[j-11] || cards[j] == cards[j-12]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 13) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8] || cards[j] == cards[j-9] || cards[j] == cards[j-10] || cards[j] == cards[j-11] || cards[j] == cards[j-12] || cards[j] == cards[j-13]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 14) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8] || cards[j] == cards[j-9] || cards[j] == cards[j-10] || cards[j] == cards[j-11] || cards[j] == cards[j-12] || cards[j] == cards[j-13] || cards[j] == cards[j-14]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
            if (j == 15) {
                while (cards[j] == cards[j-1] || cards[j] == cards[j-2] || cards[j] == cards[j-3] || cards[j] == cards[j-4] || cards[j] == cards[j-5] || cards[j] == cards[j-6] || cards[j] == cards[j-7] || cards[j] == cards[j-8] || cards[j] == cards[j-9] || cards[j] == cards[j-10] || cards[j] == cards[j-11] || cards[j] == cards[j-12] || cards[j] == cards[j-13] || cards[j] == cards[j-15]) {
                    cards[j] = randomSuit()*randomCard();
                }
            }
        }
        return(cards);
    }
    
    /**
     * Generates a random number between 1 and 4
     * @return randomSuit
     */
    public static int randomSuit() {
        int randomSuit = (int)Math.round(Math.random() * 3 + 1);
        return(randomSuit);
    }
    
    /**
     * Generates a random number between 1 and 13
     * @return 
     */
    public static int randomCard() {
        int randomCard = (int)Math.round(Math.random() * 12 + 1);
        return(randomCard);
    }
    
    
}
