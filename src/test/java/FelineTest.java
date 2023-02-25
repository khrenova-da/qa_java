import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline = new Feline();

    @Test
    public void eatMeatReturnListOfFood() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsFeline() {
        String actual = feline.getFamily();
        Assert.assertEquals("Кошачьи", actual);
    }

    @Test
    public void getKittensWithoutArgumentReturnsOne() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithArgumentReturnsThisArgument() {
        int actual = feline.getKittens(3);
        Assert.assertEquals(3, actual);
    }
}
