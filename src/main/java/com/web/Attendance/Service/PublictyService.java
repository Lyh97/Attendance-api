package com.web.Attendance.Service;

import com.web.Attendance.Entity.Publicty;
import com.web.Attendance.Mapper.PublictyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PublictyService {
    @Resource
    PublictyMapper mapper;

    public List<Publicty> getPublicty() {
        return mapper.getPublicty();
    }

    public void addPublictyInfo(Publicty publictyInfo) {
        mapper.addPublictyInfo(publictyInfo);
    }

    public Publicty getPublictyById(Integer id) {
        return mapper.getPublictyById(id);
    }

    public void deletePublictyById(Integer id) {
        mapper.deletePublictyById(id);
    }

    public void updatePublictyById(Publicty publicty) {
        mapper.updatePublictyById(publicty);
    }
}
