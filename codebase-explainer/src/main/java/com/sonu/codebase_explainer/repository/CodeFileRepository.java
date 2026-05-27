package com.sonu.codebase_explainer.repository;

import com.sonu.codebase_explainer.model.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeFileRepository extends JpaRepository<Repo, Long> {
}
