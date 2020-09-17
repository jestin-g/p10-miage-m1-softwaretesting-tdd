package fr.p10.miage.rps.model;

public class RockPaperScissor {
    public RockPaperScissor() {
    }

    ResultEnum play(PlayEnum p1, PlayEnum p2) {
        if (p1 == p2) {
            return ResultEnum.TIE;
        }
        return ResultEnum.WIN;
    }
}
