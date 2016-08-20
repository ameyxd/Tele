package com.tele.starter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Created with love by Amey Ambade on 6/7/16.
 */
public class Main {
    public static final String TOKEN = "217329476:AAGJK3qRn_Q7L5l59nVueVcqAtgAyVA-1qM";
    public static final String searchKeyword = "Atheism";

    public static void main(String[] args) throws IOException, JSONException {

        Scanner scanner = new Scanner(System.in);

        String searchEncoded = URLEncoder.encode(searchKeyword, "UTF-8");
        String url = "https://en.wikipedia.org/w/api.php?action=opensearch&search="
                + searchEncoded + "&format=json";

        System.out.println("URL:" + url);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) sb.append(line);

        String output = sb.toString();
        System.out.println("Query executed.");

        JSONArray result = new JSONArray(output);
        System.out.println("result.toString() = " + result.toString());
/*

        JSONArray firstResultArray = (JSONArray) result.get(1);
        String firstResultTitle = (String) firstResultArray.get(0);
        System.out.println(firstResultTitle.toString());

        JSONArray details = (JSONArray) result.get(2);
        String detailsOfSearch = (String) details.get(0);
        System.out.println(detailsOfSearch.toString());

        JSONArray linkList = (JSONArray) result.get(3);
        String link = (String) linkList.get(0);
        System.out.println(link.toString());
*/
    }
}
