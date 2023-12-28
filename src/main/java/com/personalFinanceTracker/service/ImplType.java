package com.personalFinanceTracker.service;

import com.personalFinanceTracker.model.Type;
import com.personalFinanceTracker.repository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplType implements InterType {

    @Autowired
    private  TypeRepo typeRepo;

    @Override
    public Type createType(Type type) {
        return typeRepo.save(type);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepo.findAll();
    }

    @Override
    public Optional<Type> getTypeById(Long id) {
        return typeRepo.findById(id);
    }

    @Override
    public void deleteType(Type type) {
        typeRepo.delete(type);
    }

    @Override
    public Type updateType(Type type) {
        return typeRepo.save(type);
    }
}
