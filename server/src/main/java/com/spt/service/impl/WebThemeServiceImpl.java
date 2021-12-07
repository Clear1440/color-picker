package com.spt.service.impl;

import com.spt.atom.WebThemeAtom;
import com.spt.entity.WebTheme;
import com.spt.repository.WebThemeRepository;
import com.spt.service.WebThemeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebThemeServiceImpl implements WebThemeService {
    public WebThemeRepository webThemeRepository;
    public WebThemeServiceImpl(WebThemeRepository webThemeRepository){ this.webThemeRepository = webThemeRepository; }

    @Override
    public List<WebThemeAtom> fetchAll() {
        return webThemeRepository.retrieveAll().stream()
                .map(com.spt.entity.WebTheme::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public List<WebThemeAtom> fetchListByAssociatedUrl(String url) {
        String urlRegex = "%" + url + "%";
        return webThemeRepository.fetchListByAssociatedUrl(urlRegex).stream()
                .map(com.spt.entity.WebTheme::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public WebThemeAtom createTheme(WebThemeAtom webThemeAtom) {
        WebTheme webTheme = new WebTheme();
        return mergeAndSave(webThemeAtom, webTheme);
    }

    @Override
    public WebThemeAtom updateTheme(WebThemeAtom webThemeUpdates, WebTheme webThemeToEdit) {
        return mergeAndSave(webThemeUpdates, webThemeToEdit);
    }

    @Override
    public WebThemeAtom deleteTheme(WebTheme webTheme) {
        webTheme.setDateDeleted(new Date());
        return webThemeRepository.save(webTheme).toAtom();
    }

    private WebThemeAtom mergeAndSave(WebThemeAtom webThemeUpdates, WebTheme webThemeToEdit){
        webThemeToEdit.setTheme(webThemeUpdates.getTheme());
        webThemeToEdit.setAssociatedUrl(webThemeUpdates.getAssociatedUrl());
        return webThemeRepository.save(webThemeToEdit).toAtom();
    }
}
