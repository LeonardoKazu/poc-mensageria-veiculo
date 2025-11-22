package com.leonardokazu.poc_mensageria_docker;

import com.leonardokazu.poc_mensageria_docker.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
