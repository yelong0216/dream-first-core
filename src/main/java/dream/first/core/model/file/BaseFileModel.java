package dream.first.core.model.file;

import org.yelong.core.model.annotation.Column;

import com.google.gson.annotations.Expose;

import dream.first.core.model.BaseModel;

/**
 * 基础的文件模型
 * 
 * @param <M> model type
 * @since 2.0
 */
public abstract class BaseFileModel<M extends BaseFileModelable> extends BaseModel<M> implements BaseFileModelable {

	private static final long serialVersionUID = -5733126645731716815L;

	@Column(column = "fileName", maxLength = 512, allowNull = true, columnName = "文件名称")
	private String fileName;

	@Column(column = "newFileName", maxLength = 512, allowNull = true, columnName = "文件新名称")
	private String newFileName;

	@Column(column = "fileType", maxLength = 32, allowNull = true, columnName = "文件类型")
	private String fileType;

	@Column(column = "fileSize", allowNull = true, columnName = "文件大小")
	private Long fileSize;

	@Expose // 路径不允许被转换为JSON
	@Column(column = "filePath", maxLength = 200, allowNull = true, columnName = "存储路径")
	private String filePath;

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public String getFileType() {
		return fileType;
	}

	@Override
	public String getNewFileName() {
		return newFileName;
	}

	@Override
	public Long getFileSize() {
		return fileSize;
	}

	@Override
	public String getFilePath() {
		return filePath;
	}

	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	@Override
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
