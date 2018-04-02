package com.ml.dockercomposespringbootmysqlnginx.controller;

import com.ml.dockercomposespringbootmysqlnginx.entity.Visitor;
import com.ml.dockercomposespringbootmysqlnginx.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marcus Li
 * @date 29/03/2018
 */
@RestController
public class VisitorController {
    @Autowired
    private VisitorRepository visitorRepository;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        Visitor visitor = visitorRepository.findByIp(ip);
        if (visitor == null) {
            visitor = new Visitor();
            visitor.setIp(ip);
            visitor.setTimes(1);
        } else {
            visitor.setTimes(visitor.getTimes() + 1);
        }
        visitorRepository.save(visitor);
        return "I have been seen ip " + visitor.getIp() + " " + visitor.getTimes() + " times.";
    }
}
