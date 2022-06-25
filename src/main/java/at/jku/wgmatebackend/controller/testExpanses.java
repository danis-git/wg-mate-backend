package at.jku.wgmatebackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testExpanses {

    @RequestMapping("/payedbills")
    public String getPayedBills() {
        return "{\"m1\":{\"amount\":63,\"billName\":\"Funny People\",\"payer\":\"dani\",\"time\":\"monthly\"},\"m2\":{\"amount\":69,\"billName\":\"tote hose\",\"payer\":\"sebi\",\"time\":\"yearly\"}}";
    }
    @RequestMapping("/openbills")
    public String getOpenBills() {
        return "{\"m1\":{\"amount\":63,\"billName\":\"Funny People\",\"payer\":\"dani\",\"time\":\"monthly\"},\"m2\":{\"amount\":69,\"billName\":\"tote hose\",\"payer\":\"sebi\",\"time\":\"yearly\"}}";
    }
}
