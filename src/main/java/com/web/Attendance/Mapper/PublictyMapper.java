package com.web.Attendance.Mapper;

import com.web.Attendance.Entity.Comment;
import com.web.Attendance.Entity.Publicty;

import java.util.List;
import java.util.Map;

public interface PublictyMapper {
    List<Publicty> getPublicty();

    Publicty getPublictyById(Integer id);

    void addPublictyInfo(Publicty publictyInfo);

    void deletePublictyById(Integer id);

    void updatePublictyById(Publicty publicty);

    List<Publicty> getPublictyInfoById(String userId);

    void updatePublictyStatusById(Map<String, Object> map);

    void addCommentByPublictyId(Comment info);

    List<Comment> getCommentByPublictyId(Integer publictyId);
}
