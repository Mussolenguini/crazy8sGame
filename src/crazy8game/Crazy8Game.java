/*
 * Evan Robertson
 * November 25th 2018
 * This is a small demo for a game of crazy 8s. There is also some code for unused 
 * stuff left in incase I plan to expand and finish.
 * Known bugs: Choosing some cards may cause index to go out of bounds
 */

package crazy8game;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author evrob0095
 */
public class Crazy8Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        int menu = 0;
        int input;
        //Scanner
        Scanner userInput = new Scanner(System.in);
        
        //Menu loop
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
        System.out.println("The is a demo. Ya a demo for carzy 8s. You are limited to only "
                + " \n playings 8s and picking up cards. There is no computer to play against"
                + " \n Go play witha real deck. After hitting play, text will pop up telling you what"
                + " \n cards you have, each with their own corresponding number, you "
                + " \n will also be told what the top card is. You start the game by "
                + " \n typing in the corresponding number of the card you want to play. "
                + " \n If you can't make a move you must pick up a card."
                + " \n Next the computer will makes its turn and will tell you what card is placed. "
                + " \n Any 8's played will prompt you to choose suite.");
        return(1);
    }
    
    /**
     * game method calls several other methods to play the game and then returns
     * it all back to this method.
     */
    public static void game() {
        //Scanner
       Scanner input = new Scanner(System.in);
       //Variables
       int topCard;
       int userInput;
       int playerHandSize = 0;
       //int computerHandSize = 0;
       int loop8s = 0;
       
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
       
       //Convert into string arrays
       ArrayList stringPlayerHand = new ArrayList();
       ArrayList stringComputerHand = new ArrayList();
       //Match everything to cardDeck array
       for (int i = 0; i < 8; i++) {
           stringPlayerHand.add(i);
           playerHandSize++;
           stringPlayerHand.set(i, cardDeck[playerHand[i]]);
       }
       
       
       //for (int i = 0; i < 8; i++) {
          // stringComputerHand.add(i);
          // computerHandSize++;
           //stringComputerHand.set(i, cardDeck[computerHand[i]]);
       //}
       
        //Randomize First Card
        topCard = randomSuit()*randomCard();
        String firstCard = cardDeck[topCard-1];
        
        while (stringPlayerHand.contains(firstCard) || stringComputerHand.contains(firstCard)) {
            topCard = randomSuit()*randomCard();
            firstCard = cardDeck[topCard];
        }
        
        //Loop the game
        while(stringPlayerHand.size() > 0 || stringComputerHand.size() > 0) {
            
            //Print your hand
            for (int i = 0; i < playerHandSize; i++) {
                System.out.println(i + "..." + stringPlayerHand.get(i));
            }
            //Give the top card
            System.out.println("The top card is: " + firstCard);
            System.out.println("Type in a number for the card you want to play");
            System.out.println("Type -1 to pickup a card");
            
            //Get user input for played card
            userInput = input.nextInt();
            
            
            //Decide what to do with chosen card
            if (userInput < playerHandSize -1 && userInput > 0) {
                if (stringPlayerHand.get(userInput) == cardDeck[46] || stringPlayerHand.get(userInput) == cardDeck[33] || stringPlayerHand.get(userInput) == cardDeck[20] || stringPlayerHand.get(userInput) == cardDeck[7]) {
                    //Loop choosing a suit until one is chosen
                    loop8s = 1;
                    while (loop8s == 1) {
                        //An 8 was played choose a new suit
                        System.out.println("What suit do you want to change to");
                        System.out.println("1. Spades");
                        System.out.println("2. Clubs");
                        System.out.println("3. Hearts");
                        System.out.println("4. Diamonds");
                    
                        //Input
                        userInput = input.nextInt();
                    
                        switch (userInput) {
                            case 1:
                                System.out.println("Suit has been changed to spades");
                                System.out.println("The top card is now 8 of spades");
                                firstCard = cardDeck[7];
                                loop8s = 0;
                                break;
                           case 2:
                                System.out.println("Suit has been changed to clubs");
                                System.out.println("The top card is now 8 of clubs");
                                firstCard = cardDeck[20];
                                loop8s = 0;
                                break;
                            case 3:
                                System.out.println("Suit has been changed to hearts");
                                System.out.println("The top card is now 8 of hearts");
                                firstCard = cardDeck[33];
                                loop8s = 0;
                                break;
                            case 4:
                                System.out.println("Suit has been changed to diamonds");
                                System.out.println("The top card is now 8 of diamonds");
                                firstCard= cardDeck[46];
                                loop8s = 0;
                                break;
                            default:
                                System.out.println("Invalid answer");
                                loop8s = 1;
                                break;
                        }
                    }
                    stringPlayerHand.remove(userInput);
                    playerHandSize--;
                }
                else {
                    System.out.println("End of Demo");
                }
                
            }
            //User chooses to pick up a card
            else if(userInput == -1) {
                //Get a random card
                topCard = randomSuit()*randomCard();
                firstCard = cardDeck[topCard];
                
                //Remove duplicate chance
                while (stringPlayerHand.contains(firstCard) || stringComputerHand.contains(firstCard)) {
                    topCard = randomSuit()*randomCard();
                    firstCard = cardDeck[topCard];
                }
                //Add new card to playerHand array
                stringPlayerHand.add(firstCard);
                //Increase handSize by 1
                playerHandSize++;
                //Output new card
                System.out.println("You picked up a(n)" + stringPlayerHand.get(playerHandSize-1));
            }
            //Anything played that is not within bounds
            else if (userInput > playerHandSize-1) {
                System.out.println("Invalid play");
                System.out.println("End of Demo");
            }
            
            
            
            
        }
        
    }
    
    /**
     * Generate players card hand
     * @return playerHand
     */
    public static int[] cardMethod() {
        //new array
        int [ ] cards = new int [16];
        
        //loop to get cards
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
        //Get random
        int randomSuit = (int)Math.round(Math.random() * 3 + 1);
        return(randomSuit);
    }
    
    /**
     * Generates a random number between 1 and 13
     * @return 
     */
    public static int randomCard() {
        //get Random
        int randomCard = (int)Math.round(Math.random() * 12 + 1);
        return(randomCard);
    }
    
    
}
