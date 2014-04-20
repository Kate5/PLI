package ua.alf.model;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene Chipachenko
 * Date: 20.04.2014
 * Time: 13:08
 */
public enum Language {
    JAVA("Java"),
    DOT_NET(".NET"),
    PHP("PHP"),
    CPP("C++"),
    PYTHON("Python"),
    RUBY("Ruby"),
    IOS("iOS/Mac"),
    ANDROID("Android"),
    FRONT_END("Front End");

    private final String name;

    Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Language findByName(String name) {
        for (Language l : values())
            if (l.getName().equalsIgnoreCase(name))
                return l;
        return null;
    }
}
