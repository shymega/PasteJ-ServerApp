package com.github.shymega.pastej.repository;

import com.github.shymega.pastej.model.PasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastesRepository extends JpaRepository<PasteEntity, String> {
}