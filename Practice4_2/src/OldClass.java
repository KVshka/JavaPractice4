@DeprecatedEx(message = "Guitar")
public class OldClass {

    @DeprecatedEx(message = "newMethod()")
    public void oldMethod() {
        System.out.println("Это старый метод");
    }

    public void newMethod() {
        System.out.println("Это новый метод");
    }
}


