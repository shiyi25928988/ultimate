package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.service.impl.MarkdownFilesServiceImpl;

@ImplementedBy(MarkdownFilesServiceImpl.class)
public interface MarkdownFilesService {

    MarkdownFiles addNewMarkdown(MarkdownFiles markdownFiles);
}
