package controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import resources.Theme;

@ManagedBean(name="themeService", eager = true)
@ApplicationScoped
public class ThemeService extends Bean{
     
    private List<Theme> themes;
     
    @PostConstruct
    public void init() {
        themes = new ArrayList<>();
        themes.add(new Theme(0, "Nova-Light", "nova-light"));
        themes.add(new Theme(1, "Nova-Dark", "nova-dark"));
        themes.add(new Theme(2, "Nova-Colored", "nova-colored"));
        themes.add(new Theme(3, "Luna-Blue", "luna-blue"));
        themes.add(new Theme(4, "Luna-Amber", "luna-amber"));
        themes.add(new Theme(5, "Luna-Green", "luna-green"));
        themes.add(new Theme(6, "Luna-Pink", "luna-pink"));
        themes.add(new Theme(7, "Omega", "omega"));
        themes.add(new Theme(8, "Afterdark"      ,"afterdark"));
        themes.add(new Theme(9, "Afternoon"      ,"afternoon"));
        themes.add(new Theme(10, "Afterwork"      ,"afterwork"));
        themes.add(new Theme(11, "Aristo"         ,"aristo"));
        themes.add(new Theme(12, "Black-Tie"      ,"black-tie"));
        themes.add(new Theme(13, "Blitzer"        ,"blitzer"));
        themes.add(new Theme(14, "Bluesky"        ,"bluesky"));
        themes.add(new Theme(15, "Bootstrap"      ,"bootstrap"));
        themes.add(new Theme(16, "Casablanca"     ,"casablanca"));
        themes.add(new Theme(17, "Cruze"          ,"cruze"));
        themes.add(new Theme(18, "Cupertino"      ,"cupertino"));
        themes.add(new Theme(19, "Dark-Hive"      ,"dark-hive"));
        themes.add(new Theme(20, "Delta"          ,"delta"));
        themes.add(new Theme(21, "Dot-Luv"        ,"dot-luv"));
        themes.add(new Theme(22, "Eggplant"       ,"eggplant"));
        themes.add(new Theme(23, "Excite-Bike"    ,"excite-bike"));
        themes.add(new Theme(24, "Flick"          ,"flick"));
        themes.add(new Theme(25, "Glass-X"        ,"glass-x"));
        themes.add(new Theme(26, "Home"           ,"home"));
        themes.add(new Theme(27, "Hot-Sneaks"     ,"hot-sneaks"));
        themes.add(new Theme(28, "Humanity"       ,"humanity"));
        themes.add(new Theme(29, "Le-Frog"        ,"le-frog"));
        themes.add(new Theme(30, "Midnight"       ,"midnight"));
        themes.add(new Theme(31, "Mint-Choc"      ,"mint-choc"));
        themes.add(new Theme(32, "Omega"          ,"omega"));
        themes.add(new Theme(33, "Overcast"       ,"overcast"));
        themes.add(new Theme(34, "Pepper-Grinder" ,"pepper-grinder"));
        themes.add(new Theme(35, "Redmond"        ,"redmond"));
        themes.add(new Theme(36, "Rocket"         ,"rocket"));
        themes.add(new Theme(37, "Sam"            ,"sam"));
        themes.add(new Theme(38, "Smoothness"     ,"smoothness"));
        themes.add(new Theme(39, "South-Street"   ,"south-street"));
        themes.add(new Theme(40, "Start"          ,"start"));
        themes.add(new Theme(41, "Sunny"          ,"sunny"));
        themes.add(new Theme(42, "Swanky-Purse"   ,"swanky-purse"));
        themes.add(new Theme(43, "Trontastic"     ,"trontastic"));
        themes.add(new Theme(44, "Ui-Darkness"    ,"ui-darkness"));
        themes.add(new Theme(45, "Ui-Lightness"   ,"ui-lightness"));
        themes.add(new Theme(46, "Vader"          ,"vader"));
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
}