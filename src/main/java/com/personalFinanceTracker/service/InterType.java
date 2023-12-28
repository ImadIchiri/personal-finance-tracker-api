package com.personalFinanceTracker.service;

import com.personalFinanceTracker.model.Type;

import java.util.List;
import java.util.Optional;

public interface InterType {
    Type createType(Type type);

    List<Type> getAllTypes();

    Optional<Type> getTypeById(Long id);

    void deleteType(Type type);

    Type updateType(Type type);
}
