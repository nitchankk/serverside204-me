package sit.int204.classicmodelservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelservice.entities.Office;
import sit.int204.classicmodelservice.repositories.OfficeRepository;

import java.util.List;

//Office เป็นตัวเรียก CRUD
@Service
    public class OfficeService {
        @Autowired
        private OfficeRepository repository;
       public  List<Office> getAllOffice() {
           return getAllOffice(null);
       }
        public List<Office> getAllOffice(String city) {
            if (city == null || city.isEmpty()) {
                return repository.findAll();
            } else {
                return repository.findByCityContains(city);
            }
        }

        public Office getOffice(String officeCode) {
            return repository.findById(officeCode).orElseThrow(
                    () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + officeCode + " DOES NOT EXIST !!!") {
                    }
            );
        }
        @Transactional
        public Office createNewOffice(Office office) {
            return repository.save(office);
        }
    @Transactional
    public void removeOffice(String officeCode) {
        Office office = repository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + officeCode + " DOES NOT EXIST !!!")
        );
        repository.delete(office);
    }
    @Transactional
    public Office updateOffice(String officeCode, Office office) {
        if(office.getOfficeCode()!=null && !office.getOfficeCode().trim().isEmpty()) {
            if (!office.getOfficeCode().equals(officeCode)) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                        "Conflict Office code !!! (" + officeCode +
                                " vs " + office.getOfficeCode() + ")");
            }
        }
        Office existingOffice = repository.findById(officeCode).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        "Office Id " + officeCode + " DOES NOT EXIST !!!"));
        return repository.save(office);
    }
}