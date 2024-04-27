package com.spring.thivin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

// import com.spring.thivin.model.*;
// import com.spring.thivin.repository.*;

@Service
public class GlamService {
   
    @Autowired
    GlamRepo pr;

    //post
    public Glam create(Glam p)
    {
       
        return pr.save(p);
    }

    //getbyid
    public Glam getById(int itemId)
    {
        return pr.findById(itemId).orElse(null);
    }
    //put
    public boolean updateDetails(int itemId,Glam p)
    {
        if(pr.findById(itemId)==null)
        {
            return false;
        }
        try
        {
            pr.save(p);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean deleteDetails(int itId)
    {
        if(this.getById(itId) == null)
        {
            return false;
        }
        pr.deleteById(itId);
        return true;
    }

    public List<Glam> getbysort(String field)
    {
        return pr.findAll(Sort.by(Sort.Direction.ASC,field));
    }

}