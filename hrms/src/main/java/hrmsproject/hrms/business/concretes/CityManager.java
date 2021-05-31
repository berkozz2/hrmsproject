package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.CityService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.dataAccess.abstracts.CityDao;
import hrmsproject.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler Listelendi");
	}

}
