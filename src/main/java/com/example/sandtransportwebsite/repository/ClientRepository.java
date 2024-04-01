package com.example.sandtransportwebsite.repository;
import com.example.sandtransportwebsite.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
