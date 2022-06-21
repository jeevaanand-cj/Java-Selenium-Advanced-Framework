package com.gcit.enums;

/**
 * Enums to restrict the values used on Property files. Without using enums there can be create null pointer exceptions
 * because of typos.
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.
 * 
 * 
 * May 26, 2022
 * @author Jeeva Chandhran
 * @version 1.0
 * @since 1.0<br>
 * @see com.gcit.utils.PropertyUtils
 */

public enum ConfigProperties {
    AMAZONURL,
    ORANGEURL,
    BROWSER,
    OVERRIDEREPORTS,
    PASSEDSTEPSCREENSHOTS,
    FAILEDSTEPSCREENSHOT,
    SKIPPEDSTEPSCREENSHOT,
    RETRYFAILEDTESTS,
    RUNMODE,
    SENDRESULTKIBANA,
    SELENIUMGRIDURL,
    ELASTICSEARCHURL,
    SELENOIDURL,
    HOSTNAME,
    PORT,
    SCHEMA,
    DBUSERNAME,
    DBPASSWORD
}
