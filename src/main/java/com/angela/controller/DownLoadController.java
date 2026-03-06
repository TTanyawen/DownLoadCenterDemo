package com.angela.controller;

import com.angela.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownLoadController {
    @Autowired
    DownLoadService downLoadService;

// http://localhost:8087/download/exportUserOlderThen18
    @RequestMapping("/exportUserOlderThen18")
    public void exportUserOlderThen18(){
        downLoadService.exportUserOlderThen18();
    }

    // http://localhost:8087/download/exportUserOlderThen18/async
    @RequestMapping("/exportUserOlderThen18/async")
    public String exportUserOlderThen18Async(){
        downLoadService.exportUserOlderThen18Async();
        return "success";
    }

}
