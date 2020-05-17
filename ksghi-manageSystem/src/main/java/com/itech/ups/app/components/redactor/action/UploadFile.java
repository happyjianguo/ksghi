package com.itech.ups.app.components.redactor.action;

import com.itech.core.util.DateHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.components.filesync.MoreSystemFileSynchronizer;
import com.itech.ups.base.ApplicationConstant;
import com.itech.ups.base.web.action.AbstractActionParent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-4-5
 * @author  zqs
 * ===========================================================================
 *
 */
@Controller
public class UploadFile extends AbstractActionParent {

    @Autowired
    private MoreSystemFileSynchronizer moreSystemFileSynchronizer;
    @Autowired
    private FileSynchronizer fileSynce;
    // 新增图片服务器访问地址
    @Value("${product.pictureServerURL}")
    private String pictureServerURL;

    @RequestMapping("/portal/file/upload")
    public void upload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = true) MultipartFile file) throws Exception {

        long random = new Random(100000000).nextLong();
        if (!file.isEmpty()) {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            String fileName = file.getOriginalFilename();
            String extension = StringHelper.unqualify(fileName).toLowerCase();
            fileName = DateHelper.getCurrentDate().getTime() + "_" + random + "." + extension;
            String rootPath = ApplicationConstant.APP_UPLOAD_REDACTOR_FILE_PATH;
            File rootFile = new File(realPath + rootPath);
            if (!rootFile.exists()) {
                FileUtils.forceMkdir(rootFile);
            }
            String filePath = rootPath + "/" + fileName;
            File realFilePath = new File(realPath + filePath);

            file.transferTo(realFilePath);
            moreSystemFileSynchronizer.syncFile(realFilePath, rootPath, fileName); // 上传到网站端
            String receiverContextPath = fileSynce.getReceiverContextPath();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            // 获取输出对象，输出XML文件到客户端
            PrintWriter out = response.getWriter();
            out.write("{\"filelink\":\"" + receiverContextPath + filePath + "\"}");
            out.flush();
            out.close();
        }
    }
}
