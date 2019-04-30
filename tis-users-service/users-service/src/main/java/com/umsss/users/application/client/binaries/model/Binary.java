package com.umsss.users.application.client.binaries.model;

/**
 * @author Santiago Mamani
 */
public class Binary implements com.umss.tis.binaries.api.model.Binary {

    private String id;

    private String mimeType;

    private String fileName;

    private Long fileSize;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public Long getFileSize() {
        return fileSize;
    }
}
