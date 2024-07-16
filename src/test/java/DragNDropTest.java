import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class DragNDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragNDropTest() {
        open("drag_and_drop");
        //Приведены два варианта перемещения:
        //$("#column-a").dragAndDrop(to("#column-b"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(150, 0).release().perform();

        $("#column-a").$(byTagAndText("header", "B")).should(exist);


    }
}