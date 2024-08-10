package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Product findById(long id);

    // void deleteById(long id);

    // Product findByNameOrShortDescOrFactoryOrPriceOrSoldOrTarget(String name,
    // String shortDesc, String factory,
    // String sold, String target);

    Page<Product> findAll(Pageable page);
}
