package main.pbt.humbug.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PositionTest {

    @Test
    public void next() {
        Position position = new Position(0,0);
        Assert.assertEquals(position.next(Direction.EAST), new Position(0, 1));
    }
}