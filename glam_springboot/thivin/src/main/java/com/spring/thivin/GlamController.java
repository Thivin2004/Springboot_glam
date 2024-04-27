package com.spring.thivin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class GlamController
{
    @Autowired
    GlamService ps;

    @PostMapping("/glam/item")
    public ResponseEntity<Glam> adddata(@RequestBody Glam p)
    {
        Glam obj=ps.create(p);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @GetMapping("/glam/item/{itemId}")
    public ResponseEntity<Glam> get(@PathVariable("itemId") int itId )
    {
        try 
        {
        Glam p = ps.getById(itId);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    catch (Exception e)
    {
            return new ResponseEntity<>(HttpStatus.OK);

        }
    }

    @GetMapping("/glam/sort/{field}")
    public ResponseEntity<List<Glam>> getbysort(@PathVariable String field)
    {
        try
        {
            return new ResponseEntity<>(ps.getbysort(field),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/glam/item/{itemId}")
    public ResponseEntity<Glam> putMethod(@PathVariable("itemId") int itemId,@RequestBody Glam pd)
    {
        if(ps.updateDetails(itemId,pd) == true)
        {
            return new ResponseEntity<>(pd,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/glam/item/{itemId}")
    public ResponseEntity<Boolean> delete(@PathVariable("itemId") int itemId)
    {
        if(ps.deleteDetails(itemId) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}