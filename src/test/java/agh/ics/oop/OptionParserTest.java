package agh.ics.oop;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OptionParserTest {
    @Test
    public void parserTest() {
        OptionsParser opt = new OptionsParser();
        String[] arr0 = new String[]{"f", "b", "r", "l", "l", "r"};
        List<MoveDirection> expected = new ArrayList<>();
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.BACKWARD);
        expected.add(MoveDirection.RIGHT);
        expected.add(MoveDirection.LEFT);
        expected.add(MoveDirection.LEFT);
        expected.add(MoveDirection.RIGHT);
        List<MoveDirection> result = opt.Parser(arr0);
        assertEquals(expected, result);
    }
}
