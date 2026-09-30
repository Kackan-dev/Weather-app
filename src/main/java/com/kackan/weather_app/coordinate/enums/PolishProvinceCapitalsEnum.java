package com.kackan.weather_app.coordinate.enums;

public enum PolishProvinceCapitalsEnum {
    DOLNOSLASKIE("Wroclaw"),
    KUJAWSKO_POMORSKIE("Bydgoszcz"),
    LUBELSKIE("Lublin"),
    LUBUSKIE("Gorzow Wielkopolski"),
    LODZKIE("Lodz"),
    MALOPOLSKIE("Krakow"),
    MAZOWIECKIE("Warsaw"),
    OPOLSKIE("Opole"),
    PODKARPACKIE("Rzeszow"),
    PODLASKIE("Bialystok"),
    POMORSKIE("Gdansk"),
    SLASKIE("Katowice"),
    SWIETOKRZYSKIE("Kielce"),
    WARMINSKO_MAZURSKIE("Olsztyn"),
    WIELKOPOLSKIE("Poznan"),
    ZACHODNIOPOMORSKIE("Szczecin");

    private String capitalCity;

    PolishProvinceCapitalsEnum(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getCapitalCity() {
        return capitalCity;
    }
}
