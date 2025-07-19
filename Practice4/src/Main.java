import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //Лямбда выражение для Printable
        Printable myPrinter = () -> System.out.println("Добро пожаловать в програму!\n");
        myPrinter.print();

        //Проверка пустой строки
        Predicate<String> isNull = s -> s == null;

        String str1 = null;
        String str2 = "Not null";
        String str3 = "";
        String str4 = "JJBA";

        System.out.println("Строка str1 равна null: " + isNull.test(str1));
        System.out.println("Строка str2 равна null: " + isNull.test(str2));

        Predicate<String> isEmpty = s -> s.isEmpty();

        System.out.println("Строка str3 пустая: " + isEmpty.test(str3));
        System.out.println("Строка str2 пустая: " + isEmpty.test(str2));

        System.out.println("Строка str1 пустая или равна null: " + isNull.or(isEmpty).test(str1));
        System.out.println("Строка str2 пустая или равна null: " + isNull.or(isEmpty).test(str2));
        System.out.println("Строка str3 пустая или равна null: " + isNull.or(isEmpty).test(str3));


        Predicate<String> startsWithJ = s -> s.charAt(0) == 'J';
        Predicate<String> startsWithN = s -> s.charAt(0) == 'N';
        Predicate<String> endsWithA = s -> s.charAt(s.length()-1) == 'A';

        System.out.println("Строка str4 начинается на J или N и заканчивается на A: " + endsWithA.and(startsWithN.or(startsWithJ)).test(str4) + "\n");

        //Лямбда выражение для HeavyBox
        HeavyBox box = new HeavyBox(10.5);

        Consumer<HeavyBox> ship = b -> System.out.println("Отгрузили ящик с весом " + b.getWeight());
        Consumer<HeavyBox> send = b -> System.out.println("Отправляем ящик с весом " + b.getWeight() + "\n");

        ship.andThen(send).accept(box);

        //Лямбда для Function.
        Function<Integer, String> research = num -> {
            if (num > 0) {
                return String.format("%d - Положительное число", num);
            } else if (num < 0) {
                return String.format("%d - Отрицательное число", num);
            } else {
                return String.format("%d - Ноль", num);
            }
        };

        System.out.println(research.apply(5));
        System.out.println(research.apply(-3));
        System.out.println(research.apply(0) + "\n");

        //Лямбда для Supplier
        Supplier<Integer> randomNumber = () -> new Random().nextInt(11);
        System.out.println("Число от 1 до 10: " + randomNumber.get());
    }
}
