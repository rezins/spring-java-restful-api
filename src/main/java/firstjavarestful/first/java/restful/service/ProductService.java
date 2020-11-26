package firstjavarestful.first.java.restful.service;

import firstjavarestful.first.java.restful.error.NotFoundException;
import firstjavarestful.first.java.restful.model.CreateProductRequest;
import firstjavarestful.first.java.restful.model.ListProductRequest;
import firstjavarestful.first.java.restful.model.ProductResponse;
import firstjavarestful.first.java.restful.model.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    ProductResponse create(CreateProductRequest createProductRequest);

    ProductResponse get(String id) throws NotFoundException;

    ProductResponse update(String id, UpdateProductRequest updateProductRequest) throws NotFoundException;

    void delete(String id) throws NotFoundException;

    List<ProductResponse> getAll(ListProductRequest listProductRequest);

}
