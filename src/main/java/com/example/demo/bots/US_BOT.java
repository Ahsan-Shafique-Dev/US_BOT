package com.example.demo.bots;

import Modal.object;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.jws.soap.SOAPBinding;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class US_BOT {
    public void start() {
        try {
            crawl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crawl() throws IOException {
        ArrayList<object> PROFILE_LIST = new ArrayList<>();
        HashMap<String, String> Profile_data = new HashMap<>();
        String url = "https://cha.house.gov/subcommittees/joint-committee-congress-library-116th-congress";
        Document doc = Jsoup.connect(url).get();

        Elements details = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel > div");
        for (Element elements : details)
        {
            Elements profilesOfInsiders = details.select(".each-member");

            for (Element PROFILE : profilesOfInsiders)
            {
                String insiders_Identity = PROFILE.select("span").text(); // Grab All detail.

                Elements insiders_img = PROFILE.select("img");  // Grab Image Doc

                String split_insiders[] = insiders_Identity.split("~");  // Split Strings
                String insider_name = split_insiders[0];
                String insider_state = split_insiders[1];
                String insider_url = insiders_img.attr("src");      // Grab Urls
                System.out.println(new object(insider_name, insider_state, insider_url));
            }

        }
    }
}
