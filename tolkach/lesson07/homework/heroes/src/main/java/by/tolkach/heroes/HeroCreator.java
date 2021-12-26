package by.tolkach.heroes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/create-hero")
public class HeroCreator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        File file = new File();
        Integer id = 0;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file.getAbilities(req)))) {
            String result = reader.readLine();
            while (result != null) {
                req.setAttribute("abil" + id, result);
                result = reader.readLine();
                id++;
            }
            req.setAttribute("Count", id);
        } catch (IOException e) {
            e.printStackTrace();
        }



//        ListOfHeroes listOfHeroes = new ListOfHeroes();
//        Map<Integer, Hero> map = listOfHeroes.readHeroes(req);
//        Hero hero = new Hero();

//        for (Integer i = 0; i < map.size(); i++) {
//            req.setAttribute("Ability" + i,map.get(i).getAbility());
//        }
//        req.setAttribute("CountOfHeroes", map.size());

        String path = "/WEB-INF/jsp/creator.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).include(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hero hero = new Hero();
        ListOfHeroes listOfHeroes = new ListOfHeroes();

        hero.setLogin(req.getParameter("login"));
        hero.setName(req.getParameter("name"));
        hero.setAge(req.getParameter("age"));
        hero.setMale(req.getParameter("male"));
        hero.setAbility(req.getParameter("abil"));

        listOfHeroes.writeHero(hero,req);

        String path = "/WEB-INF/jsp/creator.jsp";
        ServletContext servletContext = req.getServletContext();
        servletContext.getRequestDispatcher(path).forward(req,resp);
    }
}
