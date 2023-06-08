package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:auth.properties"
})
public interface AuthConfig extends Config {

    @Key("usernameTestRail")
    String usernameTestRail();

    @Key("passwordTestRail")
    String passwordTestRail();

    @Key("recently_viewed_entities")
    String recently_viewed_entities();

    @Key("tr_session")
    String tr_session();

    @Key("tr_rememberme")
    String tr_rememberme();


}
