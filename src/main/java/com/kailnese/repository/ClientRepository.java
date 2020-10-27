package com.kailnese.repository;

import com.kailnese.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>, JpaSpecificationExecutor<Client> {
    Client findClientByUsername(String username);
//    @Modifying
//    @Query("update Client client set client = ?1 where client.id = ?2")
//    void setClientInfoById(Client client, Integer userId);
}
