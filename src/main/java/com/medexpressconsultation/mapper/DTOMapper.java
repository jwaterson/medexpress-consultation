package com.medexpressconsultation.mapper;

public interface DTOMapper<T, U> {

  T toObject(U dto);

  U toDTO(T object);

}