package nested_classes.inner_classes;

// Вложенные классы нужны когда требуется привязать один класс к другому

/**
 * Nested класс похож на обычный класс, но находится внутри другого класса
 * Создавая объект nested класса нужно указывать и класс, содержащий его
 * static nested класс может содеражть static и non-static элементы
 * static nested класс может обращаться даже к private полям внешнего класса, но только static
 * Внешний класс может обращаться даже к private элементам static nested класса
 */

// Car - внешний класс
public class CarInner {

    private String model, color;
    private Engine engine;

    public CarInner(String model, String color, int power) {
        this.model = model;
        this.color = color;
        this.engine = this.new Engine("AE-123", power);
    }

    public CarInner(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // Engine - вложенный класс по отношению к Car
    public class Engine {

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
}

class CarInnerTest {
    public static void main(String[] args) {
        // Создавая объект nested класса нужно указывать и класс, содержащий его
        //Engine engine1 = new Engine("AE-123", 72);    // так нельзя объявлять объект inner класса

        CarInner car = new CarInner("BMW", "blue");
        CarInner.Engine engine = car.new Engine("AE-145", 128);
        car.setEngine(engine);

        // можно сразу создать объект внещнего класса и из него создать от вложенного Inner класса
        CarInner.Engine engine1 = new CarInner("Mercedes", "black").new Engine("AE-999", 250);
    }
}
