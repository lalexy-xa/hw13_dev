package org.example;

import org.example.config.DbConfig;
import org.example.config.HibernateConfig;
import org.flywaydb.core.Flyway;

public class Migration {

    private static Flyway fly;
    private static volatile Migration INSTANCE;



    public Migration(){
        DbConfig config = new DbConfig();
        fly = Flyway.configure()
                .dataSource(config.getDbUrlConfigKey(), config.getDbUserConfigKey(), config.getDbPasswordConfigKey())
                .cleanDisabled(false)
                .load();
    }

    public static Migration getInstance(){
        if (INSTANCE == null){
            synchronized (Migration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Migration();
                }
            }
        }
        return INSTANCE;
    }

    public void repair(){
        fly.repair();
    }
    public  void migrate(){
        fly.migrate();
    }

    public void clean(){
        fly.clean();
    }
}
