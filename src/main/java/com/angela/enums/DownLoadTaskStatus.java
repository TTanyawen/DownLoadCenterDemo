package com.angela.enums;

public enum DownLoadTaskStatus {

    PROCESSING(1),
    PROCESS_DONE(2),
    PROCESS_FAIL(3),
    CANCELED(4),
    DELETE(5);

    private final int code;

    DownLoadTaskStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static DownLoadTaskStatus fromCode(int code) {
        for (DownLoadTaskStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid DownLoadTaskStatus code: " + code);
    }
}
//PROCESSING 进行中
//PROCESS_DONE 已完成
//PROCESS_FAIL 已失败
//CANCELED 已取消
//DELETE 已删除