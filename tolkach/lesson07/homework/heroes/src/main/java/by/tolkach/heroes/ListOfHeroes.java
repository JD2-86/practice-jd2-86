package by.tolkach.heroes;

import jakarta.servlet.http.HttpServletRequest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ListOfHeroes {
    private Integer id = 0;

    public Map<Integer,Hero> readHeroes(HttpServletRequest req) {
        File file = new File();
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
}
