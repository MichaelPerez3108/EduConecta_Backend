package com.educonecta.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educonecta.app.entity.Mensageschat;

public interface IMensagesChatJpa extends JpaRepository<Mensageschat, String>{

}