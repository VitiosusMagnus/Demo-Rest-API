package com.vitiosusmagnus.demorestapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity,Long> {
}
