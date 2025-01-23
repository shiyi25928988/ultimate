package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.service.impl.ImageServiceImpl;

import java.util.List;

@ImplementedBy(ImageServiceImpl.class)
public interface ImageService {

    List<String> getImageList();
}
