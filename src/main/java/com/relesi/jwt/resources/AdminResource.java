package com.relesi.jwt.resources;import com.relesi.jwt.domain.Admin;import com.relesi.jwt.resources.util.URL;import com.relesi.jwt.services.AdminService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.security.access.prepost.PreAuthorize;import org.springframework.web.bind.annotation.*;import java.util.Date;import java.util.List;@RestController@RequestMapping(value="/admin")public class AdminResource {    @Autowired    private AdminService service;    @PreAuthorize("hasAnyRole('ADMIN')")    @RequestMapping(value = "/{id}", method = RequestMethod.GET)    public ResponseEntity<Admin> findById(@PathVariable String id) {        Admin obj = service.findById(id);        return ResponseEntity.ok().body(obj);    }    @PreAuthorize("hasAnyRole('ADMIN')")    @RequestMapping(value = "/title-search", method = RequestMethod.GET)    public ResponseEntity<List<Admin>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {        text = URL.decodeParam(text);        List<Admin> list = service.findByTitle(text);        return ResponseEntity.ok().body(list);    }    @PreAuthorize("hasAnyRole('ADMIN')")    @RequestMapping(value="/full-search", method=RequestMethod.GET)    public ResponseEntity<List<Admin>> fullSearch(            @RequestParam(value="text", defaultValue="") String text,            @RequestParam(value="minDate", defaultValue="") String minDate,            @RequestParam(value="maxDate", defaultValue="") String maxDate) {        text = URL.decodeParam(text);        Date min = URL.convertDate(minDate, new Date(0L));        Date max = URL.convertDate(maxDate, new Date());        List<Admin> list = service.fullSearch(text, min, max);        return ResponseEntity.ok().body(list);    }}