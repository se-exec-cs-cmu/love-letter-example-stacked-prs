package edu.cmu.execed.loveletter;

import java.util.LinkedList;

public class PlayerList {

    private LinkedList<Player> players;

    public PlayerList() {
        this.players = new LinkedList<>();
    }

    /**
     * Adds a new Player object with the given name to the PlayerList.
     *
     * @param name
     *          the given player name
     *
     * @return true if the player is not already in the list and can be added, false if not
     */
    public boolean addPlayer(String name) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        players.addLast(new Player(name));
        return true;
    }

    /**
     * Gets the first player in the list and adds them to end of the list.
     *
     * @return the first player in the list
     */
    public Player getCurrentPlayer() {
        Player current = players.removeFirst();
        players.addLast(current);
        return current;
    }

    /**
     * Resets all players within the list.
     */
    public void reset() {
        for (Player p : players) {
            p.getHand().clear();
            p.getDiscarded().clear();
        }
    }

    /**
     * Prints the used pile of each Player in the list.
     */
    public void printUsedPiles() {
        for (Player p : players) {
            System.out.println("\n" + p.getName());
            p.getDiscarded().print();
        }
    }

    /**
     * Prints each Player in the list.
     */
    public void print() {
        System.out.println();
        for (Player p : players) {
            System.out.println(p);
        }
        System.out.println();
    }

    /**
     * Checks the list for a single Player with remaining cards.
     *
     * @return true if there is a winner, false if not
     */
    public boolean checkForRoundWinner() {
        int count = 0;
        for (Player p : players) {
            if (p.getHand().hasCards()) {
                count++;
            }
        }
        return count == 1;
    }

    /**
     * Returns the winner of the round.
     *
     * @return the round winner
     */
    public Player getRoundWinner() {
        for (Player p : players) {
            if (p.getHand().hasCards()) {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns the winner of the game.
     *
     * @return the game winner
     */
    public Player getGameWinner() {
        for (Player p : players) {
            if (p.getTokens() == 5) {
                return p;
            }
        }
        return null;
    }

    /**
     * Deals a card to each Player in the list.
     *
     * @param deck
     *          the deck of cards
     */
    public void dealCards(Deck deck) {
        for (Player p : players) {
            p.getHand().add(deck.draw());
        }
    }

    /**
     * Gets the player with the given name.
     *
     * @param name
     *          the name of the desired player
     *
     * @return the player with the given name or null if there is no such player
     */
    public Player getPlayer(String name) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns the player with the highest used pile value.
     *
     * @return the player with the highest used pile value
     */
    public Player compareUsedPiles() {
        Player winner = players.getFirst();
        for (Player p : players) {
            if (p.getDiscarded().value() > winner.getDiscarded().value()) {
                winner = p;
            }
        }
        return winner;
    }

}
