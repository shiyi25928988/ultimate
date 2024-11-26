package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.service.impl.MarkdownFilesServiceImpl;

import java.util.List;

@ImplementedBy(MarkdownFilesServiceImpl.class)
public interface MarkdownFilesService {

    MarkdownFiles addNewMarkdown(MarkdownFiles markdownFiles);

    MarkdownFiles updateMarkdown(MarkdownFiles markdownFiles);

    List<MarkdownFiles> selectByUserId(Long userId);

    MarkdownFiles selectById(Long id);

    String renderMarkdown(String markdown);

    MarkdownFiles selectBySharedToken(String sharedToken);


    int update(MarkdownFiles markdownFiles);


}
