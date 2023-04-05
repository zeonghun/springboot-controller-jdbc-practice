package kr.ymtech.ojt.spring2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ymtech.ojt.spring2.dao.HelloDao;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    private HelloDao helloDao;

    public HelloController(HelloDao helloDao) {
        this.helloDao = helloDao;
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "") String name) {
        if (name.isEmpty()) {
            return "HelloWorld!";
        }

        helloDao.insert(name);

        int count = helloDao.countByName(name);

        return "안녕하세요! " + name + "님 " + count + "번째 방문입니다.";
    }
}
