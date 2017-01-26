package org.executequery.databaseobjects.impl;

import org.executequery.databaseobjects.DatabaseMetaTag;
import org.executequery.databaseobjects.DatabaseProcedure;
import org.firebirdsql.jdbc.FBDatabaseMetaData;
import org.firebirdsql.jdbc.FirebirdDatabaseMetaData;
import org.underworldlabs.jdbc.DataSourceException;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by vasiliy on 26.01.17.
 */
public class DefaultDatabaseTrigger extends DefaultDatabaseExecutable
        implements DatabaseProcedure {

    private String triggerSourceCode;

    /**
     * Creates a new instance.
     */
    public DefaultDatabaseTrigger() {}

    /**
     * Creates a new instance.
     */
    public DefaultDatabaseTrigger(DatabaseMetaTag metaTagParent, String name) {
        super(metaTagParent, name);
    }

    /**
     * Creates a new instance with
     * the specified values.
     */
    public DefaultDatabaseTrigger(String schema, String name) {
        setName(name);
        setSchemaName(schema);
    }

    /**
     * Returns the database object type.
     *
     * @return the object type
     */
    public int getType() {
        return TRIGGER;
    }

    /**
     * Returns the meta data key name of this object.
     *
     * @return the meta data key name.
     */
    public String getMetaDataKey() {
        return META_TYPES[TRIGGER];
    }

    public String getTriggerSourceCode() {
        if (!isMarkedForReload() && triggerSourceCode != null) {

            return triggerSourceCode;
        }

        triggerSourceCode = "";

        try {

            DatabaseMetaData dmd = getMetaTagParent().getHost().getDatabaseMetaData();

            String _catalog = getCatalogName();
            String _schema = getSchemaName();


            if (dmd instanceof FBDatabaseMetaData) {
                FirebirdDatabaseMetaData fbMetaData = (FirebirdDatabaseMetaData)dmd;
                triggerSourceCode = fbMetaData.getTriggerSourceCode(getName());
            }

            return triggerSourceCode;

        } catch (SQLException e) {

            throw new DataSourceException(e);

        } finally {

            setMarkedForReload(false);
        }
    }

}
