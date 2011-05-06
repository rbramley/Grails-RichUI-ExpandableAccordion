import groovy.xml.MarkupBuilder
import de.andreasschmitt.richui.taglib.renderer.AccordionItemRenderer
import de.andreasschmitt.richui.taglib.renderer.RenderException

/**
 * Allow for an 'expanded' attribute for pre-expansion of a group. 
 * @author Robin Bramley
 *
 */
public class ExpandableAccordionItemRenderer extends AccordionItemRenderer {
	protected void renderTagContent(Map attrs, Closure body, MarkupBuilder builder) throws RenderException {
			
		if(attrs.expanded) {
			builder.dt("class": "a-m-t a-m-t-expand", "id": "${attrs?.id}", "${attrs?.caption}")
			builder.dd("class": "a-m-d a-m-d-expand"){
				builder."div"("class": "bd"){
					builder.yield("${body.call()}", false)
				}
			}
		} else {
			builder.dt("class": "a-m-t", "id": "${attrs?.id}", "${attrs?.caption}")
			builder.dd("class": "a-m-d"){
				builder."div"("class": "bd"){
					builder.yield("${body.call()}", false)
				}
			}
		}
	}
}