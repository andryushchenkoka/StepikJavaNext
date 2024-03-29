package nested_classes.static_nested;

// Вложенные классы нужны когда требуется привязать один класс к другому

/**
 * Nested класс похож на обычный класс, но находится внутри другого класса
 * Создавая объект nested класса нужно указывать и класс, содержащий его
 * static nested класс может содеражть static и non-static элементы
 * static nested класс может обращаться даже к private полям внешнего класса, но только static
 * Внешний класс может обращаться даже к private элементам static nested класса
 */

// Car - внешний класс
public class CarStatic {

    private String model, color;
    private Engine engine;

    public CarStatic(String model, String color, Engine engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    // Engine - вложенный класс по отношению к Car
    public static class Engine {

        private String model;
        private int power;

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
        }

        // static nested класс может содеражть static и non-static элементы
        public void turnOn() {
            System.out.println("Завёлся");
        }
    }

    public static void main(String[] args) {

        // Создавая объект nested класса нужно указывать и класс, содержащий его
        CarStatic.Engine engine1 = new CarStatic.Engine("AE-123", 72);
        engine1.turnOn();
        CarStatic car = new CarStatic("Audi", "Red", engine1);

        // Внешний класс может обращаться даже к private полям вложенного класса
        int engPower = engine1.power;

    }
}
