/**
 * 
 */
package dream.first.core.model.file;

import dream.first.core.model.BaseModelable;

/**
 * @since 2.0
 */
public interface BaseFileModelable extends BaseModelable {

	// =================== get ===================

	/**
	 * @return 文件名称
	 */
	String getFileName();

	/**
	 * @return 文件类型
	 */
	String getFileType();

	/**
	 * @return 文件新名称
	 */
	String getNewFileName();

	/**
	 * @return 文件大小
	 */
	Long getFileSize();

	/**
	 * @return 存储路径
	 */
	String getFilePath();

	// =================== get ===================
	/**
	 * @param fileName 文件名称
	 */
	void setFileName(String fileName);

	/**
	 * @param newFileName 文件新名称
	 */
	void setNewFileName(String newFileName);

	/**
	 * @param fileType 文件类型
	 */
	void setFileType(String fileType);

	/**
	 * @param fileSize 文件大小
	 */
	void setFileSize(Long fileSize);

	/**
	 * @param filePath 存储路径
	 */
	void setFilePath(String filePath);

}
