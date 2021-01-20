package web.witcher.Configuration;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;

public class MyPostgreSQLDialect extends PostgreSQL10Dialect {

    public MyPostgreSQLDialect(){
        super();
        registerFunction("battle", new StandardSQLFunction("battle"));
    }
}
