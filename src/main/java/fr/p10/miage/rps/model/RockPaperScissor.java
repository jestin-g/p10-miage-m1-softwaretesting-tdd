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

    ResultEnum play(Player p1, Player p2) {
        return ResultEnum.LOOSE;
    }
}
