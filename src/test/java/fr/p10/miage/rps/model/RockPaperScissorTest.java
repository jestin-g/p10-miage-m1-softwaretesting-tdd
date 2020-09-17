package fr.p10.miage.rps.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class RockPaperScissorTest {

    RockPaperScissor rps;

    @BeforeClass
    public void setupClass() {
        rps = new RockPaperScissor();
    }

    @AfterClass
    public void tearDownClass() {
        rps = null;
    }

    @Test(dataProvider = "getDataPlayWin")
    public void testWinPlay(PlayEnum p1, PlayEnum p2) {
        assertEquals(rps.play(p1, p2), ResultEnum.WIN);
        assertNotEquals(rps.play(p1, p2), ResultEnum.TIE);
        assertNotEquals(rps.play(p1, p2), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayTie")
    public void testTiePlay(PlayEnum p1, PlayEnum p2) {
        assertEquals(rps.play(p1, p2), ResultEnum.TIE);
        assertNotEquals(rps.play(p1, p2), ResultEnum.WIN);
        assertNotEquals(rps.play(p1, p2), ResultEnum.LOOSE);
    }

    @Test(dataProvider = "getDataPlayLoose")
    public void testLoosePlay(PlayEnum p1, PlayEnum p2) {
        assertEquals(rps.play(p1, p2), ResultEnum.LOOSE);
        assertNotEquals(rps.play(p1, p2), ResultEnum.TIE);
        assertNotEquals(rps.play(p1, p2), ResultEnum.WIN);
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