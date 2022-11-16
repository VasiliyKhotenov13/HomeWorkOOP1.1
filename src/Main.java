import transport.Bus;
import transport.Car;
import transport.Train;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Lada", "Granta", 2015, "Россия", "белый", 0,
                1.5f, "МКПП", "лифтбэк", "x999aa777", 5,
                true, null, null, "электричество");
        car1.setColor("розовый");
        Car car2 = new Car("Audi", "A8 50 L TDI quattro", 2020,
                "Германия", "чёрный", 280, 3.0f, "МКПП", "купэ",
                "в777ор077", 4, true, null, null, "бензин");
        car2.setTransmission("АКПП");
        car2.setKey(new Car.Key(true, true));
        Car car3 = new Car("BMW", "Z8", 2021,
                "Германия", "чёрный", 320, 3.0f, "АКПП", "купэ",
                "а111аа092", 2, true, null, null, "бензин");
        car3.setSummerTires(false);
        Car car4 = new Car("KIA", "Sportage 4-го поколения", 2018,
                "Южная Корея", "красный", 220, 2.4f, "АКПП",
                "кроссовер", "о444рк082", 5, true, null,
                null, "бензин");

        Car car5 = new Car("Hyundai", "Avante", 2016,
                "Южная Корея", "оранжевый", 220, 1.6f, "Роботизированная",
                "мультивен", "я999яя999", 7, true,
                null, null, "дизель");
        car5.setInsurance(new Car.Insurance(LocalDate.of(2022, 12, 12),
                10000, "131313131"));

        Train train1 = new Train("Ласточка", "В-901", 2011, "Россия",
                "", 301, 3500, 0, "Белорусский вокзал",
                "Минск-Пассажирский", 11, "дизель");
        Train train2 = new Train("Ленинград", "D-125", 2019, "Россия",
                "", 270, 1700, 0, "Ленинградский вокзал",
                "Ленинград-Пассажирский", 8, "дизель");
        Bus bus1 = new Bus("Mersedes-Bens", "Sprinter", 2010, "Германия",
                "", 180, "бензин");
        Bus bus2 = new Bus("Ikarus", "256", 2002, "Россия",
                "красно-белый", 120, "дизель");
        Bus bus3 = new Bus("ГАЗель", "CITY", 2020, "Россия",
                "голубой", 150, "дизель");

        printCarInfo(car1);
        System.out.println("Корректный регистрационный номер? " + car1.checkingRegistrationNumber());
        printCarInfo(car2);
        printCarInfo(car3);
        printCarInfo(car4);
        printCarInfo(car5);
        System.out.println("Корректный регистрационный номер? " + car5.checkingRegistrationNumber());
        car5.getInsurance().checkExpiryDate();
        car5.getInsurance().checkInsuranceNumber();
        System.out.println(train1.toString());
        System.out.println(train2.toString());
        System.out.println(bus1.toString());
        System.out.println(bus2.toString());
        System.out.println(bus3.toString());

        car1.refill();
        train2.refill();
        bus1.refill();

        System.out.println(car1.toString());
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
                        ". Регистрационный номер: " + car.getRegistrationNumber() +
                        "." + (car.getKey().isKeylessAccess() ? " Бесключевой доступ!" : " Ключевой доступ!") +
                        (car.getKey().isRemoteEngineStart() ?
                                " Есть удалённый запуск двигателя!" : " Нет удалённого запуска двигателя!") +
                        " Номер страховки: " + car.getInsurance().getInsuranceNumber() +
                        ". Стоимость страховки: " + car.getInsurance().getInsuranceCost() +
                        ". Срок действия страховки: " + car.getInsurance().getInsurancePeriod()
        );
    }
}