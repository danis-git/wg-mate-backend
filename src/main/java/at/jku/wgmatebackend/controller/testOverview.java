package at.jku.wgmatebackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class testOverview {
    @RequestMapping("/overview")
    public String getGreetings() {
        return "{m1:{area:63,flatName:Funny People,name1:dani,name2:phil,name3:simon},m2:{area:69,flatName:better people,name1:sds,name2:test3,name3:fdd}}";
    }
}
