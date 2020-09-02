package dream.first.core.model.file;

import org.springframework.web.multipart.MultipartFile;

import dream.first.core.utils.IDUtils;

/**
 * 文件模型工具类
 * 
 * @since 2.0
 */
public final class BaseFileModels {

	private BaseFileModels() {
	}

	/**
	 * 设置基础属性(文件名称、新文件名称、文件类型、文件大小);
	 * 
	 * @param fileModel     文件模型
	 * @param multipartFile 上传上来的文件
	 */
	public static void setBaseProperty(BaseFileModelable fileModel, MultipartFile multipartFile) {
		String fileName = multipartFile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = IDUtils.getUUID() + fileType;
		fileModel.setNewFileName(newFileName);
		fileModel.setFileName(fileName);
		fileModel.setFileType(fileType);
		fileModel.setFileSize(multipartFile.getSize());
	}

}
