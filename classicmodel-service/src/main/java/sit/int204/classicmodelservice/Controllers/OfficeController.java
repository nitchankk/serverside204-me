package sit.int204.classicmodelservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelservice.Service.OfficeService;
import sit.int204.classicmodelservice.entities.Office;

import java.util.List;

//ตัวที่พร้อมให้บริการ Rest API
//แยก method ของ crud เลย
//จะเข้า class officeController แล้วดูว่าเราส่งมาแบบไหน
//ถ้าแบบ get ก็จะเข้า method getmapping ถ้ามี code ต่อท้ายก็เข้า getmappin {officeCode}
// ถ้าส่งเเบบ post / put / delete ก็จะเข้า method ของตัวมันเอง
@RestController
@RequestMapping("/api/offices")
    public class OfficeController {
        @Autowired
        private OfficeService service;
        //เป็นการดึงข้อมูลทั้งหมด
        @GetMapping("")
        public List<Office> getAllOffices(@RequestParam(required = false) String city) {
            return service.getAllOffice(city);
        }

        //เป็นการดึงข้อมูลตาม id
        @GetMapping("/{officeCode}")
        public Office getOfficeById(@PathVariable String officeCode) {
            return service.getOffice(officeCode);
        }
        //เป็นการเพิ่มข้อมูล
        @PostMapping("")
        public Office addNewOffice(@RequestBody Office office) {
            return service.createNewOffice(office);
        }
        //เป็นการ update ข้อมูล
        @PutMapping("/{officeCode}")
        public Office updateOffice(@RequestBody Office office, @PathVariable String officeCode) {
            return service.updateOffice(officeCode, office);
        }
        //เป็นการลบข้อมูล
        @DeleteMapping("/{officeCode}")
        public void removeOffice(@PathVariable String officeCode) {
            service.removeOffice(officeCode);
        }
    }

