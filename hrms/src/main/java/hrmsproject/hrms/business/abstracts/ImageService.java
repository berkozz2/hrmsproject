package hrmsproject.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.Image;

public interface ImageService {
	Result upload(int id, MultipartFile file);
	
	DataResult<List<Image>> getAll();
	
	DataResult<Image> getByCandidate_Id(int candidateId);
}
