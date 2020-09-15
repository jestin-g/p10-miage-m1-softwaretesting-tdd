package fr.p10.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RockPaperScissorTest {

    RockPaperScissor rps;

    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissor();
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testPlay() {

    }
}