package fr.p10.miage.rps.model;

public class RockPaperScissor {
    public RockPaperScissor() {
    }

    ResultEnum play(PlayEnum p1, PlayEnum p2) {
        if (p1 == p2) {
            return ResultEnum.TIE;
        }
        if ((p1 == PlayEnum.PAPER) && (p2 == PlayEnum.ROCK)) {
            return ResultEnum.WIN;
        }
        if ((p1 == PlayEnum.ROCK) && (p2 == PlayEnum.SCISSORS)) {
            return ResultEnum.WIN;
        }
        if ((p1 == PlayEnum.SCISSORS) && (p2 == PlayEnum.PAPER)) {
            return ResultEnum.WIN;
        }
        return ResultEnum.LOOSE;
    }

    ResultEnum game(Player p1, Player p2) {
        PlayEnum moveP1 = p1.getNextMove();
        PlayEnum moveP2 = p2.getNextMove();
        while ((moveP1 != null) && (moveP2 != null)) {
            ResultEnum r = play(moveP1, moveP2);
            if (r == ResultEnum.WIN) {
                p1.setScore(p1.getScore() + 1);
            } else if (r == ResultEnum.LOOSE) {
                p2.setScore(p2.getScore() + 1);
            } else {
                p1.setScore(p1.getScore() + 1);
                p2.setScore(p2.getScore() + 1);
            }
            moveP1 = p1.getNextMove();
            moveP2 = p2.getNextMove();
        }
        if (p1.getScore() == p2.getScore()) {
            return ResultEnum.TIE;
        }
        return ResultEnum.WIN;
    }
}
