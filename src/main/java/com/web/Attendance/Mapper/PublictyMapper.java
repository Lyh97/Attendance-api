package com.web.Attendance.Mapper;

import com.web.Attendance.Entity.Publicty;

import java.util.List;

public interface PublictyMapper {
    List<Publicty> getPublicty();

    Publicty getPublictyById(Integer id);

    void addPublictyInfo(Publicty publictyInfo);

    void deletePublictyById(Integer id);

    void updatePublictyById(Publicty publicty);
}
