package transport;

public class Train extends Transport{
    private int costOfTheTrip;
    private int timeOfTheTrip;
    private String departureStation;
    private String endStation;
    private int numberOfWagon;

    public Train(String brand, String model, int year, String country, String color,
                 int maxSpeed, int costOfTheTrip, int timeOfTheTrip,
                 String departureStation, String endStation, int numberOfWagon,
                 String fuelType) {
        super(brand, model, year, country, color, maxSpeed, fuelType);
        if (costOfTheTrip <= 0) {
            this.costOfTheTrip = 100;
        } else {
            this.costOfTheTrip = costOfTheTrip;
        }
        if (timeOfTheTrip == 0) {
            this.timeOfTheTrip = 24;
        } else {
            this.timeOfTheTrip = timeOfTheTrip;
        }
        if (departureStation == null || departureStation.length() == 0) {
            this.departureStation = "Станция отправления не указана!";
        } else {
            this.departureStation = departureStation;
        }
        if (endStation == null || endStation.length() == 0) {
            this.endStation = "Конечная станция не указана";
        } else {
            this.endStation = endStation;
        }
        if (numberOfWagon <= 0) {
            this.numberOfWagon = 10;
        } else {
            this.numberOfWagon = numberOfWagon;
        }
    }

    public int getCostOfTheTrip() {
        return costOfTheTrip;
    }

    public void setCostOfTheTrip(int costOfTheTrip) {
        this.costOfTheTrip = costOfTheTrip;
    }

    public int getTimeOfTheTrip() {
        return timeOfTheTrip;
    }

    public void setTimeOfTheTrip(int timeOfTheTrip) {
        this.timeOfTheTrip = timeOfTheTrip;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public int getNumberOfWagon() {
        return numberOfWagon;
    }

    public void setNumberOfWagon(int numberOfWagon) {
        this.numberOfWagon = numberOfWagon;
    }

    public void refill() {
        String diesel = "Дизель";
        if (getFuelType().equalsIgnoreCase(diesel)) {
            System.out.println("Заправляется дизелем!");
        } else {
            System.out.println("НЕВЕРНЫЙ ТИП ТОПЛИВА!");
        }

    }

    @Override
    public String toString() {
        return "Поезд.  Марка: " + getBrand() +
                ", Модель: " + getModel() +
                ", Год выпуска: " + getYear() +
                ", Страна производитель: " + getCountry() +
                ", Цвет: " + getColor() +
                ", Максимальная скорость: " + getMaxSpeed() +
                ", Цена поездки: " + costOfTheTrip +
                ", Время поездки: " + timeOfTheTrip +
                ", Станция отбывания: '" + departureStation +
                ", Станция прибывания: " + endStation +
                ", Количество вагонов: " + numberOfWagon +
                ", Топливо: " + getFuelType() + ".";
    }
}
