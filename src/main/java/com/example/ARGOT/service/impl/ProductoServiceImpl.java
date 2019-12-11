/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ARGOT.service.impl;

import com.example.ARGOT.commons.GenericServiceimpl;
import com.example.ARGOT.dao.api.ProductoDaoAPI;
import com.example.ARGOT.modelos.Producto;
import com.example.ARGOT.service.api.ProductoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ProductoServiceImpl extends GenericServiceimpl<Producto, Long> implements ProductoServiceAPI{
    @Autowired
    private ProductoDaoAPI productoDaoAPI;

    @Override
    public CrudRepository<Producto, Long> getDao() {
        return productoDaoAPI;
    }
}
