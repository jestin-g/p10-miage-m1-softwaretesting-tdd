package fr.p10.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @Parameters({"papier", "pierre"})
    @Test()
    public void testWinPlay(String p1, String p2) {
        assertEquals(rps.play(PlayEnum.valueOf(p1), PlayEnum.valueOf(p2)), ResultEnum.WIN);
    }

    @Parameters({"pierre", "pierre"})
    @Test()
    public void testTiePlay(String p1, String p2) {
        assertEquals(rps.play(PlayEnum.valueOf(p1), PlayEnum.valueOf(p2)), ResultEnum.TIE);
    }

}