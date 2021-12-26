package by.zhigalko.access_to_DB;

import by.zhigalko.storage.AbilityStorage;
import jakarta.servlet.ServletConfig;

public interface AccessToAbilityStorage extends ServletConfig {
    default AbilityStorage getAccessToAbilityStorage() {
        AbilityStorage ability_db = (AbilityStorage) getServletContext().getAttribute("ability_storage");
        if (ability_db == null) {
            String abilityStorageName = getServletContext().getInitParameter("ability_storage");
            if (abilityStorageName.equals(AbilityStorage.class.getName())) {
                ability_db = AbilityStorage.getInstance();
            }
        }
        return ability_db;
    }
}
