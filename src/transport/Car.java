package transport;

import java.time.LocalDate;

public class Car {

    public static class Key {

        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

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
            this(null,5000, null);
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

    private final String brand;
    private final String model;
    float engineVolume;
    String color;
    private final int year;
    private final String country;
    String transmission;
    private final String bodyType;
    String registrationNumber;
    private final int numberOfSeats;
    boolean summerTires;
    private Key key;
    private Insurance insurance;

    public Car(String brand, String model, float engineVolume,
               String color, int year, String country,
               String transmission, String bodyType,
               String registrationNumber, int numberOfSeats,
               boolean summerTires, Key key, Insurance insurance) {
        if (brand == null || brand.length() == 0) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.length() == 0) {
            this.model = "default";
        } else {
            this.model = model;
        }
        this.engineVolume = engineVolume;
        if (color == null || color.length() == 0) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        this.year = year;

        if (country == null || country.length() == 0) {
            this.country = "'страна не указана'";
        } else {
            this.country = country;
        }
        if (registrationNumber == null) {
            this.registrationNumber = "x000xx000";
        } else {
            this.registrationNumber = registrationNumber;
        }
        if (bodyType == null) {
            this.bodyType = "седан";
        } else {
            this.bodyType = bodyType;
        }
        if (transmission == null) {
            this.transmission = "МКПП";
        } else {
            this.transmission = transmission;
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
        this.summerTires = summerTires;
        this.numberOfSeats = numberOfSeats;
    }

    public Car(String brand, String model, float engineVolume,
               String color, int year, String country) {
        this(brand, model, engineVolume, color, year, country,
                "МКПП", "седан", "x000xx000",
                4, true, new Key(), new Insurance());
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.length() == 0) {
            this.color = "белый";
        } else {
            this.color = color;
        }
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

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
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
