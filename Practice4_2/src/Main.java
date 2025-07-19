//Работа с аннотациями и рефлексией
public class Main {
    public static void main(String[] args) {

        //Кастомная аннотация @DeprecatedEx
        System.out.println("Проверка OldClass и его методов");
        AnnotationHandler.handler(OldClass.class);

        System.out.println("Проверка Guitar и его методов");
        AnnotationHandler.handler(Guitar.class);

        //Кастомная сериализация в JSON с аннотацией @JsonField
        System.out.println("Вывод JSON-строки");
        Guitar guitar = new Guitar("Ibanez", "Iron Label RG Series RGIR20BE", "electric guitar", 55000);
        String json = JsonSerializer.toJson(guitar);
        System.out.println(json);

    }
}
