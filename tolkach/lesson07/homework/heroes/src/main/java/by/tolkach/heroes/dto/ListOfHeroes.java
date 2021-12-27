package by.tolkach.heroes.dto;

import by.tolkach.heroes.dto.File;
import by.tolkach.heroes.dto.Hero;
import jakarta.servlet.http.HttpServletRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfHeroes {
    private Integer id = 0;

    public Map<Integer, Hero> readHeroes(HttpServletRequest req) {
        by.tolkach.heroes.dto.File file = new by.tolkach.heroes.dto.File();
        Integer id = 0;
        Map<Integer,Hero> mapOfHeroes = new HashMap<>();

        file.getListOfHeroes(req);

        String[] list = new String[4];
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file.getListOfHeroes(req)))) {
            String result = reader.readLine();
            while (result != null) {
                list = result.split(";");
                Hero hero = new Hero();
                hero.setLogin(list[0]);
                hero.setName(list[1]);
                hero.setAge(list[2]);
                hero.setMale(list[3]);
                hero.setAbility(list[4]);
                mapOfHeroes.put(id,hero);
                id++;
                result = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapOfHeroes;
    }

    public void writeHero(Hero hero, HttpServletRequest request) {
        by.tolkach.heroes.dto.File file = new by.tolkach.heroes.dto.File();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file.getListOfHeroes(request),true))) {
            writer.write(hero.getLogin() + ";" + hero.getName() + ";" + hero.getAge() + ";" + hero.getMale() + ";"
            + hero.getAbility());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> listOfAbilities(HttpServletRequest req) {
        by.tolkach.heroes.dto.File file = new File();
        List<String> listOfAbilities = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file.getAbilities(req)))) {
            String result = reader.readLine();
            while (result != null) {
                listOfAbilities.add(result);
                result = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfAbilities;
    }
}
