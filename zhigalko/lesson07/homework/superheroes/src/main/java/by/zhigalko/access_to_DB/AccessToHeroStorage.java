package by.zhigalko.access_to_DB;

import by.zhigalko.storage.HeroStorage;
import jakarta.servlet.ServletConfig;

public interface AccessToHeroStorage extends ServletConfig {
    default HeroStorage getAccessToHeroStorage() {
        HeroStorage hero_db = (HeroStorage) getServletContext().getAttribute("hero_storage");
        if (hero_db == null) {
            String heroStorageName = getServletContext().getInitParameter("hero_storage");
            if (heroStorageName.equals(HeroStorage.class.getName())) {
                hero_db = HeroStorage.getInstance();
            }
        }
        return hero_db;
    }
}
