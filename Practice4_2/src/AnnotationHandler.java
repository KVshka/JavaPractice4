import java.lang.reflect.Method;

public class AnnotationHandler {

    public static void handler(Class<?> myClass) {

        // Проверка аннотаций на классах
        if (myClass.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = myClass.getAnnotation(DeprecatedEx.class);
            System.out.println("Внимание: класс '" + myClass.getSimpleName() + "' устарел. Альтернатива: '" + annotation.message() + "'");
        }

        // Проверка аннотаций на методах
        for (Method method : myClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.println("Внимание: метод '" + method.getName() + "' устарел. Альтернатива: '" + annotation.message() + "'");
            }
        }
    }
}
