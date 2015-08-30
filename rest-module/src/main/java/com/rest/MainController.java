package com.rest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main app controller
 * @author Gabriel
 */
@RestController
public class MainController {

    private Logger log = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> index() throws Exception {
        log.debug("GET request on path: /index");
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}