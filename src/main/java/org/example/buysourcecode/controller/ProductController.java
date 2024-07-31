package org.example.buysourcecode.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.buysourcecode.dto.asset.AssetResponse;
import org.example.buysourcecode.dto.product.CreateProductRequest;
import org.example.buysourcecode.dto.product.ProductResponse;
import org.example.buysourcecode.dto.product.UpdateProductRequest;
import org.example.buysourcecode.exception.DuplicateException;
import org.example.buysourcecode.exception.NotFoundException;
import org.example.buysourcecode.map.AssetMapper;
import org.example.buysourcecode.map.ProductMapper;
import org.example.buysourcecode.model.*;
import org.example.buysourcecode.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final UserService userService;
    private final AssetService assetService;
    private final AssetMapper assetMapper;
    private final CloudStorageService cloudStorageService;
    private final AssetProductService assetProductService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {

        List<Product> productList = productService.getListProducts();
        List<ProductResponse> productResponseList = productList.stream()
                .map(productMapper::toProductResponse)
                .toList();
        return ResponseEntity.ok(productResponseList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable(value = "id") String id) {
        Product product = productService.getProductById(id);
        if(product == null) {throw new NotFoundException(String.format("Product with id %s not found", id));}
        return getProductResponseResponseEntity(product);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request) {

        Product product = productService.getProductBySlug(request.getSlug());
        if(product != null) {throw new DuplicateException(String.format("Product with slug %s found", request.getSlug()));}

        User user = userService.findUserById(request.getCreateBy());
        if(user == null) {throw new NotFoundException(String.format("User with id %s not found", request.getCreateBy()));}

        Product product1 = productMapper.toProduct(request);
        product1.setCreateBy(user);

        List<AssetProduct> assetProducts = new ArrayList<>();
        request.getAsserProductRequestList().forEach(item-> {

            Asset asset = assetService.findById(item.getAssetId());
            if(asset == null) {throw new NotFoundException(String.format("Asset with id %s not found", item.getAssetId()));}

            AssetProduct assetProduct = AssetProduct.builder()
                    .asset(asset)
                    .product(product1)
                    .indx(item.getIndex())
                    .build();

            assetProducts.add(assetProduct);
        });

        product1.setAssetProductList(assetProducts);

        productService.createProduct(product1);

        return getProductResponseResponseEntity(product1);
    }

    @PostMapping("/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody @Valid UpdateProductRequest request) {
        Product product = productService.getProductById(request.getId());
        if(product == null) {throw new NotFoundException(String.format("Product with id %s not found", request.getId()));}

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
//        product.setStatus(ProductStatus.valueOf(request.getStatus()));

        if(request.getImage() != null && !request.getImage().isEmpty()) {

            List<AssetProduct> assetProductDeleteds = assetProductService.getAssetProductsByProductId(request.getId());

            assetProductDeleteds.forEach(assetProductService::deleteAssetProduct);

            List<AssetProduct> assetProducts = new ArrayList<>();

            request.getImage().forEach(item->{
                Asset asset = assetService.findById(item.getAssetId());
                if(asset == null) {throw new NotFoundException(String.format("Asset with id %s not found", item.getAssetId()));}

                AssetProduct assetProduct = AssetProduct.builder()
                        .product(product)
                        .asset(asset)
                        .indx(item.getIndex())
                        .build();
                assetProducts.add(assetProduct);
            });

            product.setAssetProductList(assetProducts);
        }

        productService.updateProduct(product);

        return getProductResponseResponseEntity(product);
    }

    private ResponseEntity<ProductResponse> getProductResponseResponseEntity(Product product) {
        ProductResponse productResponse = productMapper.toProductResponse(product);

        List<AssetResponse> assetResponses = new ArrayList<>();

        assetProductService.getAssetProductsByProductId(product.getId()).forEach(item-> {
            AssetResponse assetResponse = assetMapper.toAssetResponse(item.getAsset());
            assetResponse.setUrl(cloudStorageService.getUrl(item.getAsset().getPath()));
            assetResponses.add(assetResponse);
        });

        productResponse.setImage(assetResponses);

        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") String id) {
        Product product = productService.getProductById(id);
        if(product == null) throw new NotFoundException("Product with id: " + id + " not found");
        productService.deleteProduct(product);
        return ResponseEntity.ok(id + " has been deleted");
    }

}
