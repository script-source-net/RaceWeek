package Adversities;

public class Weather {
    String weather;

    public Weather(String w){
        this.weather = w;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        String txt = "";
        switch (weather){
            case "sunny":
            case "rainy":
            default:
                txt = "It's "+weather+" here in ";
                break;
            case "rain":
                txt = "It is raining here in ";
                break;
            case "thunderstorm":
                txt = "It's raining like cats and dogs here in ";
                break;
        }
        return txt;
    }
}
