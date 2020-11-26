package firstjavarestful.first.java.restful.service.impl;

import firstjavarestful.first.java.restful.Validation.ValidationUtil;
import firstjavarestful.first.java.restful.entity.Product;
import firstjavarestful.first.java.restful.error.NotFoundException;
import firstjavarestful.first.java.restful.model.*;
import firstjavarestful.first.java.restful.repository.ProductRepository;
import firstjavarestful.first.java.restful.service.ProductService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    ValidationUtil validationUtil = new ValidationUtil();

    @Override
    public ProductResponse create(CreateProductRequest createProductRequest) throws ConstraintViolationException {
        validationUtil.validate(createProductRequest);
        Product product = new Product(
                createProductRequest.getId(),
                createProductRequest.getName(),
                createProductRequest.getPrice(),
                createProductRequest.getQuantity(),
                new Date(),
                null
        );

        repository.save(product);

        return convertProductToProductResponse(product);
    }

    @Override
    public ProductResponse get(String id) throws NotFoundException {
        Product product = findProductOrThrow(id);
        return convertProductToProductResponse(product);
    }

    @Override
    public ProductResponse update(String id, UpdateProductRequest updateProductRequest) throws NotFoundException {
        Product product = findProductOrThrow(id);

        validationUtil.validate(updateProductRequest);

        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setQuantity(updateProductRequest.getQuantity());
        product.setUpdatedAt(new Date());

        repository.saveAndFlush(product);

        return convertProductToProductResponse(product);

    }

    @Override
    public void delete(String id) throws NotFoundException {
        Product product = findProductOrThrow(id);
        repository.delete(product);
    }

    @Override
    public List<ProductResponse> getAll(ListProductRequest listProductRequest) {
        Page<Product> pageProduct = repository.findAll(PageRequest.of(listProductRequest.getPage(), listProductRequest.getSize()));
        List<Product> listProduct = pageProduct.get().collect(Collectors.toList());
        List<ProductResponse> listProductResponse = new ArrayList<>();
        listProduct.forEach(product -> listProductResponse.add(convertProductToProductResponse(product)));
        return listProductResponse;
    }


    private Product findProductOrThrow(String id) throws NotFoundException {
        Product product = repository.findById(id).orElse(null);
        if(product == null){
            throw new NotFoundException();
        }else{
            return product;
        }
    }

    private ProductResponse convertProductToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
