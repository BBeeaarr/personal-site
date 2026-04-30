package com.armand.site.repository;

import com.armand.site.domain.NLCCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NLCRepository extends JpaRepository<NLCCase, Long> {}
