package yi.shi.pages.normal;

import com.google.inject.Inject;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.MainTag;
import yi.shi.db.model.Album;
import yi.shi.pages.Page;
import yi.shi.pages.component.Head;
import yi.shi.pages.element.card.CardData;
import yi.shi.pages.element.card.GeneralCard;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.AlbumService;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

@HttpService
public class AlbumsPage extends Page {

    @Inject
    AlbumService albumService;

    @GET
    @HttpPath(value = "/page/albums")
    public HTML albumsPage() throws Exception {

        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("Albums");
    }

    @Override
    protected MainTag createMain() throws Exception {
        List<Album> albums = albumService.getAllAlbums();
        List<CardData> cards = new ArrayList<>(albums.size());
        for (Album album : albums) {
            cards.add(new CardData(album.getAlbumName(), album.getAlbumDesc(), album.getCoverUrl(), "/page/albumDetailPage?id=" + album.getId()));
        }
        if (albums != null) {
            return main().with(
                    GeneralCard.createCardsDivTag(cards)
            );
        }

        return null;
    }
}
