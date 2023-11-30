package com.ecommerce.midterm.service;

import com.ecommerce.midterm.iservice.ICategoryService;
import com.ecommerce.midterm.model.Category;
import com.ecommerce.midterm.repository.CategoryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepos categoryRepos;
    public List<Locale.Category> getAllCategory()
    {
        return categoryRepos.findAll();
    }


    @Override
    public List<Locale.Category> selectAll() {
        return categoryRepos.findAll();
    }

    @Override
    public Page<Locale.Category> selectAll(Pageable pageable) {
        return categoryRepos.findAll(pageable);
    }

    @Override
    public Locale.Category selectById(Integer id) {
        return categoryRepos.findById(id).orElse(null);
    }

    @Override
    public Category insert(Category category) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (categoryRepos.existsById(id))
            categoryRepos.deleteById(id);
        return !categoryRepos.existsById(id);
    }

    @Override
    public Category update(Category categoryUpdate) {
        return null;

    }

}
