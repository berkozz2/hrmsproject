package hrmsproject.hrms.core.utilities.images;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.ErrorDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadHelper implements ImageUploadService{

	@Override
	public DataResult<Map> upload(MultipartFile file) {
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","berkozz",
				"api_key","473819783621782",
				"api_secret","U79nQl20yKlRjhyAnRezSLbPdi4"));
		
		try {
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(uploadResult);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return new ErrorDataResult<Map>();
	}

}
