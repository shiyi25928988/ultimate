package yi.shi.pages;

import j2html.tags.Tag;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;

@HttpService
public class HomePage {
    @GET
    @HttpPath(value = "/home")
    public static String homePage()
    {
        return "Hello World";
    }

    private static Tag generateBody(){
        return null;
    }

}
