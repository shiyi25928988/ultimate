package yi.shi.service.impl;

import com.google.inject.Inject;
import yi.shi.db.mapper.MarkdownFilesMapper;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.service.MarkdownFilesService;

public class MarkdownFilesServiceImpl implements MarkdownFilesService {

    @Inject
    private MarkdownFilesMapper markdownFilesMapper;


    @Override
    public MarkdownFiles addNewMarkdown(MarkdownFiles markdownFiles) {
        markdownFilesMapper.insert(markdownFiles);
        return markdownFiles;
    }
}
