package com.umsss.users.application.model.repository;

import com.umsss.users.application.model.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Santiago Mamani
 */
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
