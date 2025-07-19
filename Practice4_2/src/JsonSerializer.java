import java.lang.reflect.Field;
import java.util.*;

public class JsonSerializer {

    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Class<?> myClass = obj.getClass();
        Field[] fields = myClass.getDeclaredFields();

        List<String> jsonPairs = new ArrayList<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();
                try {
                    Object value = field.get(obj);
                    String jsonValue = formatValue(value);
                    jsonPairs.add("\"" + jsonKey + "\": " + jsonValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        jsonBuilder.append(String.join(", ", jsonPairs));
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

    //Заключаем значения типов String и Char в кавычки
    private static String formatValue(Object value) {
        if (value instanceof String || value instanceof Character) {
            return "\"" + value + "\"";
        } else {
            return String.valueOf(value);
        }
    }
}
