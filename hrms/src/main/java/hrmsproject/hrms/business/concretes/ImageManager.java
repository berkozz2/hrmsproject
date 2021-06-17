package hrmsproject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrmsproject.hrms.business.abstracts.ImageService;
import hrmsproject.hrms.core.utilities.images.ImageUploadService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.ImageDao;
import hrmsproject.hrms.entities.concretes.Candidate;
import hrmsproject.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {
	
	private ImageDao imageDao;
	private ImageUploadService imageHelper;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageHelper) {
		super();
		this.imageDao = imageDao;
		this.imageHelper = imageHelper;
	}

	@Override
	public Result upload(int id, MultipartFile file) {
		@SuppressWarnings("unchecked")
		Map<String,String> hey=(Map<String,String>)this.imageHelper.upload(file).getData();
		
		Candidate candidate=new Candidate();
		Image image = new Image();
		candidate.setId(id);
		image.setCandidate(candidate);
		
		 image.setUrlAddress(hey.get("url"));
		 image.setUpdateDate(LocalDate.now());
		
	
		this.imageDao.save(image);
		return new SuccessResult(true,"Image Updated");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

	@Override
	public DataResult<Image> getByCandidate_Id(int candidateId) {
		
		return new SuccessDataResult<Image>(this.imageDao.getByCandidate_Id(candidateId));
	}
	
}
