package yi.shi.pages.element.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardData {

    String title;
    String content;
    String imageUrl;
    String linkUrl;
}
