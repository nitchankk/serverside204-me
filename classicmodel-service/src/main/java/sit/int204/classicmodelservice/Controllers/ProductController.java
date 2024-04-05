package sit.int204.classicmodelservice.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelservice.Service.ListMapper;
import sit.int204.classicmodelservice.Service.ProductService;
import sit.int204.classicmodelservice.dtos.PageDTO;
import sit.int204.classicmodelservice.dtos.VerySimpleProductDTO;
import sit.int204.classicmodelservice.entities.Product;
import sit.int204.classicmodelservice.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;
    @GetMapping("")
    public ResponseEntity<Object> findAllProducts(
            @RequestParam(defaultValue = "0") Double lower,
            @RequestParam(defaultValue = "0") Double upper,
            @RequestParam(defaultValue = "") String partOfProductName,
            @RequestParam(defaultValue = "") String[] sortBy,
            @RequestParam(defaultValue = "ASC") String[] direction,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize)
    {
        Page<Product> productPage = service.getProducts(partOfProductName,lower,upper,
                sortBy,direction,pageNo,pageSize);
        PageDTO<VerySimpleProductDTO> pageDTO = listMapper.toPageDTO(productPage, VerySimpleProductDTO.class, modelMapper);
        return ResponseEntity.ok(pageDTO);
    }
    @GetMapping("/product-line/{id}")
    public ResponseEntity<Object> getProductsByCategory(@PathVariable String id) {
        List<Product> productList = service.getProductsByCategory(id);
        List<VerySimpleProductDTO> vsp = productList.stream().map(p->modelMapper.
                map(p, VerySimpleProductDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(vsp);
    }
}
