package com.proyecto.hotel.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.hotel.aplicacion.casosuso.entrada.IHuespedUseCase;
import com.proyecto.hotel.aplicacion.casosuso.impl.HuespedUseCaseImpl;
import com.proyecto.hotel.dominio.repositorios.IHuespedRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.adaptadores.HuespedRepositorioImpl;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IHuespedJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IHuespedJpaRepositorio;

import com.proyecto.hotel.aplicacion.casosuso.entrada.IEstadiaUseCase;
import com.proyecto.hotel.aplicacion.casosuso.impl.EstadiaUseCaseImpl;
import com.proyecto.hotel.dominio.repositorios.IEstadiaRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.adaptadores.EstadiaRepositorioImpl;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IEstadiaJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.ICatalogoJpaRepositorio;
import com.proyecto.hotel.infraestructura.repositorios.IDetalleServicioJpaRepositorio;
import com.proyecto.hotel.infraestructura.repositorios.IEstadiaJpaRepositorio;

import com.proyecto.hotel.aplicacion.casosuso.entrada.IHabitacionUseCase;
import com.proyecto.hotel.aplicacion.casosuso.impl.HabitacionUseCaseImpl;
import com.proyecto.hotel.dominio.repositorios.IHabitacionRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.adaptadores.HabitacionRepositorioImpl;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IHabitacionJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IHabitacionJpaRepositorio;

import com.proyecto.hotel.aplicacion.casosuso.entrada.ICatalogoServicioUseCase;
import com.proyecto.hotel.aplicacion.casosuso.impl.CatalogoServicioUseCaseImpl;
import com.proyecto.hotel.dominio.repositorios.ICatalogoServicioRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.adaptadores.CatalogoServicioRepositorioImpl;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.ICatalogoServicioJpaMapper;

import com.proyecto.hotel.aplicacion.casosuso.entrada.IDetalleServicioEstadiaUseCase;
import com.proyecto.hotel.aplicacion.casosuso.impl.DetalleServicioEstadiaUseCaseImpl;
import com.proyecto.hotel.dominio.repositorios.IDetalleServicioEstadiaRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.adaptadores.DetalleServicioEstadiaRepositorioImpl;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IDetalleServicioEstadiaJpaMapper;

@Configuration
public class HotelConfig {

	@Bean
	IHuespedRepositorio huespedRepositorio(IHuespedJpaRepositorio jpaRepository, IHuespedJpaMapper mapper) {
		return new HuespedRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IHuespedUseCase huespedUseCase(IHuespedRepositorio repositorio) {
		return new HuespedUseCaseImpl(repositorio);
	}

	@Bean
	IEstadiaRepositorio estadiaRepositorio(IEstadiaJpaRepositorio jpaRepository, IEstadiaJpaMapper mapper) {
		return new EstadiaRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IEstadiaUseCase estadiaUseCase(
			IEstadiaRepositorio repositorio, 
			IHuespedRepositorio huespedRepositorio, 
			IHabitacionRepositorio habitacionRepositorio) {
		return new EstadiaUseCaseImpl(repositorio, huespedRepositorio, habitacionRepositorio);
	}

	@Bean
	IHabitacionRepositorio habitacionRepositorio(IHabitacionJpaRepositorio jpaRepository, IHabitacionJpaMapper mapper) {
		return new HabitacionRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IHabitacionUseCase habitacionUseCase(IHabitacionRepositorio repositorio) {
		return new HabitacionUseCaseImpl(repositorio);
	}

	@Bean
	ICatalogoServicioRepositorio catalogoServicioRepositorio(ICatalogoJpaRepositorio jpaRepository,
			ICatalogoServicioJpaMapper mapper) {
		return new CatalogoServicioRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	ICatalogoServicioUseCase catalogoServicioUseCase(ICatalogoServicioRepositorio repositorio) {
		return new CatalogoServicioUseCaseImpl(repositorio);
	}

	
	@Bean
	IDetalleServicioEstadiaRepositorio detalleServicioEstadiaRepositorio(IDetalleServicioJpaRepositorio jpaRepository, 
			IDetalleServicioEstadiaJpaMapper mapper) {
		return new DetalleServicioEstadiaRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IDetalleServicioEstadiaUseCase detalleServicioEstadiaUseCase(
	        IDetalleServicioEstadiaRepositorio repositorio,
	        IEstadiaRepositorio estadiaRepositorio,
	        ICatalogoServicioRepositorio catalogoServicioRepositorio) {
	    return new DetalleServicioEstadiaUseCaseImpl(repositorio, estadiaRepositorio, catalogoServicioRepositorio);
	}

}