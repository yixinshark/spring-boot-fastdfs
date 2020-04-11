package com.zyz.springbootfastdfs.controller;

import com.zyz.springbootfastdfs.FastDFSClientUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: zyz
 * @date: 4/2/20 - 1:51 PM
 * @function:
 */
@RestController
public class FileController {
    @Resource
    private FastDFSClientUtil fileDfsUtil ;
    /**
     * 文件上传
     */
    @ApiOperation(value="上传文件", notes="测试FastDFS文件上传")
    @RequestMapping(value = "/uploadFile",headers="content-type=multipart/form-data", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile (@RequestParam("file") MultipartFile file){
        String result ;
        try{
            String path = fileDfsUtil.upload(file) ;
            if (!StringUtils.isEmpty(path)){
                result = path ;
            } else {
                result = "上传失败" ;
            }
        } catch (Exception e){
            e.printStackTrace() ;
            result = "服务异常" ;
        }
        return ResponseEntity.ok(result);
    }
    /**
     * 文件删除
     */
    @RequestMapping(value = "/deleteByPath", method = RequestMethod.GET)
    public ResponseEntity<String> deleteByPath (){
        String filePathName = "group1/M00/00/00/wKgfJl6FVcGAcHOqAA-itrfn0m4.tar.gz" ;
        fileDfsUtil.deleteFile(filePathName);
        return ResponseEntity.ok("SUCCESS") ;
    }

    @ApiOperation(value="下载文件", notes="测试FastDFS文件下载")
    @GetMapping("/downloadFile")
    public ResponseEntity<String> downloadFile(){
        String g = "group1/M00/00/00/wKgfJl6FgwOAKcl0AADM4Es7Ork837.png";
        byte[] bytes = fileDfsUtil.downloadFile(g);
        // System.out.println(bytes);
        try {
            writeFile(bytes);
            System.out.println("download file");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("SUCCESS");
    }

    public void writeFile(byte[] bytes) throws IOException {
        OutputStream outputStream = new FileOutputStream("/home/zyz/hello.png");
        outputStream.write(bytes);
        outputStream.close();
    }
}
