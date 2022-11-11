import transport.Car;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Lada", "Granta", 1.7f, "жёлтый",
                2015, "Россия", null, "лифтбэк", "а771те092",
                5, true);
        car1.setColor("розовый");
        Car car2 = new Car("Audi", "A8 50 L TDI quattro", 3.0f,
                "чёрный", 2020, "Германия");
        car2.setTransmission("АКПП");
        Car car3 = new Car("BMW", "Z8", 3.0f,
                "чёрный", 2021, "Германия");
        car3.setTransmission("АКПП");
        car3.setSummerTires(false);
        Car car4 = new Car("KIA", "Sportage 4-го поколения", 2.4f,
                "красный", 2018, "Южная Корея");
        car4.setTransmission("АКПП");
        Car car5 = new Car("Hyundai", "Avante", 1.6f,
                "оранжевый", 2016, "Южная корея");
        car5.setRegistrationNumber("a078aa777");

        printCarInfo(car1);
        System.out.println("Корректный регистрационный номер? " + car1.checkingRegistrationNumber());
        printCarInfo(car2);
        printCarInfo(car3);
        printCarInfo(car4);
        printCarInfo(car5);

    }

    private static void printCarInfo(Car car) {
        System.out.println(
                "Автомобиль. Марка: " + car.getBrand() +
                        ". Модель: " + car.getModel() +
                        ". Объём двигателя: " + car.getEngineVolume() +
                        ". Коробка передач: " + car.getTransmission() +
                        ". Тип кузова: " + car.getBodyType() +
                        ". Количество мест: " + car.getNumberOfSeats() +
                        ". Цвет кузова: " + car.getColor() +
                        ". " + (car.getSummerTires() ? "Летняя" : "Зимняя") + " резина" +
                        ". Год выпуска: " + car.getYear() +
                        ". Страная производитель: " + car.getCountry() +
                        ". Регистрационный номер: " + car.getRegistrationNumber() + "."
        );
    }
}