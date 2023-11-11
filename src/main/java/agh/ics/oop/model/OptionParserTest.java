package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;

import static org.junit.Assert.assertArrayEquals;

public class OptionParserTest {
    @Test
    public void parserTest() {
        OptionsParser opt = new OptionsParser();
        String[] arr0 = new String[]{"f", "b", "r", "l", "l", "r"};
        MoveDirection[] expected = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT};
        MoveDirection[] result = opt.Parser(arr0);
        assertArrayEquals(expected, result);

    }
}
