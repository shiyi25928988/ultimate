package yi.shi.restapi;


import com.google.inject.Inject;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.service.DatabaseInitService;

@HttpService
public class DbInitApi {

    @Inject
    private DatabaseInitService databaseInitService;

    @POST
    @HttpPath("/api/db/init")
    public JSON<String> init() {
        databaseInitService.init();
        return new JSON<String>("success");
    }
}
