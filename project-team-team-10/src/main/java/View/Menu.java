package View;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Menu {

    protected String name;
    protected Menu parentMenu;
    protected List<Pattern> patternList;
    protected List<Menu> subMenus = new ArrayList<>();
    protected List<String> regexList = new ArrayList<>();

}
