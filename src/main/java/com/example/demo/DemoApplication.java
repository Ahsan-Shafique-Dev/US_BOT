package com.example.demo;

import Modal.object;
import com.example.demo.bots.US_BOT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        US_BOT obj = new US_BOT();
        obj.start();
    }

}
