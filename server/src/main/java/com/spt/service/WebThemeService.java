package com.spt.service;

import com.spt.atom.WebThemeAtom;
import com.spt.entity.WebTheme;

import java.util.List;

public interface WebThemeService {
    List<WebThemeAtom> fetchAll();
    List<WebThemeAtom> fetchListByAssociatedUrl(String url);
    WebThemeAtom createTheme(WebThemeAtom webTheme);
    WebThemeAtom updateTheme(WebThemeAtom webThemeUpdates, WebTheme webThemeToEdit);
    WebThemeAtom deleteTheme(WebTheme webTheme);
}
