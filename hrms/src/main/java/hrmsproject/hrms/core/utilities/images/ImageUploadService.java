package hrmsproject.hrms.core.utilities.images;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import hrmsproject.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	DataResult<Map> upload(MultipartFile file);
}
