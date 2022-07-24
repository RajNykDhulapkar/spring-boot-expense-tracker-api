package com.melodyjumper.expensetrackerapi.repositories;

import java.util.List;

import com.melodyjumper.expensetrackerapi.domain.Transaction;
import com.melodyjumper.expensetrackerapi.exceptions.EtBadRequestException;
import com.melodyjumper.expensetrackerapi.exceptions.EtResourceNotFoundException;

public interface TransactionRepository {
    List<Transaction> findAll(Integer userId, Integer categoryId);

    Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

    Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate)
            throws EtBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
            throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}
