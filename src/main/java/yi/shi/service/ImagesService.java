package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.Images;
import yi.shi.service.impl.ImagesServiceImpl;

import java.util.List;

@ImplementedBy(ImagesServiceImpl.class)
public interface ImagesService {

    Images addImages(Images images);
    void deleteImages(Long id);
    Images getImagesById(Long id);
    List<Images> getImagesByAlbumId(Long albumId);
}
