public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Lada", "Granta", 1.7f, "желтый", 2015, "Россия");
        Car car2 = new Car("Audi", "A8 50 L TDI quattro", 3.0f, "чёрный", 2020, "Германия");
        Car car3 = new Car("BMW", "Z8", 3.0f, "чёрный", 2021, "Германия");
        Car car4 = new Car("KIA", "Sportage 4-го поколения", 2.4f, "красный", 2018, "Южная Корея");
        Car car5 = new Car("Hyundai", "Avante", 1.6f, "оранжевый", 2016, "Южная корея");

        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());
        System.out.println(car4.toString());
        System.out.println(car5.toString());

    }
}