package jp.pulit.mysqltest.controller;

import jp.pulit.mysqltest.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.Control;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@RestController
@EnableCaching
public class Controller {

    private final Logger log = LoggerFactory.getLogger(Control.class);


    @Autowired
    private ImageService imageService;


    @GetMapping("/fail")
    public String fail() {
        return "fail";
    }

    @GetMapping("/hello")
    public String signedUp() {
        return "hello";
    }

    @PostMapping("/image")
    public @ResponseBody String getImageDataWithUID(@RequestParam BigDecimal uid) {

//        HttpSession session = request.getSession();

//        UUID uuid = Optional.ofNullable(UUID.class.cast(session.getAttribute("uid"))) .orElse(UUID.randomUUID());
//        session.setAttribute("uid", uuid);

        long start = System.currentTimeMillis();
        String title = imageService.getImageDTO(uid);
        long end = System.currentTimeMillis();

        log.info(title+ "의 NoCache 수행시간 : "+ Long.toString(end-start));

        return title;
    }
}
