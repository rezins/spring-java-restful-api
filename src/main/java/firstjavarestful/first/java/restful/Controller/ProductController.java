package firstjavarestful.first.java.restful.Controller;

import firstjavarestful.first.java.restful.error.NotFoundException;
import firstjavarestful.first.java.restful.model.*;
import firstjavarestful.first.java.restful.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/api/products")
    public WebResponse<ProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest){
        ProductResponse productResponse = productService.create(createProductRequest);
        return new WebResponse<ProductResponse>(
                200,
                "OK",
                productResponse
        );
    }

    @GetMapping("/api/products/{idProduct}")
    public WebResponse<ProductResponse> getProduct(@PathVariable String idProduct) throws NotFoundException {
        ProductResponse productResponse = productService.get(idProduct);
        return new WebResponse<ProductResponse>(
                200,
                "OK",
                productResponse
        );
    }

    @PutMapping("/api/products/{idProduct}")
    public WebResponse<ProductResponse> update(@PathVariable String idProduct, @RequestBody UpdateProductRequest updateProductRequest) throws NotFoundException {
        ProductResponse productResponse = productService.update(idProduct, updateProductRequest);
        return new WebResponse<ProductResponse>(
                200,
                "OK",
                productResponse
        );
    }

    @DeleteMapping("/api/products/{idProduct}")
    public WebResponse<String> delete(@PathVariable String idProduct) throws NotFoundException{
        productService.delete(idProduct);
        return new WebResponse<String>(
                200,
                "OK",
                "data has been deleted"
        );
    }

    @GetMapping("/api/products")
    public WebResponse<List<ProductResponse>> getAll(@RequestParam(value = "size", defaultValue = "10") Integer size,
                                               @RequestParam(value = "page", defaultValue = "0") Integer page){

        List<ProductResponse> list = productService.getAll(new ListProductRequest(page, size));
        return new WebResponse<List<ProductResponse>>(
                200,
                "OK",
                list
        );
    }

}
