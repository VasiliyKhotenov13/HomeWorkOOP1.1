package transport;

public class Bus extends Transport {

    public Bus(String brand, String model, int year, String country, String color, int maxSpeed, String fuelType) {
        super(brand, model, year, country, color, maxSpeed, fuelType);
    }

    public void refill() {
        String gas = "Бензин";
        String diesel = "Дизель";
        if (getFuelType().equalsIgnoreCase(gas)) {
            System.out.println("Заправляется бензином!");
        } else if (getFuelType().equalsIgnoreCase(diesel)) {
            System.out.println("Заправляется дизелем!");
        } else {
            System.out.println("НЕВЕРНЫЙ ТИП ТОПЛИВА!");
        }
    }

    @Override
    public String toString() {
        return "Автобус. Марка: " + getBrand() +
                ", Модель: " + getModel() +
                ", Год выпуска: " + getYear() +
                ", Страна производитель: " + getCountry() +
                ", Цвет: " + getColor() +
                ", Максимальная скорость: " + getMaxSpeed() +
                ", Топливо: " + getFuelType() + ".";
    }
}
