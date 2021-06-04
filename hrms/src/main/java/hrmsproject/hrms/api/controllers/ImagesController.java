package hrmsproject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmsproject.hrms.business.abstracts.ImageService;

@RestController
@RequestMapping(value = "/api/images")
public class ImagesController {
	
	private ImageService imageService;
	
	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestParam(value="id") int id, @RequestParam(value="file") MultipartFile file){
		return ResponseEntity.ok(this.imageService.upload(id, file));
	}
	

}
