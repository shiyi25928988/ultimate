package yi.shi.restapi;

import yi.shi.crawler.YCrawlerStarter;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;

@HttpService
public class YCrawlerServiceApi {

    @POST
    @GET
    @HttpPath(value = "/crawl")
    public String crawl(@HttpParam("url") String url) throws Exception {
        YCrawlerStarter starter = new YCrawlerStarter();
        starter.addSeed(url);
        starter.start(1);
        return "ok";
    }
}
