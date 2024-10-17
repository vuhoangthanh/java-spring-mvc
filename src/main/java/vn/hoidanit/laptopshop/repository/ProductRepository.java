package vn.hoidanit.laptopshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
        // Product findById(long id);

        // void deleteById(long id);

        // Product findByNameOrShortDescOrFactoryOrPriceOrSoldOrTarget(String name,
        // String shortDesc, String factory,
        // String sold, String target);

        Page<Product> findAll(Pageable page);

        Page<Product> findAll(Specification<Product> spec, Pageable page);

        @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
                        + " OR p.detailDesc LIKE %?1%"
                        + " OR p.shortDesc LIKE %?1%"
                        + " OR p.target LIKE %?1%"
                        + " OR p.factory LIKE %?1%"
                        + " OR CONCAT(p.price, '') LIKE %?1%")
        Page<Product> findAll(Specification<Product> spec, Pageable page, String keyword);

        @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
                        + " OR p.detailDesc LIKE %?1%"
                        + " OR p.shortDesc LIKE %?1%"
                        + " OR p.target LIKE %?1%"
                        + " OR p.factory LIKE %?1%"
                        + " OR CONCAT(p.price, '') LIKE %?1%")
        Page<Product> search(String keyword, Pageable page);

}
