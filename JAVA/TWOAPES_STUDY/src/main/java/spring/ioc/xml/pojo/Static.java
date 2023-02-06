package spring.ioc.xml.pojo;

public class Static {
    private static Static1 static1;
    private static Static2 static2;

    public static Static1 getStatic1() {
        return Static.static1;
    }

    public static Static2 getStatic2() {
        return Static.static2;
    }

    public void setStatic1(Static1 static1) {
        Static.static1 = static1;
    }

    public void setStatic2(Static2 static2) {
        Static.static2 = static2;
    }
}
