package fr.p10.miage.rps.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class RockPaperScissorTest {

    RockPaperScissor rps;
    private LinkedList<PlayEnum> movesP1;
    private LinkedList<PlayEnum> movesP2;
    private LinkedList<PlayEnum> movesP3;
    private LinkedList<PlayEnum> movesP4;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;

    @BeforeClass
    public void setupClass() {
        rps = new RockPaperScissor();

        movesP1 = new LinkedList<>();
        movesP1.add(PlayEnum.ROCK);
        movesP1.add(PlayEnum.ROCK);
        movesP1.add(PlayEnum.PAPER);
        movesP1.add(PlayEnum.SCISSORS);

        movesP2 = new LinkedList<>();
        movesP2.add(PlayEnum.SCISSORS);
        movesP2.add(PlayEnum.SCISSORS);
        movesP1.add(PlayEnum.PAPER);
        movesP3.add(PlayEnum.ROCK);

        movesP3 = new LinkedList<>();
        movesP3.add(PlayEnum.ROCK);
        movesP3.add(PlayEnum.ROCK);
        movesP1.add(PlayEnum.PAPER);
        movesP3.add(PlayEnum.ROCK);

        movesP4 = new LinkedList<>();
        movesP4.add(PlayEnum.PAPER);
        movesP4.add(PlayEnum.PAPER);
        movesP4.add(PlayEnum.PAPER);
        movesP3.add(PlayEnum.ROCK);

        p1 = new Player("Player 1", movesP1);
        p2 = new Player("Player 2", movesP2);
        p3 = new Player("Player 3", movesP3);
        p4 = new Player("Player 4", movesP4);
    }

    @AfterClass
    public void tearDownClass() {
        rps = null;
        movesP1 = null;
        movesP2 = null;
        movesP3 = null;
        movesP4 = null;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
    }

    @Test
    public void testPlayerWin() {
        assertEquals(rps.play(p1, p2), ResultEnum.WIN);
    }

    @Test
    public void testPlayerTie() {
        assertEquals(rps.play(p1, p3), ResultEnum.TIE);
    }

    @Test
    public void testPlayerLoose() {
        assertEquals(rps.play(p1, p4), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayWin")
    public void testWinPlay(PlayEnum pe1, PlayEnum pe2) {
        assertEquals(rps.play(pe1, pe2), ResultEnum.WIN);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.TIE);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayTie")
    public void testTiePlay(PlayEnum pe1, PlayEnum pe2) {
        assertEquals(rps.play(pe1, pe2), ResultEnum.TIE);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.WIN);
        assertNotEquals(rps.play(pe1, pe2), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayLoose")
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