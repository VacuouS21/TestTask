package Old;


import java.io.UnsupportedEncodingException;
import java.net.URL;

public class Main {

    public static final String WEATHER_URL =
            "https://watchlater.cloud.technokratos.com/search/film?query=";

    public static void main(String[] args) throws UnsupportedEncodingException {
        // создаем URL из строки
        System.out.println(JsonUtils.overReturn("Белоснежка", "1990-03-23"));
    }
}