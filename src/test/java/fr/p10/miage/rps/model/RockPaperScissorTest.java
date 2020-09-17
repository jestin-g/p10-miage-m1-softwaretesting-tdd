package fr.p10.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RockPaperScissorTest {

    RockPaperScissor rps;

    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissor();
    }

    @AfterMethod
    public void tearDown() {
        rps = null;
    }

    @Test(dataProvider="getDataPlayWin")
    public void testWinPlay(PlayEnum p1, PlayEnum p2) {
        assertEquals(rps.play(p1, p2), ResultEnum.WIN);
    }

    @Test(dataProvider="getDataPlayTie")
    public void testTiePlay(PlayEnum p1, PlayEnum p2) {
        assertEquals(rps.play(p1, p2), ResultEnum.TIE);
    }

    @Test(dataProvider="getDataPlayLoose")
    public void testLoosePlay(PlayEnum p1, PlayEnum p2) {
        assertEquals(rps.play(p1, p2), ResultEnum.LOOSE);
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