package com.ecommerce.midterm.iservice;

import com.ecommerce.midterm.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Locale;

public interface ICategoryService {
    List<Locale.Category> selectAll();

    Page<Locale.Category> selectAll(Pageable pageable);

    Locale.Category selectById(Integer id);

    Category insert(Category category);

    boolean deleteById(Integer id);

    Category update(Category categoryUpdate);
}
