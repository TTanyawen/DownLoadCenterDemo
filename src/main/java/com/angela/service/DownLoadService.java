package com.angela.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.angela.dto.UserExcelDTO;
import com.angela.entity.DownLoadTask;
import com.angela.entity.DownLoadTaskDetail;
import com.angela.enums.DownLoadTaskStatus;
import com.angela.repo.DownLoadTaskDetailRepo;
import com.angela.repo.DownLoadTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DownLoadService {
    static int bs=500;
//    @Autowired
//    private UserRepo userRepo;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private DownLoadTaskRepo downLoadTaskRepo;
    @Autowired
    private DownLoadTaskDetailRepo downLoadTaskDetailRepo;
    //导出所有大于18岁的user到excel表
    //先做同步的
    public void exportUserOlderThen18(){
        System.out.println("开始导出所有大于18岁的user到excel表");

        String fileName = "E:\\AAAProjectForLearning\\DownLoadCenterDemo\\DownLoadCenterDemo\\temp\\user_over_18.xlsx";

        long lastId = 0;

        // 需要执行的SQL
        String baseSql = "SELECT id,name,age FROM t_user_0306 WHERE age > 18";

        //save任务
        DownLoadTask task = new DownLoadTask();
        task.setFileName(fileName);
        task.setStatus(DownLoadTaskStatus.PROCESSING.getCode());
        downLoadTaskRepo.save(task);

        //save detail表
        DownLoadTaskDetail taskDetail = new DownLoadTaskDetail();
        taskDetail.setTaskId(task.getId());
        taskDetail.setSqlText(baseSql);
        taskDetail.setColumnModel("id,name,age");
        downLoadTaskDetailRepo.save(taskDetail);

        ExcelWriter excelWriter = EasyExcel.write(fileName, UserExcelDTO.class).build();
        WriteSheet sheet = EasyExcel.writerSheet("user").build();

        try {

            while (true) {//分批导出数据
                String sql = baseSql +
                        " AND id > " + lastId +
                        " ORDER BY id LIMIT " + bs;
                Query query = entityManager.createNativeQuery(sql);
                List<Object[]> rows = query.getResultList();

                if (rows.isEmpty()) {
                    break;
                }

                List<UserExcelDTO> list = rows.stream().map(r -> {
                    UserExcelDTO dto = new UserExcelDTO();
                    dto.setId(((Number) r[0]).longValue());
                    dto.setName((String) r[1]);
                    dto.setAge(((Number) r[2]).intValue());
                    return dto;
                }).collect(Collectors.toList());

                excelWriter.write(list, sheet);

                lastId = list.get(list.size() - 1).getId();
                //记录lastId
                task.setLastId(lastId);
                downLoadTaskRepo.save(task);

                if (list.size() < bs) {//最后一批处理完成了
                    task.setStatus(DownLoadTaskStatus.PROCESS_DONE.getCode());
                    downLoadTaskRepo.save(task);
                    break;
                }
            }

        } finally {
            excelWriter.finish();
        }

        System.out.println("导出完成");

    }
}
