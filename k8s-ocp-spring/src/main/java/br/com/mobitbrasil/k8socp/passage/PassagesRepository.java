package br.com.mobitbrasil.k8socp.passage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagesRepository extends JpaRepository<Passage, String> {
}