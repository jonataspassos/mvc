package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import resources.Theme;

@ManagedBean(eager = true)
public class ThemeSwitcherView extends Bean{
 
    private List<Theme> themes;
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
 
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
    
    public Theme defaultTheme() {
    	return themes.get(0);
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
 
    public void setService(ThemeService service) {
        this.service = service;
    }
}