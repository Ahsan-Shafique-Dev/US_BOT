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
        Document doc = Jsoup.connect("https://cha.house.gov/subcommittees/joint-committee-congress-library-116th-congress").get();
        Elements insideSection = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel > div");
        for (Element elements : insideSection) {
            Elements PROFILES = insideSection.select(".each-member");
            for (Element PROFILE : PROFILES) {
                String PROFILE_IDENTIFIER = PROFILE.select("span").text();
                Elements PROFILE_IMAGE_ELEMENT = PROFILE.select("img");
                String SPLIT_PROFILE[] = PROFILE_IDENTIFIER.split("~");
                String PROFILE_NAME = SPLIT_PROFILE[0];
                String PROFILE_STATE = SPLIT_PROFILE[1];
                String PROFILE_IMGURL = PROFILE_IMAGE_ELEMENT.attr("src");
                System.out.println(new object(PROFILE_NAME, PROFILE_STATE, PROFILE_IMGURL));
            }

        }
    }
}
