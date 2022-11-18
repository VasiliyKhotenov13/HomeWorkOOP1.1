package transport;

import java.time.LocalDate;

public class Car extends Transport {
    private float engineVolume;
    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean summerTires;
    private Key key;
    private Insurance insurance;

    public Car(String brand, String model, int year, String country, String color, int maxSpeed, float engineVolume, String transmission, String bodyType,
               String registrationNumber, int numberOfSeats, boolean summerTires, Key key,
               Insurance insurance, String fuelType) {
        super(brand, model, year, country, color, maxSpeed, fuelType);
        if (engineVolume <= 0) {
            this.engineVolume = 1.5f;
        } else {
            this.engineVolume = engineVolume;
        }
        if (transmission == null) {
            this.transmission = "МКПП";
        } else {
            this.transmission = transmission;
        }
        if (bodyType == null || bodyType.length() == 0) {
            this.bodyType = "седан";
        } else {
            this.bodyType = bodyType;
        }
        if (registrationNumber == null || registrationNumber.length() == 0) {
            this.registrationNumber = "x000xx000";
        } else {
            this.registrationNumber = registrationNumber;
        }
        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
        this.numberOfSeats = numberOfSeats;
        this.summerTires = summerTires;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission == null) {
            this.transmission = "МКПП";
        } else {
            this.transmission = transmission;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null) {
            this.registrationNumber = "x000xx000";
        } else {
            this.registrationNumber = registrationNumber;
        }
    }

    public boolean getSummerTires() {
        return summerTires;
    }

    public void setSummerTires(boolean summerTires) {
        this.summerTires = summerTires;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public void changingTires() {
        summerTires = !summerTires;
    }

    public boolean checkingRegistrationNumber() {
        if (registrationNumber.length() != 9) {
            return false;
        }
        char[] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) ||
                !Character.isAlphabetic(chars[5])) {
            return false;
        }
        if (!Character.isDigit(chars[1]) || !Character.isDigit(chars[2]) ||
                !Character.isDigit(chars[3]) || !Character.isDigit(chars[6]) ||
                !Character.isDigit(chars[7]) || !Character.isDigit(chars[8])) {
            return false;
        }
        return true;
    }

    public static class Key {

        private boolean remoteEngineStart;
        private boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public static class Insurance {
        private final LocalDate insurancePeriod;
        private final double insuranceCost;
        private final String insuranceNumber;

        public Insurance(LocalDate insurancePeriod, double insuranceCost, String insuranceNumber) {
            if (insurancePeriod == null) {
                this.insurancePeriod = LocalDate.now().plusDays(365);
            } else {
                this.insurancePeriod = insurancePeriod;
            }
            this.insuranceCost = insuranceCost;
            if (insuranceNumber == null) {
                this.insuranceNumber = "123456789";
            } else {
                this.insuranceNumber = insuranceNumber;
            }
        }

        public Insurance() {
            this(null, 5000, null);
        }

        public LocalDate getInsurancePeriod() {
            return insurancePeriod;
        }

        public double getInsuranceCost() {
            return insuranceCost;
        }

        public String getInsuranceNumber() {
            return insuranceNumber;
        }

        public void checkExpiryDate() {
            if (insurancePeriod.isBefore(LocalDate.now()) || insurancePeriod.isEqual(LocalDate.now())) {
                System.out.println("Вам нужно заново оформить страховку!");
            } else {
                System.out.println("Ваша страховка действует до " + insurancePeriod);
            }
        }

        public void checkInsuranceNumber() {
            if (insuranceNumber == null || insuranceNumber.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            } else {
                System.out.println("Номер страховки корректный!");
            }
        }
    }

    public void refill() {
        String gas = "Бензин";
        String diesel = "Дизель";
        String electric = "Электричество";
        if (getFuelType().equalsIgnoreCase(gas)) {
            System.out.println("Заправляется бензином!");
        } else if (getFuelType().equalsIgnoreCase(diesel)) {
            System.out.println("Заправляется дизелем на заправке!");
        } else if (getFuelType().equalsIgnoreCase(electric)) {
            System.out.println("Нужно заряжать на специальных электропарковках!");
        } else {
            System.out.println("НЕВЕРНЫЙ ТИП ТОПЛИВА!");
        }
    }

    @Override
    public String toString() {
        return "Автомобиль. Марка: " + getBrand() +
                ". Модель: " + getModel() +
                ". Объём двигателя: " + getEngineVolume() +
                ". Коробка передач: " + getTransmission() +
                ". Тип кузова: " + getBodyType() +
                ". Количество мест: " + getNumberOfSeats() +
                ". Цвет кузова: " + getColor() +
                ". " + (getSummerTires() ? "Летняя" : "Зимняя") + " резина" +
                ". Год выпуска: " + getYear() +
                ". Страная производитель: " + getCountry() +
                ". Регистрационный номер: " + getRegistrationNumber() +
                "." + (getKey().isKeylessAccess() ? " Бесключевой доступ!" : " Ключевой доступ!") +
                (getKey().isRemoteEngineStart() ?
                        " Есть удалённый запуск двигателя!" : " Нет удалённого запуска двигателя!") +
                " Номер страховки: " + getInsurance().getInsuranceNumber() +
                ". Стоимость страховки: " + getInsurance().getInsuranceCost() +
                ". Срок действия страховки: " + getInsurance().getInsurancePeriod();
    }
}
