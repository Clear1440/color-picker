package com.spt.controller;

import com.spt.atom.WebThemeAtom;
import com.spt.entity.WebTheme;
import com.spt.service.WebThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/web_themes")
@CrossOrigin(origins ="*", maxAge = 3600)
public class WebThemeController {
    public final WebThemeService webThemeService;
    @Autowired
    public WebThemeController(WebThemeService webThemeService){
        this.webThemeService = webThemeService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<WebThemeAtom>> getThemes(){
        return new ResponseEntity<>( webThemeService.fetchAll(), HttpStatus.OK);
    }

    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebThemeAtom> createTheme(@RequestBody WebThemeAtom webThemeAtom){
        return new ResponseEntity<>(webThemeService.createTheme(webThemeAtom),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WebThemeAtom> getThemeById(@ModelAttribute("id") WebTheme webTheme){
        return new ResponseEntity<>(webTheme.toAtom(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebThemeAtom> updateTheme(
            @ModelAttribute("id") WebTheme webThemeToEdit,
            @RequestBody WebThemeAtom webThemeUpdates
            ){
        return new ResponseEntity<>(webThemeService.updateTheme(webThemeUpdates,webThemeToEdit), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<WebThemeAtom> deleteThemeById(@PathVariable("id") WebTheme id){
        return new ResponseEntity<>( webThemeService.deleteTheme(id), HttpStatus.OK);
    }

    @GetMapping(value = "/get-theme-by-associated-url/{url}")
    public ResponseEntity<List<WebThemeAtom>> getThemesByAssociatedUrl(@PathVariable("url") String url){
        return new ResponseEntity<>(webThemeService.fetchListByAssociatedUrl(url), HttpStatus.OK);
    }
}
