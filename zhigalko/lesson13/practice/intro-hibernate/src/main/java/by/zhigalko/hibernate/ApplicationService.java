package by.zhigalko.hibernate;

import by.zhigalko.hibernate.dal.dao.BaseDao;
import by.zhigalko.hibernate.dal.dao.PaintingDaoImpl;
import by.zhigalko.hibernate.dal.entity.Painting;
import by.zhigalko.hibernate.util.SessionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ApplicationService {
    private static final Logger log = LogManager.getLogger(ApplicationService.class);

    public void run() {
        Painting malevichSquare = new Painting(0L,"Черный квадрат","Казимир Малевич");
        BaseDao<Painting> paintingDao = new PaintingDaoImpl();
        paintingDao.save(malevichSquare);

        Painting painting = paintingDao.findById(malevichSquare.getId());
        log.debug(painting);
        malevichSquare.setAuthorName("Kazimir Malevich");
        paintingDao.update(malevichSquare);

        paintingDao.delete(painting);

        List<Painting> paintings = paintingDao.findAll();
        log.debug(paintings);
        SessionManager.close();
    }
}

