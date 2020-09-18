package fr.p10.miage.rps.model;

import java.util.LinkedList;

public class Player {
    private String name;
    private int score;
    private LinkedList<PlayEnum> moves = new LinkedList<>();
    private int movesCursor = 0;

    public Player(String name, LinkedList<PlayEnum> moves) {
        this.name = name;
        this.score = 0;
        this.moves = moves;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
        for (int i = 0; i < this.getNumberOfMoves(); i++)
            this.moves.add(PlayEnum.randomPlay());
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getNumberOfMoves() {
        return 10;
    }

    public PlayEnum getNextMove() {
        try {
            return this.moves.get(this.movesCursor++);
        } catch (Exception e) {
            return null;
        }
    }

    public void setScore(int score) {
        this.score = score;
    }
}
