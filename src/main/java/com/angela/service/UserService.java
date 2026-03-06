package com.angela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DownLoadCommonService downLoadCommonService;

    public void exportUserOlderThen18Async() {
        //创建任务
        System.out.println("导出所有大于18岁的user到excel表");

        String fileName = "E:\\AAAProjectForLearning\\DownLoadCenterDemo\\DownLoadCenterDemo\\temp\\user_over_18.xlsx";
        int bz=100;

        // 需要执行的SQL
        String baseSql = "SELECT id,name,age FROM t_user_0306 WHERE age > 18";

        //调用通用方法进行导出，传入批大小，sql语句，文件名
        downLoadCommonService.startExportAsync(bz,baseSql,fileName);
    }
}