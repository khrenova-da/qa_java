import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String lionSex;
    private final boolean expected;
    Feline feline = Mockito.mock(Feline.class);

    public LionTest(String lionSex, boolean expected) {
        this.lionSex = lionSex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensReturnsOne() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void doesHaveManeReturnsSex() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsListOfFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void lionConstructorWrongSexReturnsException() throws Exception {
        try {
            Lion lion = new Lion("male", feline);
        } catch (Exception thrown) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", thrown.getMessage());
        }
    }
}
