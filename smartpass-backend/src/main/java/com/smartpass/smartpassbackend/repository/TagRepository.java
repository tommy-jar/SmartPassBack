package com.smartpass.smartpassbackend.repository;

import com.smartpass.smartpassbackend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}