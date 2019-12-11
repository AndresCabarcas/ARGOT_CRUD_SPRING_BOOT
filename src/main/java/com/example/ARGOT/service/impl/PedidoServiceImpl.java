/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ARGOT.service.impl;

import com.example.ARGOT.commons.GenericServiceimpl;
import com.example.ARGOT.dao.api.PedidoDaoAPI;
import com.example.ARGOT.modelos.Pedido;
import com.example.ARGOT.service.api.PedidoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class PedidoServiceImpl extends GenericServiceimpl<Pedido, Long> implements PedidoServiceAPI{

    @Autowired
    private PedidoDaoAPI pedidoDaoAPI;

    @Override
    public CrudRepository<Pedido, Long> getDao() {
        return pedidoDaoAPI;
    }

}
