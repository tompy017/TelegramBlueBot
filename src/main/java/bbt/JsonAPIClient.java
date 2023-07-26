package bbt;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonAPIClient {
    private final String apiUrl;

    public JsonAPIClient(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    // Get the json from api as a String
    public String getJsonAsString() {
        String json;
        try {

            HttpClient httpClient = HttpClient.newHttpClient(); //in charge of making requests and receiving responses

            HttpRequest httpRequest = HttpRequest.newBuilder()  // makes the request with the url
                    .uri(URI.create(this.apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(
                    httpRequest, HttpResponse.BodyHandlers.ofString());

            //Get the json as a string
            json = httpResponse.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
