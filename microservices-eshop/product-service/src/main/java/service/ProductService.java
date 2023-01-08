package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dto.ProductReponse;
import dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Product;
import repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());

    }

    public List<ProductReponse> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream().map(p -> mapToProductResponse(p)).collect(Collectors.toList()); // map(product->
                                                                                                 // mapToProductResponse(product))

    }

    private ProductReponse mapToProductResponse(Product product) {
        return ProductReponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
