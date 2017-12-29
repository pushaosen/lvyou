package com.itqf.lvyou.service.impl;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.itqf.lvyou.WoException;
import com.itqf.lvyou.WoResultCode;
import com.itqf.lvyou.service.FileService;

/**
 * 上传图片或照片的service
 * @author Administrator
 *
 */
@Service
public class FileServiceImpl implements FileService{
	
	private final static String DIR_UPLOAD = "upload/";
	
	private final static WoResultCode SAVE = new WoResultCode(3001, "保存文件到服务器失败！");

	@Override
	public String uploadFile(MultipartFile file, HttpServletRequest request) {
		// 获取服务器上传文件的目录全路径
		String path = request.getServletContext().getRealPath(DIR_UPLOAD);
		// 获取上传文件名
		String filename = file.getOriginalFilename();
		// 如果upload目录不存在，则创建
		File dirUpload = new File(path);
		if (!dirUpload.exists()) {
			dirUpload.mkdirs();
		}
		// 构建目标文件
		File targetFile = new File(path,filename);
		// 保存文件到目标文件
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			throw new WoException(SAVE);
		}
		return DIR_UPLOAD + filename;
	}

}