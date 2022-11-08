public class Car {
    String brand;
    String model;
    float engineVolume;
    String color;
    int year;
    String country;

    Car(String brand, String model, float engineVolume, String color, int year, String country) {
        if (brand.length() <= 0 || brand == null) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model.length() <= 0 || model == null) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 1.5f;
        } else {
            this.engineVolume = engineVolume;
        }
        if (color.length() <= 0 || color == null) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        if (year <= 0) {
            this.year = year;
        } else {
            this.year = year;
        }
        if (country.length() <= 0 || country == null) {
            this.country = "default";
        } else {
            this.country = country;
        }
    }

    @Override
    public String toString() {
        return "Автомобиль. Марка: " + brand +
                ". Модель: " + model +
                ". Объём двигателя: " + engineVolume +
                ". Цвет кузова: " + color +
                ". Год выпуска: " + year +
                ". Страная производитель: " + country + ".";
    }
}
