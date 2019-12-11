/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ARGOT.dao.api;

import com.example.ARGOT.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface ProductoDaoAPI extends CrudRepository<Producto, Long>{
    
}
