package com.example.warehouse.product.service;

import com.example.warehouse.common.exception.BadRequestException;
import com.example.warehouse.common.exception.NotFoundException;
import com.example.warehouse.product.domain.Product;
import com.example.warehouse.product.dto.ProductRequest;
import com.example.warehouse.product.dto.ProductResponse;
import com.example.warehouse.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository repo;

    private ProductResponse toResp(Product p) {
        return new ProductResponse(p.getId(), p.getSku(), p.getName(), p.getUnit(), p.getMinStock(), p.getDescription());
    }

    private void apply(Product p, ProductRequest r) {
        p.setSku(r.sku());
        p.setName(r.name());
        p.setUnit(r.unit());
        p.setMinStock(r.minStock());
        p.setDescription(r.description());
    }

    public ProductResponse create(ProductRequest req) {
        if (repo.existsBySku(req.sku())) throw new BadRequestException("SKU đã tồn tại");
        Product p = Product.builder().build();
        apply(p, req);
        return toResp(repo.save(p));
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> list(String q, Pageable pageable) {
        Page<Product> page = (q == null || q.isBlank())
                ? repo.findAll(pageable)
                : repo.findByNameContainingIgnoreCaseOrSkuContainingIgnoreCase(q, q, pageable);
        return page.map(this::toResp);
    }

    @Transactional(readOnly = true)
    public ProductResponse get(Long id) {
        Product p = repo.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy sản phẩm"));
        return toResp(p);
    }

    public ProductResponse update(Long id, ProductRequest req) {
        Product p = repo.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy sản phẩm"));
        if (!p.getSku().equals(req.sku()) && repo.existsBySku(req.sku()))
            throw new BadRequestException("SKU đã tồn tại");
        apply(p, req);
        return toResp(p);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Không tìm thấy sản phẩm");
        repo.deleteById(id);
    }
}
