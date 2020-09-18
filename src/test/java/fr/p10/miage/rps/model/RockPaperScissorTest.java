package fr.p10.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class RockPaperScissorTest {

    RockPaperScissor rps;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;

    @BeforeMethod
    public void setupMethod() {
        rps = new RockPaperScissor();

        LinkedList<PlayEnum> movesP1 = new LinkedList<>();
        movesP1.add(PlayEnum.ROCK);
        movesP1.add(PlayEnum.ROCK);
        movesP1.add(PlayEnum.PAPER);
        movesP1.add(PlayEnum.SCISSORS);

        LinkedList<PlayEnum> movesP2 = new LinkedList<>();
        movesP2.add(PlayEnum.SCISSORS);
        movesP2.add(PlayEnum.SCISSORS);
        movesP2.add(PlayEnum.PAPER);
        movesP2.add(PlayEnum.ROCK);

        LinkedList<PlayEnum> movesP3 = new LinkedList<>();
        movesP3.add(PlayEnum.ROCK);
        movesP3.add(PlayEnum.ROCK);
        movesP3.add(PlayEnum.PAPER);
        movesP1.add(PlayEnum.SCISSORS);

        LinkedList<PlayEnum> movesP4 = new LinkedList<>();
        movesP4.add(PlayEnum.PAPER);
        movesP4.add(PlayEnum.PAPER);
        movesP4.add(PlayEnum.PAPER);
        movesP4.add(PlayEnum.ROCK);

        p1 = new Player("Player 1", movesP1);
        p2 = new Player("Player 2", movesP2);
        p3 = new Player("Player 3", movesP3);
        p4 = new Player("Player 4", movesP4);
    }

    @AfterMethod
    public void tearDownMethod() {
        rps = null;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
    }

    @Test
    public void testPlayerWin() {
        assertEquals(rps.game(p1, p2), ResultEnum.WIN);
    }

    @Test
    public void testPlayerTie() {
        assertEquals(rps.game(p1, p3), ResultEnum.TIE);
    }

    @Test(enabled = false)
    public void testPlayerLoose() {
        assertEquals(rps.game(p1, p4), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayWin", enabled = false)
    public void testWinPlay(PlayEnum pe1, PlayEnum pe2) {
        assertEquals(rps.play(pe1, pe2), ResultEnum.WIN);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.TIE);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayTie", enabled = false)
    public void testTiePlay(PlayEnum pe1, PlayEnum pe2) {
        assertEquals(rps.play(pe1, pe2), ResultEnum.TIE);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.WIN);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayLoose", enabled = false)
    public void testLoosePlay(PlayEnum pe1, PlayEnum pe2) {
        assertEquals(rps.play(pe1, pe2), ResultEnum.LOOSE);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.TIE);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.WIN);
    }

    @DataProvider
    public Object[][] getDataPlayWin() {
        return new Object[][]{
                {PlayEnum.PAPER, PlayEnum.ROCK},
                {PlayEnum.ROCK, PlayEnum.SCISSORS},
                {PlayEnum.SCISSORS, PlayEnum.PAPER}
        };
    }

    @DataProvider
    public Object[][] getDataPlayTie() {
        return new Object[][]{
                {PlayEnum.PAPER, PlayEnum.PAPER},
                {PlayEnum.ROCK, PlayEnum.ROCK},
                {PlayEnum.SCISSORS, PlayEnum.SCISSORS}
        };
    }

    @DataProvider
    public Object[][] getDataPlayLoose() {
        return new Object[][]{
                {PlayEnum.PAPER, PlayEnum.SCISSORS},
                {PlayEnum.ROCK, PlayEnum.PAPER},
                {PlayEnum.SCISSORS, PlayEnum.ROCK}
        };
    }
}