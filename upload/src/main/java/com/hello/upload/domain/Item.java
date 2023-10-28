package com.hello.upload.domain;


import com.hello.upload.file.UploadFile;
import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
