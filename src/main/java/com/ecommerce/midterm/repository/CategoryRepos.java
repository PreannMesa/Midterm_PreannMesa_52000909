package com.ecommerce.midterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;
@Repository
public interface CategoryRepos extends JpaRepository<Locale.Category, Integer> {

}
